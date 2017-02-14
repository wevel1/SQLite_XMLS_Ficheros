package com.example.dm2.ejercicios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class RssParserDom {
    private URL rssUrl;

    public RssParserDom(String url) {
        try
        {
            this.rssUrl = new URL(url);
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Tiempo> parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        List<Tiempo> tiempos = new ArrayList<Tiempo>();

        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document dom = builder.parse(this.getInputStream());
            Element root = dom.getDocumentElement();
            NodeList dias = root.getElementsByTagName("dia");

            for (int j=0;j<dias.getLength();j++)
            {
                Tiempo tiempo = new Tiempo();
                Node diaActual = dias.item(j);
                String fecha = obtenerAtributo(diaActual,"fecha");
                tiempo.setDia(fecha);

                if (diaActual instanceof Element)
                {
                    Element elementoDia = (Element)diaActual;
                    Node temperatura = getNode("temperatura",elementoDia);
                    if (temperatura instanceof  Element)
                    {
                        Element elementoTemp = (Element)temperatura;
                        String maxima = getValorNodo("maxima",elementoTemp);
                        String minima = getValorNodo("minima",elementoTemp);
                        tiempo.setMaxima(maxima);
                        tiempo.setMinima(minima);
                    }
                }
                tiempos.add(tiempo);
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }

        return tiempos;
    }

    private Node getNode(String etiqueta, Element elemento){
        NodeList temperatura = elemento.getElementsByTagName(etiqueta);
        return temperatura.item(0);
    }

    private String getValorNodo(String etiqueta, Element elem) {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = nodo.item(0);
        return	valornodo.getNodeValue().toString();
    }

    private String obtenerAtributo(Node nodo, String atributo) {
        NamedNodeMap nnm=nodo.getAttributes();
        Node dato = nnm.getNamedItem("fecha");
        String s=dato.getNodeValue();
        return s.toString();
    }

    private InputStream getInputStream() {
        try
        {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
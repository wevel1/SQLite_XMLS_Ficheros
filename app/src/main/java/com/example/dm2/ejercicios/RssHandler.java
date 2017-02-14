package com.example.dm2.ejercicios;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class RssHandler extends DefaultHandler {
    private List<Noticia> noticias;
    private Noticia noticia;
    private StringBuilder str;

    public List<Noticia> getNoticias(){
        return noticias;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (this.noticia != null)
            str.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);

        if (this.noticia != null) {

            if (localName.equals("title")) {
                noticia.setTitulo(str.toString());
            } else if (localName.equals("link")) {
                noticia.setLink(str.toString());
            } else if (localName.equals("description")) {
                noticia.setDescripcion(str.toString());
            } else if (localName.equals("guid")) {
                noticia.setGuid(str.toString());
            } else if (localName.equals("pubDate")) {
                noticia.setFecha(str.toString());
            } else if (localName.equals("item")) {
                noticias.add(noticia);
            }

            str.setLength(0);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        noticias = new ArrayList<Noticia>();
        str = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);

        if (localName.equals("item")) {
            noticia = new Noticia();
        }
    }
}

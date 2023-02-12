package com.example.converter.controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class ParseRatesController {

    private final static String URL = "http://www.cbr.ru/scripts/XML_daily.asp";
    private final int[] ids = new int[]{14,22};

    public String[] getRates(){
        String[] rates = new String[2];
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(URL).openStream());

            NodeList list = doc.getElementsByTagName("Valute");
            for (int i = 0; i < 2; i++){
                Node node = list.item(ids[i]);
                Element element = (Element) node;
                rates[i] = element.getElementsByTagName("Value").item(0).getTextContent().replace(",",".");
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
        return rates;
    }
}

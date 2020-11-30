package entities;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private final List<Flower> flowers = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("flower")){
            String title = attributes.getValue("title");
            String type = attributes.getValue("type");
            String color = attributes.getValue("color");
            int cost = Integer.parseInt(attributes.getValue("cost"));

            flowers.add(new Flower(title,type,color,cost));
        }
    }

    public List<Flower> getMyFlowers() {
        return flowers;
    }
}

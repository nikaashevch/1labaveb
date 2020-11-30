import entities.Flower;
import entities.FlowerShop;
import entities.MyHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        MyHandler handler = new MyHandler();
        parser.parse(new File("src\\resources\\flowers.xml"), handler);

        FlowerShop flowerShop = new FlowerShop(handler.getMyFlowers());


        ArrayList<Flower> order = new ArrayList<>();
        System.out.println("Заказ:");
        for(int i = 0; i<3;i++){
            Flower orderedFlower = new Flower("Dandelion","1 type","White",10);
            order.add(orderedFlower);
            System.out.println(orderedFlower.toString());
        }
        System.out.println("-------------------------");
        System.out.println("Сумма заказа - "+flowerShop.makeOrder(order));
    }
}

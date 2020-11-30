package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlowerShop implements Serializable {
    private List<Flower> flowers;

    public FlowerShop(){
        flowers = new ArrayList<>();
    }

    public FlowerShop(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addFlowers(Flower flower){
        flowers.add(flower);
    }

    public void addAllFlowers(Collection<? extends Flower> flowers){
        this.flowers.addAll(flowers);
    }

    public int makeOrder(List<Flower> flowers){
        if(OrderMakable(flowers)){
            int orderCost = 0;
            for(Flower flower:flowers){
                orderCost+=flower.getCost();
                this.flowers.remove(flower);
            }
            return orderCost;
        }
        System.out.println("Заказ невозможен");
        return 0;
    }

    public boolean OrderMakable(List<Flower> flowers){
        boolean orderMakable = true;
        List<Flower> existedFlowers = this.flowers.subList(0,this.flowers.size());//Суть в том что нужен клон
        for(Flower flower:flowers){
            orderMakable &= existedFlowers.contains(flower);
            existedFlowers.remove(flower);
            if(!orderMakable) break;//Не буду писать скобочки потому что очень не красиво
        }
        return orderMakable;
    }
}
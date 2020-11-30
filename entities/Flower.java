package entities;

import java.io.Serializable;
import java.util.Objects;

public class Flower implements Serializable {
    private String title;
    private String type;
    private String color;
    private int cost;

    public Flower(String title, String type, String color, int cost) {
        this.title = title;
        this.type = type;
        this.color = color;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(title);
        sb.append(" ").append(type);
        sb.append(" ").append(color);
        sb.append("|").append(cost);
        return sb.toString();
    }

    @Override//Автоматическое переопределение идеи
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return cost == flower.cost &&
                Objects.equals(title, flower.title) &&
                Objects.equals(type, flower.type) &&
                Objects.equals(color, flower.color);
    }
}

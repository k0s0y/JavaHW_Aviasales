package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor


public class TicketsInfo implements Comparable <TicketsInfo> {
    private int id;
    private int price;
    private String portOut;
    private String portIn;
    private int minsInFly;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPortOut() {
        return portOut;
    }

    public void setPortOut(String portOut) {
        this.portOut = portOut;
    }

    public String getPortIn() {
        return portIn;
    }

    public void setPortIn(String portIn) {
        this.portIn = portIn;
    }

    public int getMinsInFly() {
        return minsInFly;
    }

    public void setMinsInFly(int minsInFly) {
        this.minsInFly = minsInFly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsInfo that = (TicketsInfo) o;
        return id == that.id && price == that.price && Objects.equals(portOut, that.portOut) && Objects.equals(portIn, that.portIn) && Objects.equals(minsInFly, that.minsInFly);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, portOut, portIn, minsInFly);
    }

    @Override
    public String toString() {
        return "TicketsInfo{" +
                "id=" + id +
                ", price=" + price +
                ", portOut='" + portOut + '\'' +
                ", portIn='" + portIn + '\'' +
                ", minsInFly='" + minsInFly + '\'' +
                '}';
    }

    @Override
    public int compareTo(TicketsInfo o) {
        return this.price - o.price;
    }
}

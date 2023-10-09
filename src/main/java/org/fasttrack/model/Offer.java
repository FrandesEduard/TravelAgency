package org.fasttrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private int offerId;
    private String name;
    private String destination;
    private int price;
    private int lengthOfStay;

    public Offer() {
    }

    public Offer(int offerId, String name, String destination, int price, int lengthOfStay) {
        this.offerId = offerId;
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.lengthOfStay = lengthOfStay;
    }

    public Offer(String name, String destination, int price, int lengthOfStay) {
        this.name = name;
        this.destination = destination;
        this.price = price;
        this.lengthOfStay = lengthOfStay;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }
}
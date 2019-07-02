package com.epam.hud.entity;

import java.util.ArrayList;


public class AnimeShop {
    private String shopName;
    private String shopAddress;
    private int numberOfToys;
    private int toyPrice;
    private ArrayList<com.epam.hud.entity.AnimeToy> animeToys = new ArrayList<>();
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public int getNumberOfToys() {
        return numberOfToys;
    }

    public void setNumberOfToys(int numberOfToys) {
        this.numberOfToys = numberOfToys;
    }

    public int getToyPrice() {
        return toyPrice;
    }

    public void setToyPrice(int toyPrice) {
        this.toyPrice = toyPrice;
    }

    public ArrayList<com.epam.hud.entity.AnimeToy> getAnimeToys() {
        return animeToys;
    }

    public void setAnimeToys(ArrayList<com.epam.hud.entity.AnimeToy> animeToys) {
        this.animeToys = animeToys;
    }

    public int getTempNumber() {
        return animeToys.size();
    }


    public void addToy(com.epam.hud.entity.AnimeToy animeToy) {
        animeToys.add(animeToy);
    }

    public void printToyArray() {
        for (int i = 0; i < animeToys.size(); i++) {
            System.out.println(animeToys.get(i));
        }
    }

    @Override
    public String toString() {
        return "AnimeShop{" +
                "shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", numberOfToys=" + numberOfToys +
                ", toyPrice=" + toyPrice +
                ", animeToys=" + animeToys +
                ", tempNumber=" + animeToys.size() +
                '}';
    }
}


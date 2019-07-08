package com.epam.hud.entity;

import java.io.Serializable;
import java.util.ArrayList;


public class AnimeShop implements Serializable {
    private String shopName;
    private String shopAddress;
    private ArrayList<AnimeToy> animeToys = new ArrayList<>();

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

    public ArrayList<AnimeToy> getAnimeToys() {
        return animeToys;
    }

    public void setAnimeToys(ArrayList<AnimeToy> animeToys) {
        this.animeToys = animeToys;
    }

    public int getTempNumber() {
        return animeToys.size();
    }


    public void addToy(AnimeToy animeToy) {
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
                ", animeToys=" + animeToys +
                ", tempNumber=" + animeToys.size() +
                '}';
    }
}


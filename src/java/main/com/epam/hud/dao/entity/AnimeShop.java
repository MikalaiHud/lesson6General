package com.epam.hud.dao.entity;


import java.io.Serializable;
import java.util.ArrayList;


public class AnimeShop implements Serializable {
    private int id;
    private String shopName;
    private String shopAddress;
    private ArrayList<AnimeToy> animeToys = new ArrayList<>();

    public AnimeShop(int id, String shopName, String shopAddress, ArrayList<AnimeToy> animeToys) {
        this.id = id;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.animeToys = animeToys;
    }

    public AnimeShop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", animeToys=" + animeToys +
                '}';
    }

}


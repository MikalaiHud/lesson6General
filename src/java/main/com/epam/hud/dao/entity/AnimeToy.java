package com.epam.hud.dao.entity;

import java.io.Serializable;


public class AnimeToy implements Serializable {
    private Type toyType;
    private Fandom toyFandom;
    private String toyName;
    private int toyPrice;
    private int id;
    private int shopId;

    public AnimeToy(Type toyType, Fandom toyFandom, String toyName, int toyPrice, int id, int shopId) {
        this.toyType = toyType;
        this.toyFandom = toyFandom;
        this.toyName = toyName;
        this.toyPrice = toyPrice;
        this.id = id;
        this.shopId = shopId;
    }

    public AnimeToy() {

    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getToyType() {
        return toyType;
    }

    public void setToyType(Type toyType) {
        this.toyType = toyType;
    }

    public Fandom getToyFandom() {
        return toyFandom;
    }

    public void setToyFandom(Fandom toyFandom) {
        this.toyFandom = toyFandom;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getToyPrice() {
        return toyPrice;
    }

    public void setToyPrice(int toyPrice) {
        this.toyPrice = toyPrice;
    }

    @Override
    public String toString() {
        return "AnimeToy{" +
                "toyType=" + toyType +
                ", toyFandom=" + toyFandom +
                ", toyName='" + toyName + '\'' +
                ", toyPrice=" + toyPrice +
                ", id=" + id +
                ", shopId=" + shopId +
                '}';
    }
}

package com.epam.hud.entity;

import java.io.Serializable;

public class AnimeToy implements Serializable {
    private Type toyType;
    private Fandom toyFandom;
    private String toyName;
    private int toyPrice;

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
                "toyType='" + toyType + '\'' +
                ", toyFandom='" + toyFandom + '\'' +
                ", toyName='" + toyName + '\'' +
                ", toyPrice ='" + toyPrice + '\'' +
                '}';
    }
}

package com.epam.hud.entity;

import java.io.Serializable;

public class AnimeToy implements Serializable {
    private String toyType;
    private String toyFandom;
    private String toyName;

    public String getToyType() {
        return toyType;
    }

    public void setToyType(String toyType) {
        this.toyType = toyType;
    }

    public String getToyFandom() {
        return toyFandom;
    }

    public void setToyFandom(String toyFandom) {
        this.toyFandom = toyFandom;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public String toString() {
        return "AnimeToy{" +
                "toyType='" + toyType + '\'' +
                ", toyFandom='" + toyFandom + '\'' +
                ", toyName='" + toyName + '\'' +
                '}';
    }
}

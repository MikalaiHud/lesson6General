package com.epam.hud.generators;

import com.epam.hud.dao.entity.AnimeShop;

import java.util.Random;

public class ShopGenerators {

    private static String generateRandomShopName() {
        int random = new Random().nextInt(4);
        switch (random) {
            case 0:
                return "Alpha";
            case 1:
                return "Bravo";
            case 2:
                return "Charlie";
            case 3:
                return "Delta";
            case 4:
                return "Echo";
            default:
                return null;
        }
    }

    private static String generateRandomShopAddress() {
        int random = new Random().nextInt(4);
        switch (random) {
            case 0:
                return "Alpha";
            case 1:
                return "Bravo";
            case 2:
                return "Charlie";
            case 3:
                return "Delta";
            case 4:
                return "Echo";
            default:
                return null;
        }
    }

    public AnimeShop generateRandomShop() {
        AnimeShop shop = new AnimeShop();
        shop.setShopName(generateRandomShopName());
        shop.setShopAddress(generateRandomShopAddress());
        return shop;
    }
}



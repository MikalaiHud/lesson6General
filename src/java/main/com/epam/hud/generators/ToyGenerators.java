package com.epam.hud.generators;

import com.epam.hud.dao.entity.AnimeToy;
import com.epam.hud.dao.entity.Fandom;
import com.epam.hud.dao.entity.Type;

import java.util.Random;

import static com.epam.hud.dao.entity.Fandom.*;
import static com.epam.hud.dao.entity.Type.*;

public class ToyGenerators {

    private static Type generateRandomToyType() {
        int random = new Random().nextInt(5);
        switch (random) {
            case 0:
                return ACTION_FIGURE;
            case 1:
                return NENDOROID;
            case 2:
                return COMPLETED_MODEL;
            case 3:
                return TRADING_FIGURE;
            case 4:
                return GAME_PRIZE;
            case 5:
                return GARAGE_KITS;
            default:
                return null;
        }
    }

    private static Fandom generateRandomToyFandom() {
        int random = new Random().nextInt(7);
        switch (random) {
            case 0:
                return NARUTO;
            case 1:
                return BLEACH;
            case 2:
                return ONE_PIECE;
            case 3:
                return BLACK_BUTLER;
            case 4:
                return TOKYO_GHOUL;
            case 5:
                return GINTAMA;
            case 6:
                return FAIRY_TALE;
            case 7:
                return ATTACK_ON_TITAN;
                default: return null;
        }
    }

    private static String generateRandomToyName() {
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

    private static int generateRandomToyPrice() {
        int random = new Random().nextInt(100);
        return random;
    }

    public AnimeToy generateRandomToy(int shopId) {
        AnimeToy toy = new AnimeToy();
        toy.setToyFandom(generateRandomToyFandom());
        toy.setToyPrice(generateRandomToyPrice());
        toy.setToyName(generateRandomToyName());
        toy.setToyType(generateRandomToyType());
        toy.setShopId(shopId);
        return toy;
    }
}



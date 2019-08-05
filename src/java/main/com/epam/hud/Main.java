package com.epam.hud;

import com.epam.hud.dao.entity.AnimeShop;
import com.epam.hud.dao.entity.AnimeToy;
import com.epam.hud.dao.implement.ShopDAOImpl;
import com.epam.hud.dao.implement.ToyDAOImpl;
import com.epam.hud.generators.ShopGenerators;
import com.epam.hud.generators.ToyGenerators;
import com.epam.hud.logic.ShopManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Work with DB");
        System.out.println();

        ToyDAOImpl tdi = new ToyDAOImpl();
        ShopDAOImpl sdi = new ShopDAOImpl();
        ShopGenerators sg = new ShopGenerators();
        ToyGenerators tg = new ToyGenerators();

        AnimeShop shop1 = sg.generateRandomShop();
        System.out.println("generated shop:");
        System.out.println(shop1);
        AnimeToy toy1 = tg.generateRandomToy(sdi.readAllShops().get(0).getId());
        System.out.println("generated toy");
        System.out.println(toy1);
        System.out.println();

        System.out.println("ShopDAOImpl check");
        sdi.createShop(shop1);
        sdi.updateShop(31, shop1);
        sdi.deleteShop(120);
        System.out.println("shop 150:");
        System.out.println(sdi.readShop(150));
        System.out.println("all shops:");
        System.out.println(sdi.readAllShops());
        System.out.println("ToyDAOImpl check");
        tdi.createToy(toy1);
        tdi.updateToy(20, toy1);
        tdi.deleteToy(20);
        System.out.println("toy 21:");
        System.out.println(tdi.readToy(21));
        System.out.println("all toys:");
        System.out.println(tdi.readAllToys());
        System.out.println();

        System.out.println("ShopManager check");
        ShopManager sm = new ShopManager();
        System.out.println("All shops:");
        System.out.println(sm.getAllShops());
        sm.addShop(shop1);
        sm.editShopByIndex(50, shop1);
        System.out.println("toyTypeAveragePrice");
        System.out.println(sm.toyTypeAveragePrice(toy1.getToyType()));
        System.out.println("getAllShops");
        System.out.println(sm.getAllShops());
        System.out.println("getAllToys");
        System.out.println(sm.getAllToys());
        System.out.println("getCertainFigures");
        System.out.println(sm.getCertainFigures(toy1));
        System.out.println("getCertainShops");
        System.out.println(sm.getCertainShops(shop1));
        System.out.println("toyGenPrice");
        System.out.println(sm.toyGenPrice());
        System.out.println("getNamesAndFandomsOfCertainTypeOfToys");
        System.out.println(sm.getNamesAndFandomsOfCertainTypeOfToys(toy1.getToyType()));
        System.out.println("getNamesOfCertainFandomOfToys");
        System.out.println(sm.getNamesOfCertainFandomOfToys(toy1.getToyFandom()));
        System.out.println("getShopAddressById");
        System.out.println(sm.getShopAddressById(50));
        System.out.println("getShopNameById");
        System.out.println(sm.getShopNameById(50));
        System.out.println("getTempShopNumber");
        System.out.println(sm.getTempShopNumber());
        System.out.println("expensiveToy");
        System.out.println(sm.expensiveToy());
        System.out.println("cheapToy");
        System.out.println(sm.cheapToy());
        System.out.println("getToysByShopId");
        System.out.println(sm.getToysByShopId(19));
        System.out.println("getShop");
        System.out.println(sm.getShop(50));
    }
}
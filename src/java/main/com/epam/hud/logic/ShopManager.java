package com.epam.hud.logic;

import com.epam.hud.dao.db.ConnectionPool;
import com.epam.hud.dao.entity.AnimeShop;
import com.epam.hud.dao.entity.AnimeToy;
import com.epam.hud.dao.implement.ShopDAOImpl;
import com.epam.hud.dao.implement.ToyDAOImpl;
import com.epam.hud.dao.interfaces.ShopDAO;
import com.epam.hud.dao.interfaces.ToyDAO;
import com.epam.hud.exception.AnimeException;
import com.epam.hud.dao.entity.Type;
import com.epam.hud.dao.entity.Fandom;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ShopManager implements Serializable {


    private ArrayList<AnimeShop> shops = new ArrayList<>();

    public ArrayList<AnimeShop> getAllShopsFromDB() {
        ShopDAO shopDAO = new ShopDAOImpl();
        return shopDAO.readAllShops();
    }

    public int getTempShopNumber() {
        ShopDAO shopDAO = new ShopDAOImpl();
        ArrayList<AnimeShop> shops = shopDAO.readAllShops();
        return shops.size();
    }

    public void addShop(AnimeShop shop) {
        ShopDAO shopDAO = new ShopDAOImpl();
        shopDAO.createShop(shop);
    }

    public void editShopByIndex(int index, AnimeShop newShop) {
        ShopDAO shopDAO = new ShopDAOImpl();
        shopDAO.updateShop(index, newShop);
    }

    public AnimeShop getShop(int index) {
        ShopDAO shopDAO = new ShopDAOImpl();
        return shopDAO.readShop(index);
    }

    public String getShopAddressById(int id) {
        ShopDAO shopDAO = new ShopDAOImpl();
        AnimeShop shop = shopDAO.readShop(id);
        return shop.getShopAddress();
    }

    public String getShopNameById(int id) {
        ShopDAO shopDAO = new ShopDAOImpl();
        AnimeShop shop = shopDAO.readShop(id);
        return shop.getShopName();
    }

    public ArrayList<AnimeToy> getAllToysFromDB() {
        ToyDAO toyDAO = new ToyDAOImpl();
        return toyDAO.readAllToys();
    }

    public AnimeToy getToyWithMaxPrice() {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> toys = toyDAO.readAllToys();
        int maxPriceId = 0;
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getToyPrice() > maxPriceId) {
                maxPriceId = i;
            }
        }
        return toyDAO.readToy(maxPriceId);
    }

    public AnimeToy getToyWithMinPrice() {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> toys = toyDAO.readAllToys();
        int minPriceId = 0;
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getToyPrice() > minPriceId) {
                minPriceId = i;
            }
        }
        return toyDAO.readToy(minPriceId);
    }

    public ArrayList<AnimeToy> getNamesAndFandomsOfCertainTypeOfToys(Type type) {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> toys = toyDAO.readAllToys();
        ArrayList<AnimeToy> toys1 = new ArrayList<>();
        for (int i = 0; i < toys.size(); i++) {
            if (type.equals(toys.get(i).getToyType())) {
                toys1.add(toys.get(i));
            }
        }
        return toys1;
    }

    public int getGeneralPriceOfToys() {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> toys = toyDAO.readAllToys();
        int genPrice = 0;
        for (int i = 0; i < toys.size(); i++) {
            genPrice += toys.get(i).getToyPrice();
        }
        return genPrice;
    }

    public ArrayList<AnimeToy> getNamesOfCertainFandomOfToys(Fandom fandom) {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> allToys = toyDAO.readAllToys();
        ArrayList<AnimeToy> toys = new ArrayList<>();
        for (int i = 0; i < allToys.size(); i++) {
            if (fandom.equals(allToys.get(i).getToyFandom())) {
                toys.add(allToys.get(i));
            }
        }
        return toys;
    }

    public double calculatingAveragePriceOfCertainTypeOfToy(Type type) {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> toys = toyDAO.readAllToys();
        int genPrice = 0;
        int numberOfSuitableToys = 0;
        for (int i = 0; i < toys.size(); i++) {
            if (type.equals(toys.get(i).getToyType())) {
                genPrice += toys.get(i).getToyPrice();
                numberOfSuitableToys++;
            }
        }
        if (numberOfSuitableToys == 0) {
            return 0;
        } else {
            return genPrice / numberOfSuitableToys;
        }
    }

    public ArrayList<AnimeToy> getCertainFigures(AnimeToy animeToy) {
        ToyDAO toyDAO = new ToyDAOImpl();
        ArrayList<AnimeToy> allToys = toyDAO.readAllToys();
        ArrayList<AnimeToy> toys = new ArrayList<>();
        for (int i = 0; i < allToys.size(); i++) {
            if (allToys.get(i).getToyType().equals(animeToy.getToyType()) && allToys.get(i).getToyFandom().equals(animeToy.getToyFandom()) && allToys.get(i).getToyName().equals(animeToy.getToyName())) {
                toys.add(allToys.get(i));
            }
        }
        return toys;
    }

    public ArrayList<AnimeShop> getCertainShops(AnimeShop animeShop) {
        ShopDAO shopDAO = new ShopDAOImpl();
        ArrayList<AnimeShop> allShops = shopDAO.readAllShops();
        ArrayList<AnimeShop> shops = new ArrayList<>();
        for (int i = 0; i < allShops.size(); i++) {
            if (allShops.get(i).getShopName().equals(animeShop.getShopName()) && allShops.get(i).getShopAddress().equals(animeShop.getShopAddress())) {
                shops.add(allShops.get(i));
            }
        }
        return shops;
    }

    public ArrayList<AnimeToy> getAllToysFromDBByShopId(int shopId) {
        ToyDAOImpl tdi = new ToyDAOImpl();
        ArrayList<AnimeToy> allToys = tdi.readAllToys();
        ArrayList<AnimeToy> toys = new ArrayList<>();
        for (int i = 0; i < allToys.size(); i++) {
            if (shopId == allToys.get(i).getShopId()) {
                toys.add(allToys.get(i));
            }
        }
        return toys;
    }


}

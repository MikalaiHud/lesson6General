package com.epam.hud.logic;

import com.epam.hud.entity.AnimeShop;
import com.epam.hud.entity.AnimeToy;
import com.epam.hud.exception.AnimeException;
import com.epam.hud.entity.Type;
import com.epam.hud.entity.Fandom;

import java.io.Serializable;
import java.util.ArrayList;

public class ShopContainer implements Serializable {


    private ArrayList<AnimeShop> shops = new ArrayList<>();

    public int getTempShopNumber() {
        return shops.size();
    }

    public void addShop(AnimeShop shop) {
        shops.add(shop);
    }

    public void editShopByIndex(int index, AnimeShop newShop) throws AnimeException {
        if (index < 0 || index > shops.size() - 1) {
            throw new AnimeException("Попытка отредактировать несуществующий элемент эррей-листа.");
        }
        shops.set(index, newShop);
    }

    public ArrayList<AnimeShop> getShops() {
        return shops;
    }

    public void getShop(int index) throws AnimeException {
        if (index > shops.size() - 1) {
            throw new AnimeException("Попытка заполучить несуществующий элемент эррей-листа.");
        }
        System.out.println("Магазин № " + index + ": " + shops.get(index));
    }

    public void printShopArray() {
        System.out.println("-------------------------------------------------");
        System.out.println("Элементы эррей-листа shops");
        for (AnimeShop shop : shops) {
            System.out.println(shop);
        }
        System.out.println("-------------------------------------------------");
    }

    public void printShopAddressByIndex(int index) throws AnimeException {
        if (index > shops.size() - 1) {
            throw new AnimeException("Ппоытка вывести адрес несуществующего магазина.");
        }
        System.out.println("-------------------------------------------------");
        System.out.println(index + "-й магазин (адрес): " + shops.get(index).getShopAddress());
        System.out.println("-------------------------------------------------");
    }

    public void printShopNameByIndex(int index) throws AnimeException {
        if (index > shops.size() - 1) {
            throw new AnimeException("Ппоытка вывести название несуществуюшего магазина.");
        }
        System.out.println("-------------------------------------------------");
        System.out.println(index + "-й магазин (название): " + shops.get(index).getShopName());
        System.out.println("-------------------------------------------------");
    }

    public void printToyList() {
        System.out.println("-------------------------------------------------");
        System.out.println("Список всех игрушек во всех магазинах:");
        for (AnimeShop shop : shops) {
            System.out.println(shop.getAnimeToys());
        }
        System.out.println("-------------------------------------------------");
    }


    //Исправленный метод определения самой дорогой игрушки.
    public void printToyWithMaxPrice() {
        int maxIndexLineReference = 0;
        int maxIndexColumnReference = 0;
        for (int i = 0; i < shops.size(); i++) {
            int maxIndexLine = 0;
            for (int j = 0; j < shops.get(i).getAnimeToys().size(); j++) {
                if (shops.get(i).getAnimeToys().get(j).getToyPrice() > shops.get(i).getAnimeToys().get(maxIndexLine).getToyPrice()) {
                    maxIndexLine = j;
                    if (shops.get(i).getAnimeToys().get(maxIndexLine).getToyPrice() > shops.get(maxIndexColumnReference).getAnimeToys().get(maxIndexLineReference).getToyPrice()) {
                        maxIndexColumnReference = i;
                        maxIndexLineReference = maxIndexLine;
                    }
                }
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Фигурка с максимальной стоимостью:");
        System.out.println(shops.get(maxIndexColumnReference).getAnimeToys().get(maxIndexLineReference));
        System.out.println("-------------------------------------------------");
    }


    //Исправленный метод определения самой дешёвой игрушки.
    public void printToyWithMinPrice() {
        int minIndexLineReference = 0;
        int minIndexColumnReference = 0;
        for (int i = 0; i < shops.size(); i++) {
            int minIndexLine = 0;
            for (int j = 0; j < shops.get(i).getAnimeToys().size(); j++) {
                if (shops.get(i).getAnimeToys().get(j).getToyPrice() < shops.get(i).getAnimeToys().get(minIndexLine).getToyPrice()) {
                    minIndexLine = j;
                    if (shops.get(i).getAnimeToys().get(minIndexLine).getToyPrice() < shops.get(minIndexColumnReference).getAnimeToys().get(minIndexLineReference).getToyPrice()) {
                        minIndexColumnReference = i;
                        minIndexLineReference = minIndexLine;
                    }
                }
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Фигурка с максимальной стоимостью:");
        System.out.println(shops.get(minIndexColumnReference).getAnimeToys().get(minIndexLineReference));
        System.out.println("-------------------------------------------------");
    }

    public void printNamesAndFnadomsOfCertainTypeOfToys(Type type) {
        System.out.println("-------------------------------------------------");
        System.out.println("Имена и фэндомы фигурок с типом " + type + ":");
        for (int i = 0; i < shops.size(); i++) {
            System.out.print(i + "-й магазин: ");
            for (int j = 0; j < shops.get(i).getTempNumber(); j++) {
                if (type.equals(shops.get(i).getAnimeToys().get(j).getToyType())) {
                    System.out.print(j + "-я игрушка:" + shops.get(i).getAnimeToys().get(j).getToyName() + " " + shops.get(i).getAnimeToys().get(j).getToyFandom() + "; ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public int printGeneralPriceOfToys() {
        int genPrice = 0;
        for (int i = 0; i < shops.size(); i++) {
            for (int j = 0; j < shops.get(i).getAnimeToys().size(); j++) {
                genPrice += shops.get(i).getAnimeToys().size() * shops.get(i).getAnimeToys().get(j).getToyPrice();
            }
        }
        return genPrice;
    }

    public void printNamesOfCertainFandomOfToys(Fandom fandom) {
        System.out.println("-------------------------------------------------");
        System.out.println("Имена фигурок с фэндомом " + fandom + ": ");
        for (int i = 0; i < shops.size(); i++) {
            System.out.print(i + "-й магазин: ");
            for (int j = 0; j < shops.get(i).getTempNumber(); j++) {
                if (fandom.equals(shops.get(i).getAnimeToys().get(j).getToyFandom()) && shops.get(i).getAnimeToys().size() > 2) {
                    System.out.print(" " + shops.get(i).getAnimeToys().get(j).getToyName() + "; ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public double calculatingAveragePriceOfCertainTypeOfToy(Type type) {
        int genPrice = 0;
        int toyAmmount = 0;
        for (AnimeShop shop : shops) {
            for (int j = 0; j < shop.getAnimeToys().size(); j++) {
                if (type.equals(shop.getAnimeToys().get(j).getToyType())) {
                    genPrice += shop.getAnimeToys().get(j).getToyPrice();
                    toyAmmount++;
                }
            }
        }
        if (toyAmmount == 0) {
            return 0;
        }
        return genPrice / toyAmmount;
    }

    public void printCertainFigure(AnimeToy animeToy) {
        System.out.println("-------------------------------------------------");
        System.out.println("Метод, показывающий магазины, имеющие даную фигурку (" + animeToy + "):");
        for (AnimeShop shop : shops) {
            for (int i = 0; i < shop.getAnimeToys().size(); i++) {
                if (animeToy == shop.getAnimeToys().get(i)) {
                    System.out.println("Данная фигурка находится в наличии магазин " + shop + ". Её стоимость составляет " + shop.getAnimeToys().get(i).getToyPrice());
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }


}

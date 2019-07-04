package com.epam.hud.logic;

import com.epam.hud.entity.AnimeShop;
import com.epam.hud.entity.AnimeToy;
import com.epam.hud.exception.AnimeException;

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

    public void printToyWithMaxPrice() {
        int maxIndex = 0;
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).getToyPrice() > shops.get(maxIndex).getToyPrice()) {
                maxIndex = i;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Фигурки с максимальной стоиомстью:");
        System.out.println(shops.get(maxIndex).getToyPrice());
        System.out.println("-------------------------------------------------");
    }

    public void printToyWithMinPrice() {
        int minIndex = 0;
        for (int i = 0; i < shops.size(); i++) {
            if (shops.get(i).getToyPrice() < shops.get(minIndex).getToyPrice()) {
                minIndex = i;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Фигурки с минимальной стоиомстью:");
        System.out.println(shops.get(minIndex).getToyPrice());
        System.out.println("-------------------------------------------------");
    }

    public void printNamesAndFnadomsOfCertainTypeOfToys(String type) {
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
        for (AnimeShop shop : shops) {
            genPrice += shop.getToyPrice() * shop.getNumberOfToys() * shop.getTempNumber();
        }
        return genPrice;
    }

    public void printNamesOfCertainFandomOfToys(String fandom) {
        System.out.println("-------------------------------------------------");
        System.out.println("Имена фигурок с фэндомом " + fandom + ": ");
        for (int i = 0; i < shops.size(); i++) {
            System.out.print(i + "-й магазин: ");
            for (int j = 0; j < shops.get(i).getTempNumber(); j++) {
                if (fandom.equals(shops.get(i).getAnimeToys().get(j).getToyFandom()) && shops.get(i).getNumberOfToys() > 2) {
                    System.out.print(" " + shops.get(i).getAnimeToys().get(j).getToyName() + "; ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public double calculatingAveragePriceOfCertainTypeOfToy(String type) {
        double genPrice = 0;
        int number = 0;
        for (AnimeShop shop : shops) {
            int temp = 0;
            for (int j = 0; j < shop.getTempNumber(); j++) {
                if (type.equals(shop.getAnimeToys().get(j).getToyType())) {
                    temp = 1;
                }
            }
            genPrice += shop.getToyPrice() * temp;
            if (temp == 1) {
                number++;
            }
        }
        double averagePrice = genPrice / number;
        return averagePrice;
    }

    public void printCertainFigure(AnimeToy animeToy) {
        System.out.println("-------------------------------------------------");
        System.out.println("Метод, показывающий магазины, имеющие даную фигурку (" + animeToy + "):");
        for (AnimeShop shop : shops) {
            int trueIndex = 0;
            for (int j = 0; j < shop.getTempNumber(); j++) {
                if (animeToy == shop.getAnimeToys().get(j)) {
                    trueIndex = 1;
                }
            }
            if (trueIndex == 1) {
                System.out.println("Данная фигурка есть в наличии магазина. Её стоимость " + shop.getToyPrice());
            }
        }
        System.out.println("-------------------------------------------------");
    }


}

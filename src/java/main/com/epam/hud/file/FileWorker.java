package com.epam.hud.file;

import com.epam.hud.entity.AnimeShop;
import com.epam.hud.logic.ShopContainer;

import java.io.*;
import java.util.ArrayList;

public class FileWorker implements Serializable {

    public void writeShops(String filename, ShopContainer shopContainer) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(shopContainer);
        oos.close();
        fos.close();
    }

    public ArrayList<AnimeShop> readShops(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ShopContainer shopContainer = (ShopContainer) ois.readObject();
        ois.close();
        fis.close();
        return shopContainer.getShops();
    }
}

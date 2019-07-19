package com.epam.hud.file;

import com.epam.hud.dao.entity.AnimeShop;
import com.epam.hud.logic.ShopManager;

import java.io.*;
import java.util.ArrayList;

public class FileWorker implements Serializable {

    public void writeShops(String filename, ShopManager shopContainer) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(shopContainer);
        oos.close();
        fos.close();
    }

    public ArrayList<AnimeShop> readShops(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ShopManager shopContainer = (ShopManager) ois.readObject();
        ois.close();
        fis.close();
        //shopContainer.getShops();
        return null;
    }
}

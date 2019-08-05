package com.epam.hud.dao.interfaces;

import com.epam.hud.dao.entity.AnimeShop;

import java.util.ArrayList;

public interface ShopDAO {
    void createShop(AnimeShop animeShop);

    AnimeShop readShop(int id);

    void updateShop(int id, AnimeShop animeShop);

    void deleteShop(int id);

    ArrayList<AnimeShop> readAllShops();

}

package com.epam.hud.dao.interfaces;

import com.epam.hud.dao.entity.AnimeShop;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ShopDAO {
    void createShop(AnimeShop animeShop) throws SQLException;

    AnimeShop readShop(int id) throws SQLException;

    void updateShop(int id, AnimeShop animeShop) throws SQLException;

    void deleteShop(int id) throws SQLException;

    ArrayList<AnimeShop> readAllShops() throws SQLException;

}

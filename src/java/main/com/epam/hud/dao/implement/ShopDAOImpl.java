package com.epam.hud.dao.implement;

import com.epam.hud.dao.db.ConnectionPool;
import com.epam.hud.dao.entity.AnimeShop;
import com.epam.hud.dao.interfaces.ShopDAO;

import java.sql.*;
import java.util.ArrayList;


public class ShopDAOImpl implements ShopDAO {

    private final String READ_SHOP = "SELECT * from anime.shops WHERE id=?;";
    private final String CREATE_SHOP = "INSERT into anime.shops (name,address) VALUES (?,?);";
    private final String UPDATE_SHOP = "UPDATE anime.shops SET name=?, address=? where id=?";
    private final String DELETE_SHOP = "DELETE from anime.shops where id=?";
    private final String READ_ALL_SHOPS = "SELECT * from anime.shops";

    // TODO: Прочитать про try/ try-with resources.
    @Override
    public void createShop(AnimeShop animeShop) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(CREATE_SHOP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setString(1, animeShop.getShopName());
            statement.setString(2, animeShop.getShopAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


        public AnimeShop readShop ( int id) {
            AnimeShop shop = new AnimeShop();
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(READ_SHOP);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.setInt(1, id);
                final ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    shop.setId(rs.getInt("id"));
                    ToyDAOImpl toyDAO = new ToyDAOImpl();
                    shop.setAnimeToys(toyDAO.readAllToysByShopId(shop.getId()));
                    shop.setShopAddress(rs.getString("address"));
                    shop.setShopName(rs.getString("name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return shop;
        }

        @Override
        public void updateShop ( int id, AnimeShop animeShop)  {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(UPDATE_SHOP);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.setString(1, animeShop.getShopName());
                statement.setString(2, animeShop.getShopAddress());
                statement.setInt(3, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void deleteShop ( int id)  {
            Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(DELETE_SHOP);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public ArrayList<AnimeShop> readAllShops ()  {
            Connection connection = ConnectionPool.getInstance().getConnection();
            ArrayList<AnimeShop> shops = new ArrayList<AnimeShop>();
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(READ_ALL_SHOPS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                final ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    AnimeShop shop = new AnimeShop();
                    ToyDAOImpl tdi = new ToyDAOImpl();
                    shop.setId(rs.getInt("id"));
                    shop.setShopAddress(rs.getString("address"));
                    shop.setShopName(rs.getString("name"));
                    shop.setAnimeToys(tdi.readAllToysByShopId(shop.getId()));
                    shops.add(shop);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return shops;
        }
    }

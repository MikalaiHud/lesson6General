package com.epam.hud.dao.implement;

import com.epam.hud.dao.db.ConnectionPool;
import com.epam.hud.dao.entity.AnimeToy;
import com.epam.hud.dao.entity.Fandom;
import com.epam.hud.dao.entity.Type;
import com.epam.hud.dao.interfaces.ToyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToyDAOImpl implements ToyDAO {
    private final String READ_TOY = "SELECT * from anime.toys WHERE id=?;";
    private final String CREATE_TOY = "INSERT into anime.toys (name,type,fandom,price,shop_id) VALUES (?,?,?,?,?);";
    private final String UPDATE_TOY = "UPDATE anime.toys SET name=?, type=?, fandom=?, price=?, shop_id=? where id=?";
    private final String DELETE_TOY = "DELETE from anime.toys where id=?";
    private final String READ_ALL_TOYS_BY_SHOP_ID = "SELECT * from anime.toys where shop_id=?";
    private final String READ_ALL_TOYS = "SELECT * from anime.toys";

    public void createToy(AnimeToy animeToy) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(CREATE_TOY);
        statement.setString(1, animeToy.getToyName());
        statement.setString(2, String.valueOf(animeToy.getToyType()));
        statement.setString(3, String.valueOf(animeToy.getToyFandom()));
        statement.setInt(4, animeToy.getToyPrice());
        statement.setInt(5, animeToy.getShopId());
        connection.close();
    }

    public AnimeToy readToy(int id) throws SQLException {
        AnimeToy toy = new AnimeToy();
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(READ_TOY);
        statement.setInt(1, id);
        final ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            toy.setId(rs.getInt("id"));
            toy.setToyName(rs.getString("name"));
            toy.setToyFandom(Fandom.valueOf(rs.getString("fandom")));
            toy.setToyType(Type.valueOf(rs.getString("type")));
            toy.setToyPrice(rs.getInt("price"));
            toy.setShopId(rs.getInt("shop_id"));
        }
        connection.close();
        return toy;
    }


    public void updateToy(int id, AnimeToy toy) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_TOY);
        statement.setString(1, toy.getToyName());
        statement.setString(2, String.valueOf(toy.getToyType()));
        statement.setString(3, String.valueOf(toy.getToyFandom()));
        statement.setInt(4, toy.getToyPrice());
        statement.setInt(5, toy.getShopId());
        statement.setInt(6, id);
        connection.close();
    }

    public void deleteToy(int id) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_TOY);
        statement.setInt(1, id);
        connection.close();
    }

    public ArrayList<AnimeToy> readAllToysByShopId(int shopId) throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AnimeToy toy = new AnimeToy();
        ArrayList<AnimeToy> toys = new ArrayList<AnimeToy>();
        PreparedStatement statement = connection.prepareStatement(READ_ALL_TOYS_BY_SHOP_ID);
        statement.setInt(1, shopId);
        final ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            toy.setToyType(Type.valueOf(rs.getString("type")));
            toy.setToyName(rs.getString("name"));
            toy.setToyPrice(rs.getInt("price"));
            toy.setToyFandom(Fandom.valueOf(rs.getString("fandom")));
            toy.setId(rs.getInt("id"));
            toy.setShopId(rs.getInt("shop_id"));
            toys.add(toy);
        }
        return toys;
    }

    public ArrayList<AnimeToy> readAllToys() throws SQLException {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AnimeToy toy = new AnimeToy();
        ArrayList<AnimeToy> toys = new ArrayList<AnimeToy>();
        PreparedStatement statement = connection.prepareStatement(READ_ALL_TOYS);
        final ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            toy.setToyType(Type.valueOf(rs.getString("type")));
            toy.setToyName(rs.getString("name"));
            toy.setToyPrice(rs.getInt("price"));
            toy.setToyFandom(Fandom.valueOf(rs.getString("fandom")));
            toy.setId(rs.getInt("id"));
            toy.setShopId(rs.getInt("shop_id"));
            toys.add(toy);
        }
        return toys;
    }

}

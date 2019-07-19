package com.epam.hud.dao.interfaces;

import com.epam.hud.dao.entity.AnimeToy;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ToyDAO {
    void createToy(AnimeToy animeToy) throws SQLException;

    AnimeToy readToy(int id) throws SQLException;

    void updateToy(int id, AnimeToy animeToy) throws SQLException;

    void deleteToy(int id) throws SQLException;

    ArrayList<AnimeToy> readAllToys() throws SQLException;

}

package com.epam.hud.dao.interfaces;

import com.epam.hud.dao.entity.AnimeToy;

import java.util.ArrayList;

public interface ToyDAO {
    void createToy(AnimeToy animeToy);

    AnimeToy readToy(int id);

    void updateToy(int id, AnimeToy animeToy);

    void deleteToy(int id);

    ArrayList<AnimeToy> readAllToys();

}

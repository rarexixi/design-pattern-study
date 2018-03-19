package org.xi.builder.director;

import org.xi.builder.builder.HouseBuilder;
import org.xi.builder.model.House;

public class HouseBuildDirector {

    public House constructHouse(HouseBuilder builder) {

        builder.buildBasic();
        builder.buildWalls();
        builder.buildRoof();

        return builder.buildHouse();
    }
}

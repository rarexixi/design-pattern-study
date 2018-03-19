package org.xi.builder;

import org.xi.builder.builder.HouseBuilder;
import org.xi.builder.builder.impl.HouseBuilderImpl;
import org.xi.builder.director.HouseBuildDirector;

public class Main {

    public static void main(String[] args) {

        HouseBuilder builder = new HouseBuilderImpl();
        HouseBuildDirector director = new HouseBuildDirector();
        System.out.println(director.constructHouse(builder));
    }
}

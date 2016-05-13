package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args){
        Schema schema = new Schema(1,"com.my.nullpointerplayer.db");

        Entity myData1 = schema.addEntity("FindFragmentData");
        myData1.addStringProperty("name").primaryKey();
        myData1.addStringProperty("response");

        Entity myData2 = schema.addEntity("RecommendFragmentData");
        myData2.addStringProperty("name").primaryKey();
        myData2.addStringProperty("response");

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

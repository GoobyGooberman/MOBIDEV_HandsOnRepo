package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

/**
 * Created by Administrator on 2/9/2018.
 */

public class S14_RestaurantModel {
    private String restoName, description;
    private int weight;

    public S14_RestaurantModel(String restoName, String description, int weight){
        this.restoName = restoName;
        this.description = description;
        this.weight = weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getRestoName(){
        return this.restoName;
    }

    public String getDescription(){
        return this.description;
    }

    public int getWeight(){
        return this.weight;
    }
}

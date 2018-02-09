package com.neildg.mobidev_handsonrepo.activity_restaurant_workspace;

/**
 * Created by Administrator on 2/9/2018.
 */

public class S16_RestaurantModel {
    private  String name;
    private int weight;
    private String description;

    public S16_RestaurantModel(String name, int weight, String description){
        this.name = name;
        this.weight = weight;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

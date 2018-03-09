package com.neildg.mobidev_handsonrepo.activity_catchup;

/**
 * Created by Administrator on 3/9/2018.
 */

public class PersonModel {
    private String name;
    private String hobby;

    public PersonModel(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return this.name;
    }

    public String getHobby() {
        return this.hobby;
    }
}

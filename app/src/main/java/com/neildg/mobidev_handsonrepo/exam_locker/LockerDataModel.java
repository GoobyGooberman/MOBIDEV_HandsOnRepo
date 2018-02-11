package com.neildg.mobidev_handsonrepo.exam_locker;

/**
 * Created by NeilDG on 2/11/2018.
 */

public class LockerDataModel {
    private int number;

    public LockerDataModel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getNumberString() {
        return Integer.toString(this.number);
    }

}

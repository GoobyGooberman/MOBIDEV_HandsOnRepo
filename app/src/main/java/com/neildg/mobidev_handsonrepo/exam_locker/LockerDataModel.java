package com.neildg.mobidev_handsonrepo.exam_locker;

/**
 * Created by NeilDG on 2/11/2018.
 */

public class LockerDataModel {
    public enum KeyType {
        NUMBER,
        LETTER
    }

    private int number;
    private char letterChar;

    private KeyType currentKeyType = KeyType.NUMBER; //default is number

    public LockerDataModel(int number, char letterChar) {
        this.number = number;
        this.letterChar = letterChar;
    }

    public int getNumber() {
        return number;
    }

    public char getLetterChar() {
        return letterChar;
    }

    public String getNumberString() {
        return Integer.toString(this.number);
    }

    public KeyType getCurrentKeyType() {
        return currentKeyType;
    }


}

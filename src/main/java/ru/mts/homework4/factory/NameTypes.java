package ru.mts.homework4.factory;

import java.util.List;

public enum NameTypes {
    HALEY, JOHN, HELEN, STEVE, MARK, MICHAEL;

    public static String randomName() {
        List<NameTypes> nameTypes = List.of(NameTypes.values());
        int rDigit = (int) (Math.random() * 100 % nameTypes.size());
        return nameTypes.get(rDigit).toString();
    }
}

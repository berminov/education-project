package ru.mts.homework4.domain.enums;

import java.util.List;

public enum NameType {

    HALEY, JOHN, HELEN, STEVE, MARK, MICHAEL;

    public static String getRandomName() {
        List<NameType> nameTypes = List.of(NameType.values());
        int rDigit = (int) (Math.random() * 100 % nameTypes.size());

        return String.valueOf(nameTypes.get(rDigit));
    }

}

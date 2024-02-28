package ru.mts.homework7.domain.enums;

import java.util.List;

public enum CharacterType {

    FRIENDLY, AGGRESSIVE, LAZY, CURIOUS;

    public static String randomCharacter() {
        List<CharacterType> characterTypes = List.of(CharacterType.values());
        int rDigit = (int) (Math.random() * 100 % characterTypes.size());

        return String.valueOf(characterTypes.get(rDigit));
    }

}

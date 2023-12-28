package ru.mts.homework4.factory;

import java.util.List;

public enum CharacterTypes {
    FRIENDLY, AGGRESSIVE, LAZY, CURIOUS;
    public static String randomCharacter(){
        List<CharacterTypes> characterTypes = List.of(CharacterTypes.values());
        int rDigit =  (int)(Math.random()*100 % characterTypes.size());
        return characterTypes.get(rDigit).toString();
    }
}

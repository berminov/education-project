package ru.mts.homework6.domain.enums;

import org.jetbrains.annotations.Nullable;

public enum CatBreed implements BreedType<String> {

    BRITISH("British");

    private final String breed;

    CatBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String getBreedType() {
        return breed;
    }

    @Override
    public Class<?> getEnumClass() {
        return CatBreed.class;
    }

    @Nullable
    public static CatBreed fromBreed(String breed) {
        for (var b : CatBreed.values()) {
            if (b.getBreedType().equals(breed)) {
                return b;
            }

        }

        return null;
    }

}

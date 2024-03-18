package ru.mts.homework11.startertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.homework11.domain.abstraction.Animal;
import ru.mts.homework11.factory.BearFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class OneRandomAnimalTest {

    @Autowired
    private BearFactory bearFactory;

    /**
     * Тест bearNamesTest проверяет, что экземпляру класса Bear
     * присваиваются имена bearNames, определенные в application.yml
     */
    @Test
    void bearNamesTest() {
        Animal bear = bearFactory.createAnimal();
        String[] names = {"bear1", "bear2", "bear3"};
        assertTrue(isNameInArray(names, bear.getName()));
    }

    boolean isNameInArray(String[] allNames, String neededName) {
        for (String name : allNames) {
            if (name.equals(neededName)) {
                return true;
            }
        }
        return false;
    }
}

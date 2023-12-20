package ru.mts.homework3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneRandomAnimal {
    public void creation(){
        int randomAnimal = (int) Math.round(Math.random()*10);
        int randomSelect = (int) Math.round(Math.random()*10);
        switch (randomAnimal%4){
            case 0:
                Bear bear = new Bear();
                if (randomSelect%3 == 0)
                    bear.setBreed("Polar");
                else if (randomSelect%3 ==1)
                    bear.setBreed("Grizzly");
                else
                    bear.setBreed("Brown");
                bear.setName("Misha_" + randomSelect);
                bear.setCost(BigDecimal.valueOf(Math.random()*1000000).setScale(2,RoundingMode.HALF_UP));
                if (randomAnimal%3 == 0)
                    bear.setCharacter("Aggressive");
                else if (randomSelect%3 ==1)
                    bear.setCharacter("Friendly");
                else
                    bear.setCharacter("Lazy");
                System.out.println(bear);
                bear.hibernate();
                bear.hunt();
                break;
            case 1:
                Wolf wolf = new Wolf();
                if (randomSelect%3 == 0)
                    wolf.setBreed("Arctic");
                else if (randomSelect%3 ==1)
                    wolf.setBreed("Grey");
                else
                    wolf.setBreed("Japanese");
                wolf.setName("Serega_" + randomSelect);
                wolf.setCost(BigDecimal.valueOf(Math.random()*10000).setScale(2,RoundingMode.HALF_UP));
                if (randomAnimal%3 == 0)
                    wolf.setCharacter("Aggressive");
                else if (randomSelect%3 ==1)
                    wolf.setCharacter("Friendly");
                else
                    wolf.setCharacter("Lazy");
                System.out.println(wolf);
                wolf.howl();
                wolf.hunt();
                break;
            case 2:
                Cat cat = new Cat();
                if (randomSelect%3 == 0)
                    cat.setBreed("Persian");
                else if (randomSelect%3 ==1)
                    cat.setBreed("British");
                else
                    cat.setBreed("Bengal");
                cat.setName("Alice_" + randomSelect);
                cat.setCost(BigDecimal.valueOf(Math.random()*100000).setScale(2,RoundingMode.HALF_UP));
                if (randomAnimal%3 == 0)
                    cat.setCharacter("Aggressive");
                else if (randomSelect%3 ==1)
                    cat.setCharacter("Friendly");
                else
                    cat.setCharacter("Lazy");
                System.out.println(cat);
                cat.whatLikes();
                cat.plays();
                break;
            case 3:
                Parrot parrot = new Parrot();
                if (randomSelect%3 == 0)
                    parrot.setBreed("Arra");
                else if (randomSelect%3 ==1)
                    parrot.setBreed("Jako");
                else
                    parrot.setBreed("Cockatoo");
                parrot.setName("Yasha_" + randomSelect);
                parrot.setCost(BigDecimal.valueOf(Math.random()*10000).setScale(2,RoundingMode.HALF_UP));
                if (randomAnimal%3 == 0)
                    parrot.setCharacter("Aggressive");
                else if (randomSelect%3 ==1)
                    parrot.setCharacter("Friendly");
                else
                    parrot.setCharacter("Lazy");
                System.out.println(parrot);
                parrot.whatLikes();
                break;
        }
    }
}

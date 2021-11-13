package HW6.Collections;

import HW6.Collections.PetsClasses.Cat;
import HW6.Collections.PetsClasses.Dog;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PetsSet
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat("Felidae", "Smoky", "Nora");
        Cat cat2 = new Cat("Felidae", "Purple", "Melissa");
        Cat cat3 = new Cat("Felidae", "Blue", "Kassandra");
        Dog dog1 = new Dog("Canidae", "Dalmatian", "Weiss");
        Dog dog2 = new Dog("Canidae", "Black", "Berg");
        Dog dog3 = new Dog("Canidae", "Brown", "Rich");

        HashSet<String> pets = new HashSet<>();
        pets.add(String.valueOf(cat1));
        pets.add(String.valueOf(cat2));
        pets.add(String.valueOf(cat3));
        pets.add(String.valueOf(dog1));
        pets.add(String.valueOf(dog2));
        pets.add(String.valueOf(dog3));

        System.out.println(pets); // standart printing

        pets.forEach(System.out::println); // This printing looks better
    }
}

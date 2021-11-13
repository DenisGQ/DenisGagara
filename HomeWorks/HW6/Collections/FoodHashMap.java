package HW6.Collections;

import java.util.*;
import java.util.stream.Collectors;


public class FoodHashMap {
    public static void main(String[] args) {
        Map<String, String> food = new HashMap<>();
        food.put("Яблоко", "Фрукт");
        food.put("Арбуз", "Ягода");
        food.put("Картофель", "Овощ");
        food.put("Банан", "Фрукт");
        food.put("Смородина", "Ягода");
        food.put("Кабачок", "Овощ");
        food.put("Персик", "Фрукт");
        food.put("Вишня", "Ягода");
        food.put("Помидор", "Овощ");
        food.put("Стейк", "Мяско");

        for (Map.Entry<String, String> m: food.entrySet())
            System.out.println(m.getKey() + " " + m.getValue());

        // Deleting duplicates
        System.out.println("Now we delete duplicates from HashMap");
        System.out.println("Before: " + food);

        Set<String> existing = new HashSet<>();
        food = food.entrySet()
                .stream()
                .filter(entry -> existing.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("After: " + food);
    }
}

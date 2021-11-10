package HW5;

public class MainTest {
    public static void main(String[] args) {
        RubberDuck duck = new RubberDuck("Duck", "bird", "rubber", "beak");
        System.out.println(duck);
        duck.iAM();
        duck.fly();
        duck.canSwim();
        Martin martin = new Martin("Martin", "bird", "beak");
        System.out.println(martin);
        martin.iAM();
        martin.fly();
        martin.canEat();
        Swan swan = new Swan("Swan", "bird");
        System.out.println(swan);
        swan.iAM();
        swan.fly();
        swan.canSwim();
        swan.canEat();
        Platypus plat = new Platypus("Platopus", "mammal");
        System.out.println(plat);
        plat.iAM();
        plat.canSwim();
        plat.canEat();
    }
}

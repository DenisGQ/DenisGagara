package HW4;

import HW4.details.Engine;
import HW4.professions.Driver;
import HW4.professions.Person;
import HW4.vehicles.Car;
import HW4.vehicles.SportCar;
import HW4.vehicles.Truck;


public class Main
{
    public static void main(String[] args)
    {
        Driver driver = new Driver("Nikolay", "Nikolay Drozd", 31, 6);
        Driver driver2 = new Driver("Chris", "Christian von Koenigsegg", 49, 22);
        Driver driver3 = new Driver("JD", "John Doe", 99, 99);
        Engine engine = new Engine(149, "Wolksvagen");
        Engine engine2 = new Engine(940, "Koenigsegg");
        Engine engine3 = new Engine(775, "Tesla");
        Car car = new Car("WV", "sedan", 1850, driver, engine);
        SportCar sportCar = new SportCar("Koenigsegg", "hypercar", 1330, driver2, engine2, 440);
        Truck truck = new Truck("Tesla", "truck", 2000, driver3, engine3, 1587);
        System.out.println(car);
        System.out.println(sportCar);
        System.out.println(truck);
        car.start();
        car.stop();
        car.turnRight();
        car.turnLeft();
        car.printInfo();
    }

}

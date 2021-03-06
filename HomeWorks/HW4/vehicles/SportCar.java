package HW4.vehicles;

import HW4.details.Engine;
import HW4.professions.Driver;

public class SportCar extends Car
{
    private int speed;

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public SportCar(String brand, String type, int weight, Driver driver, Engine engine, int speed)
    {
        super(brand, type, weight, driver, engine);
        this.speed = speed;
    }
}

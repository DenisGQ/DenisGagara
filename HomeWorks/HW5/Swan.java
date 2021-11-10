package HW5;

public class Swan extends Birds implements CanEat, CanSwim, CanFly
{
    public Swan(String name, String type) {
        super(name, type);
    }

    @Override
    public void canEat() {
        System.out.println("I'm eating grass");
    }

    @Override
    public void canSwim() {
        System.out.println("I can swim");
    }

    @Override
    public double speed(CanFly canFly) {
        return 0;
    }

    @Override
    public Double speed() {
        return null;
    }

    @Override
    public String toString() {
        return "Swan{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

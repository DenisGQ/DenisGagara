package HW5;

import java.util.Objects;

public class Martin extends Birds implements CanEat, CanFly
{
    private  String beak;

    public Martin(String name, String type, String beak) {
        super(name, type);
        this.beak = beak;
    }

    @Override
    public String toString() {
        return "Martin{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", beak='" + beak + '\'' +
                '}';
    }

    @Override
    public void canEat() {
        System.out.println("I'm eating insects");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Martin)) return false;
        if (!super.equals(o)) return false;
        Martin martin = (Martin) o;
        return beak.equals(martin.beak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), beak);
    }

    @Override
    public double speed(CanFly canFly) {
        return 0;
    }

    @Override
    public Double speed() {
        return null;
    }
}

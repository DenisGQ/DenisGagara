package HW5;

import java.util.Objects;

public class Platypus implements CanSwim, CanEat
{
    private String name;
    private String type;

    public Platypus(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public void iAM()
    {
        System.out.println(name + " is a mammal");
    }
    @Override
    public void canEat()
    {
        System.out.println("I'm eating insects");
    }

    @Override
    public void canSwim()
    {
        System.out.println("I can swim");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Platypus)) return false;
        Platypus platypus = (Platypus) o;
        return name.equals(platypus.name) && type.equals(platypus.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "Platypus{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

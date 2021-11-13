package HW6.Collections.PetsClasses;

public class Cat extends Pet
{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String family, String colour, String name) {
        super(family, colour);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}

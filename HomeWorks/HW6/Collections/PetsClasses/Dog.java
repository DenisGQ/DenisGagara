package HW6.Collections.PetsClasses;

public class Dog extends Pet
{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String family, String colour, String name) {
        super(family, colour);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}

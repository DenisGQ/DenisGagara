package HW6.Collections.PetsClasses;

public class Pet
{
    public String family;
    public String colour;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Pet(String family, String colour) {
        this.family = family;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "family='" + family + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}

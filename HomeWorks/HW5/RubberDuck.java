package HW5;

import java.util.Objects;

public class RubberDuck extends Birds implements CanSwim
{
    private String material;
    private  String beak;

    public RubberDuck(String name, String type, String material, String beak) {
        super(name, type);
        this.material = material;
        this.beak = beak;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBeak() {
        return beak;
    }

    public void setBeak(String beak) {
        this.beak = beak;
    }

    @Override
    public void canSwim() {
        System.out.println("I can swim");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RubberDuck)) return false;
        if (!super.equals(o)) return false;
        RubberDuck that = (RubberDuck) o;
        return material.equals(that.material) && beak.equals(that.beak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, beak);
    }

    @Override
    public String toString() {
        return "RubberDuck{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", material='" + material + '\'' +
                ", beak='" + beak + '\'' +
                '}';
    }
}

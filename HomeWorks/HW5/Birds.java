package HW5;

import java.util.Objects;

public abstract class Birds
{
    public String name = "duck";
    public String type = "bird";

    public Birds(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void fly()
    {
        if (name.equals("Martin"))
        {System.out.println("I can fly");}
        else
        {if (name.equals("Swan"))
            {System.out.println("I can fly");}
            else
            {System.out.println("I can't fly");}
        }

    }
    public void iAM()
    {
        if (type.equals("bird"))
        { System.out.println(name + " is a bird");}
        else
        {
            System.out.println(name + "not a bird");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Birds)) return false;
        Birds birds = (Birds) o;
        return name.equals(birds.name) && type.equals(birds.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "Birds{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
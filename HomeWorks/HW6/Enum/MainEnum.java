package HW6.Enum;

import HW6.Enum.DaysOfWeek;

public class MainEnum
{
    public static void main (String[] args)
    {
        for (DaysOfWeek d : DaysOfWeek.values())
        System.out.println(d);

        DaysOfWeek dd = DaysOfWeek.Friday;
        System.out.println(dd.name() + " " + dd.ordinal());
    }
}

package HW3;


import java.util.Random;

public class HW3_T1
{
    public static void main(String[] args)
    {
        int[] array = {15, 8, 24, 41, 9, 84};
        int randomIndex = new Random().nextInt(array.length);
        int randomNumber = array[randomIndex];
        if (randomNumber % 2 == 0)
            System.out.println(randomNumber + " - I am lucky!");
        else
            System.out.println(randomNumber + " - Run again!");
    }
}

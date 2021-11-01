package HW2;

import java.util.Scanner;

public class HW2_mult
{
    public static void main(String[]args)
    {
        System.out.println("Enter the number of floors you want: ");
        Scanner scan = new Scanner(System.in);
        int floors = scan.nextInt();
        System.out.println("The height building " + floors * 2.5 + "m and " +  floors + " floors.");
    }
}

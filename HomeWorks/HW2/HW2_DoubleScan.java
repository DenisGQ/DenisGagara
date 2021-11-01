package HW2;

import java.util.Scanner;

public class HW2_DoubleScan
{
    public static void main(String[]args)
    {
        System.out.println("Enter height of building and number of floors you want: ");
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int floors = scan.nextInt();
        System.out.println("The height building " + height + "m and " +  floors + " floors.");

    }
}

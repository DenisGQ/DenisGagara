package HW2;

import java.util.Scanner;

public class HW2_Div
{
    public static void main(String[] args)
    {
        System.out.println("Enter height of building you want: ");
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int floors =(int) Math.floor(height/2.5);
        System.out.println("The height building " + height + "m and " +  floors + " floors.");

    }

}

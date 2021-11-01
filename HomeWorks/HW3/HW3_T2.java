package HW3;

import java.util.Scanner;

public class HW3_T2 {
    public static void main(String[] args) {
        String answer;
        boolean exit;
        System.out.println("If I drink, I die. If I eat, I am fine. What am I?");
        Scanner inputAnswer = new Scanner(System.in);
        exit = false;
        for (int i = 1; i <= 3; i++) {
            if (exit == true)
                break;
            answer = inputAnswer.nextLine();
            switch (answer) {
                case ("Fire"):
                    System.out.println("Great!");
                    exit = true;
                    break;
                case ("I don’t know"):
                    System.out.println("Answer: Fire");
                    exit = true;
                    break;
                default:
                    System.out.println("Think again");
                    break;
            }
        }
    }
}

package HW6.Login;

import java.util.Scanner;

public class MainLogin {
    public static void main(String[] args) {
        String una = "Enter user name"
                + System.lineSeparator() + "(a-z, A-Z, _, 0-9, from 4 to 20 characters): ";
        String pwa = "Enter password"
                + System.lineSeparator() + "(a-z, A-Z, _, 0-9, from 8 to 20 characters): ";
        Scanner sc = new Scanner(System.in);
        System.out.print(una);
        String userName = sc.nextLine();
        System.out.print(pwa);
        String password = sc.nextLine();
        System.out.print("Confirm password: ");
        String confPassword = sc.nextLine();
        try {
            if (userName.isEmpty())
            {
                throw new WrongLoginException("User name cannot be empty.");
            }
            if (!userName.matches("[\\w]{4,20}"))
            {
                throw new WrongLoginException("Invalid user name");
            }
            if (!password.matches("[\\w]{8,20}"))
            {
                throw new WrongPasswordException("Password contains invalid characters or too short.");
            }
            if (!password.equals(confPassword))
            {
                throw new WrongPasswordException("Password and confirm password must be the same.");
            }
            else {System.out.println("Successfully logged in!");}
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }

    }
}
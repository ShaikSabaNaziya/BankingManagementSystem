package util;

import java.util.Scanner;

public class InputValidator {

    public static int readInt(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();
                scanner.nextLine();

                return value;
            }

            System.out.println(
                    "Invalid input. Please enter a number."
            );

            scanner.nextLine();
        }
    }

    public static double readDouble(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextDouble()) {

                double value = scanner.nextDouble();
                scanner.nextLine();

                return value;
            }

            System.out.println(
                    "Invalid input. Please enter a valid amount."
            );

            scanner.nextLine();
        }
    }

    public static String readString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String value =
                    scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }

    public static String readPhoneNumber(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String phone =
                    scanner.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println(
                    "Invalid phone number. " +
                    "Please enter exactly 10 digits."
            );
        }
    }
}

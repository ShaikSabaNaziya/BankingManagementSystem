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
                    "Invalid input. Please enter a valid number."
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

                if (Double.isFinite(value)) {
                    return value;
                }

                System.out.println(
                        "Invalid amount. Please enter a finite number."
                );

                continue;
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

            if (phone.matches("[6-9]\\d{9}")) {
                return phone;
            }

            System.out.println(
                    "Invalid phone number. " +
                    "Please enter a valid 10-digit Indian mobile number."
            );
        }
    }

    public static int readPositiveInt(
            Scanner scanner,
            String message) {

        while (true) {

            int value =
                    readInt(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than zero."
            );
        }
    }

    public static double readPositiveAmount(
            Scanner scanner,
            String message) {

        while (true) {

            double value =
                    readDouble(scanner, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Amount must be greater than zero."
            );
        }
    }
}

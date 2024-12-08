import java.util.Scanner;

public class NextDate {

    // Correct method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to calculate the next date
    public static int[] getNextDate(int day, int month, int year) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Adjust February for leap years
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Increment the day
        day++;

        // Check if the new day exceeds the number of days in the current month
        if (day > daysInMonth[month - 1]) {
            day = 1;  // Reset day to 1 and move to the next month
            month++;
        }

        // If the month exceeds December (12), reset to January and increment the year
        if (month > 12) {
            month = 1;  // Reset to January
            year++;     // Increment the year
        }

        return new int[] { day, month, year };
    }

    // Method to validate the input date
    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;  // Invalid month
        }

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (isLeapYear(year)) {
            daysInMonth[1] = 29;  // Adjust February for leap years
        }

        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;  // Invalid day for the given month
        }

        if (year <= 0) {
            return false;  // Invalid year
        }

        return true;  // Valid date
    }

    // Method to format the year as a 4-digit number
    public static String formatYear(int year) {
        return String.format("%04d", year);  // Pads the year with leading zeros if needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input day, month, and year from the user
        System.out.print("Enter the day: ");
        int day = scanner.nextInt();
        
        System.out.print("Enter the month: ");
        int month = scanner.nextInt();
        
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Validate the input date
        if (!isValidDate(day, month, year)) {
            System.out.println("Invalid date entered. Please try again.");
        } else {
            // Display the current date with properly formatted year
            System.out.println("Current Date: " + day + "/" + month + "/" + formatYear(year));

            // Calculate the next date based on user input
            int[] nextDate = getNextDate(day, month, year);

            // Display the next date with properly formatted year
            System.out.println("Next Date: " + nextDate[0] + "/" + nextDate[1] + "/" + formatYear(nextDate[2]));
        }

        // Close the scanner
        scanner.close();
    }
}

import java.util.Scanner;

public class Nextdatedefects {

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return year % 4 == 0; // Leap year calculation (contains a defect)
    }

    // Method to calculate the next date
    public static int[] getNextDate(int day, int month, int year) {
        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // Adjust for leap year in February
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // Leap year adjustment (contains a defect)
        }

        // Increment the day
        day++;

        // Check if day exceeds the days in the current month
        if (day > daysInMonth[month - 1]) {
            day = 1;  // Set to the first day of the next month
            month++;
        }

        // Check if month exceeds 12 (December)
        if (month > 12) {
            month = 1;  // Set to January
            // Forgot to increment the year here (contains a defect)
        }

        return new int[] { day, month, year };
    }

    public static void main(String[] args) {
        // Create a scanner object to take input from user
        Scanner scanner = new Scanner(System.in);

        // Input day, month, and year from the user
        System.out.print("Enter the day: ");
        int day = scanner.nextInt();
        
        System.out.print("Enter the month: ");
        int month = scanner.nextInt();
        
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        // Display the current date
        System.out.println("Current Date: " + day + "/" + month + "/" + year);

        // Calculate the next date based on user input
        int[] nextDate = getNextDate(day, month, year);
        
        // Display the next date
        System.out.println("Next Date: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]);

        // Close scanner
        scanner.close();
    }
}

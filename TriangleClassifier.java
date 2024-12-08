import java.util.Scanner;

public class TriangleClassifier{

    public static String classifyTriangle(int a, int b, int c){
        // Upper limit check for each side
        if (a > 10 || b > 10 || c > 10) {
            return "Invalid: Sides should be <= 10";
        }

        if (a + b > c && b + c > a && c + a > b){
            if (a == b && b == c){
                return "Equilateral";
            } else if (a == b || b == c || c == a){
                return "Isosceles";
            } else {
                return "Scalene";
            }
        } else {
            return "Not a Triangle";
        }
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the sides of the triangle:");

        System.out.print("Side 1: ");
        int a = scanner.nextInt();
        
        System.out.print("Side 2: ");
        int b = scanner.nextInt();
        
        System.out.print("Side 3: ");
        int c = scanner.nextInt();
        
        String result = classifyTriangle(a, b, c);
        System.out.println("Sides: (" + a + "," + b + "," + c + ") => Result: " + result);
        
        scanner.close();
    }
}

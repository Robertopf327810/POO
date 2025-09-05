import java.util.ArrayList;
import java.util.Scanner;

class Process {
    public int n1;
    public int n2;
    public double result;

    public Process() {
        this.n1 = 0;
        this.n2 = 0;
        this.result = 0.0;
    }
    public double add() {
        result = n1 + n2;
        return result;
    }
    public double subtract() {
        result = n1 - n2;
        return result;
    }
    public double multiply() {
        result = n1 * n2;
        return result;
    }
    public double divide() {
        if (n2 != 0) {
            result = (double) n1 / n2;
            return result;
        }
        System.out.println("Error: Division by zero is not allowed.");
        return 0.0;
    }
    public void setNumbers(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    
    public double getResult() {
        return result;
    }

}
public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cycle = true;
        ArrayList<Process> processes = new ArrayList<>();

        while(cycle){
            System.out.println("Select an option:\n 1.-Add \n 2.-Subtrack \n 3.-Multiply \n 4.-Divide \n 5.-Exit");
            int option = sc.nextInt();
            sc.nextLine();
        
            switch(option){
                case 1:
                    // Add two numbers
                    System.out.print("Enter first number: ");
                    int n1 = sc.nextInt();
                    System.out.print("Enter second number: ");
                    int n2 = sc.nextInt();
                    Process process = new Process();
                    process.n1 = n1;
                    process.n2 = n2;
                    processes.add(process);
                    System.out.println("Result: " + (n1 + n2));
                    break;
                case 2:
                    // Subtract two numbers
                    System.out.print("Enter first number: ");
                    n1 = sc.nextInt();
                    System.out.print("Enter second number: ");
                    n2 = sc.nextInt();
                    System.out.println("Result: " + (n1 - n2));
                    break;
                case 3:
                    // Multiply two numbers
                    System.out.print("Enter first number: ");
                    n1 = sc.nextInt();
                    System.out.print("Enter second number: ");
                    n2 = sc.nextInt();
                    System.out.println("Result: " + (n1 * n2));
                    break;
                case 4:
                    // Divide two numbers
                    System.out.print("Enter first number: ");
                    n1 = sc.nextInt();
                    System.out.print("Enter second number: ");
                    n2 = sc.nextInt();
                    if (n2 != 0) {
                        System.out.println("Result: " + ((double)n1 / n2));
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                case 5:
                    // Exit the program
                    cycle = false;
                    System.out.println("Exiting the calculator.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}

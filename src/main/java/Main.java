import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    System.out.println("Enter a command:");

    Calculator calculator = new Calculator();

    while(true) {
      Scanner s = new Scanner(System.in);

      String command = s.next();

      int firstArg;
      int secondArg;


      switch (command) {
        case "add":
          firstArg = s.nextInt();
          secondArg = s.nextInt();
          System.out.println(calculator.add(firstArg, secondArg));
          break;
        case "subtract":
          firstArg = s.nextInt();
          secondArg = s.nextInt();
          System.out.println(calculator.subtract(firstArg, secondArg));
          break;
        case "multiply":
          firstArg = s.nextInt();
          secondArg = s.nextInt();
          System.out.println(calculator.multiply(firstArg, secondArg));
          break;
        case "divide":
          firstArg = s.nextInt();
          secondArg = s.nextInt();
          System.out.println(calculator.divide(firstArg, secondArg));
          break;
        case "fibonacci":
          firstArg = s.nextInt();
          System.out.println(calculator.fibonacciNumberFinder(firstArg));
          break;
        case "binary":
          firstArg = s.nextInt();
          System.out.println(calculator.intToBinaryNumber(firstArg));
          break;
      }
    }

  }
}

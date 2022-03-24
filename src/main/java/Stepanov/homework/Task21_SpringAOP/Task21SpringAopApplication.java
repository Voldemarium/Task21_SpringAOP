package Stepanov.homework.Task21_SpringAOP;

import Stepanov.homework.Task21_SpringAOP.service.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Task21SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Task21SpringAopApplication.class, args);
        Calculator calculator = context.getBean(Calculator.class);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number");
        int a = scanner.nextInt();
        System.out.print("Enter one of the operators: '+', '-', '*', '/'");

        String operator = scanner.next();
        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            System.out.print("The operator is entered incorrectly! Enter the correct value.");
            operator = scanner.next();
        }

        System.out.print("Enter the second number");
        int b = scanner.nextInt();

        switch (operator) {
            case "+":
                System.out.println(calculator.sum(a, b));
                break;
            case "-":
                System.out.println(calculator.subtract(a, b));
                break;
            case "/":
                System.out.println(calculator.divide(a, b));
                break;
            case "*":
                System.out.println(calculator.multiply(a, b));
                break;
        }
    }
}

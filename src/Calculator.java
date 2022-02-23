import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("this is calculator\nuse only a number as an operand and +, -, * or / as an operation\n");

        float op1 = 0;
        float op2 = 0;
        char operation = '+';

        float result = 0;
        boolean incorrect = false;
        char continueProg = 'c';
        Scanner sc = new Scanner(System.in);

        while (continueProg != 'n' && incorrect != true) {

            if (continueProg == 'c') {
                result = 0;
                System.out.println("1st operand: ");
                if (!sc.hasNextFloat()) {
                    System.out.println("operand can only be a number. try again");
                    break;
                }
                op1 = sc.nextFloat();
            }

            System.out.println("operation: ");
            operation = sc.next().charAt(0);

            System.out.println("2nd operand: ");
            if (!sc.hasNextFloat()) {
                System.out.println("operand can only be a number. try again");
                break;
            }
            op2 = sc.nextFloat();

            switch (operation) {
                case '+': {
                    result = add(op1, op2);
                    break;
                }
                case '-': {
                    result = subtract(op1, op2);
                    break;
                }
                case '*': {
                    result = multiply(op1, op2);
                    break;
                }
                case '/': {
                    if (op2 != 0) {
                        result = divide(op1, op2);
                    } else {
                        System.out.println("you can not divide by 0. try again");
                        incorrect = true;
                    }
                    break;
                }
                default: {
                    System.out.println("available operations: +, -, *, /. try again");
                    incorrect = true;
                }
            };

            if (incorrect == false) {
                System.out.println("result: " + result);
                System.out.println("continue? y/n. type 'c' if you want to start from the beginning");
                continueProg = sc.next().charAt(0);
                op1 = result;
            }
        };

        System.out.println("program finished");
        sc.close();
    }

    public static float add(float a, float b) {
        float res = a + b;
        return res;
    }

    public static float subtract(float a, float b) {
        float res = a - b;
        return res;
    }

    public static float multiply(float a, float b) {
        float res = a * b;
        return res;
    }

    // В функцию не попадают значения b = 0
    public static float divide(float a, float b) {
        float res = a / b;
        return res;
    }
}
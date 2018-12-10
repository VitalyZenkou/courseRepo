package lecture5;

import lecture5.util.operation.Operation;
import lecture5.util.reader.Reader;

public class Calculator {

    private static final Operation OPERATION = new Operation();

    public void run() {
        double variable1 = Reader.readNumber();
        String sign = Reader.readSign();
        double variable2 = readSecondVariable(sign);
        switch (sign) {
            case "+":
                printResult(variable1, sign, variable2, OPERATION.addition(variable1, variable2));
                break;
            case "-":
                printResult(variable1, sign, variable2, OPERATION.subtraction(variable1, variable2));
                break;
            case "/":
                printResult(variable1, sign, variable2, OPERATION.division(variable1, variable2));
                break;
            case "*":
                printResult(variable1, sign, variable2, OPERATION.multiply(variable1, variable2));
                break;
            default:
                System.out.println("Not existing operation!");
        }
    }

    private void printResult(double variable1, String sign, double variable2, double result) {
        System.out.printf("%.2f %s %.2f = %.2f\n", variable1, sign, variable2, result);
    }

    private boolean isNotZero(double variable, String sign) {
        return !(variable == 0) || !sign.equals("/");
    }

    private double readSecondVariable(String sign) {
        double variable;
        do {
            variable = Reader.readNumber();
            if (isNotZero(variable, sign)) {
                return variable;
            } else {
                System.out.println("You try to separate by zero!");
            }
        } while (true);
    }
}

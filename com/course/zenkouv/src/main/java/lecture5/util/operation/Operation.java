package lecture5.util.operation;

public class Operation {

    public double addition(double x, double y) {
        return x + y;
    }

    public double subtraction(double x, double y) {
        return x - y;
    }

    public double division(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Try to separate by zero!");
        }
        return x / y;
    }

    public double multiply(double x, double y) {
        return x * y;
    }
}

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
            System.out.println("Trying to divide by 0!");
            return x;
        } else {
            return x / y;
        }
    }

    public double multiply(double x, double y) {
        return x * y;
    }
}

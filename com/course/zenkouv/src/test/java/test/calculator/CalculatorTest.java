package test.calculator;

import lecture5.util.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Operation operation;

    @BeforeClass
    public void createOperation() {
        operation = new Operation();
        Assert.assertNotNull(operation);
    }

    @Test(dataProvider = "additionOperationData")
    public void testAdditionOperation(double variable1, double variable2, double expectedResult) {
        Assert.assertEquals(operation.addition(variable1, variable2), expectedResult);
    }

    @Test(dataProvider = "subtractionOperationData")
    public void testSubtractionOperation(double variable1, double variable2, double expectedResult) throws InterruptedException {
        Assert.assertEquals(operation.subtraction(variable1, variable2), expectedResult);
    }

    @Test(dataProvider = "divisionOperationData")
    public void testDivisionOperation(double variable1, double variable2, double expectedResult) {
        Assert.assertEquals(operation.division(variable1, variable2), expectedResult);
    }

    @Test(dataProvider = "divisionByZeroOperationData")
    public void testDivisionByZeroOperation(double variable1, double variable2) {
        Assert.assertThrows(ArithmeticException.class, () -> operation.division(variable1, variable2));
    }

    @Test(dataProvider = "multiplyOperationData")
    public void testMultiplyOperation(double variable1, double variable2, double expectedResult) {
        Assert.assertEquals(operation.multiply(variable1, variable2), expectedResult);
    }

    @DataProvider(name = "additionOperationData")
    private Object[][] dataForAdditionOperation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {8.5, 3.2, 11.7}
        };
    }

    @DataProvider(name = "subtractionOperationData", parallel = true)
    private Object[][] dataForSubtractionOperation() {
        return new Object[][]{
                {11.0, 5, 6},
                {8.5, 9, -0.5}
        };
    }

    @DataProvider(name = "divisionOperationData")
    private Object[][] dataForDivisionOperation() {
        return new Object[][]{
                {11.0, 5, 2.2},
                {1, 1, 1}
        };
    }

    @DataProvider(name = "divisionByZeroOperationData")
    private Object[][] dataForDivisionByZeroOperation() {
        return new Object[][]{
                {11.0, 0},
                {1, 0}
        };
    }

    @DataProvider(name = "multiplyOperationData")
    private Object[][] dataForMultiplyOperation() {
        return new Object[][]{
                {11.0, 5, 55},
                {3.1, 7, 21.7}
        };
    }
}

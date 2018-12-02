package calculator;

import lecture5.util.operation.Operation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    private final Operation operation = new Operation();

    @Test(dataProvider = "additionOperationData")
    public void testAdditionOperation(double variable1, double variable2, double expectedResult) {
        Assert.assertEquals(operation.addition(variable1, variable2), expectedResult);
    }

    @Test(dataProvider = "subtractionOperationData")
    public void testSubtractionOperation(double variable1, double variable2, double expectedResult){
        Assert.assertEquals(operation.subtraction(variable1,variable2),expectedResult);
    }

    @Test(dataProvider = "divisionOperationData")
    public void testDivisionOperation(double variable1, double variable2, double expectedResult){
        Assert.assertEquals(operation.division(variable1,variable2),expectedResult);
    }

    @Test(dataProvider = "multiplyOperationData")
    public void testMultiplyOperation(double variable1, double variable2, double expectedResult){
        Assert.assertEquals(operation.multiply(variable1,variable2),expectedResult);
    }

    @DataProvider(name = "additionOperationData")
    private Object[][] dataForAdditionOperation() {
        return new Object[][]{
                {3.0, 4.0, 7.0},
                {8.5, 3.2, 11.7}
        };
    }

    @DataProvider(name = "subtractionOperationData")
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
                {55, 11, 5}
        };
    }

    @DataProvider(name = "multiplyOperationData")
    private Object[][] dataForMultiplyOperation() {
        return new Object[][]{
                {11.0, 5, 55},
                {3, 7, 21}
        };
    }
}

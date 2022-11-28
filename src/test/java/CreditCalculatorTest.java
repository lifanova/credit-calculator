import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CreditCalculatorTest {
    @Test
    public void testCalculateMonthlyPayment() {

        CreditCalculator creditCalculator = new CreditCalculator();

        Random random = new Random();
        int generalAmount = random.nextInt(500_000) + 1_000; // общая сумма кредита
        int termCredit = random.nextInt(10) + 1; // срок кредита
        int percent = random.nextInt(10) + 5; // процент кредита

        int expectedMonthlyPayment = (generalAmount + (generalAmount * percent * termCredit / 100)) / (termCredit * 12);

        int monthlyPayment = creditCalculator.calculateMonthlyPayment(generalAmount, termCredit, percent);

        Assertions.assertEquals(expectedMonthlyPayment, monthlyPayment);
    }

    @Test
    public void testGeneralSumPayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        Random random = new Random();
        int generalAmount = random.nextInt(500_000) + 1_000;
        int termCredit = random.nextInt(10) + 1;
        int percent = random.nextInt(10) + 5;

        int expectedGeneralSum = generalAmount + (generalAmount * percent * termCredit / 100);

        int generalSum = creditCalculator.calculateGeneralSum(generalAmount, termCredit, percent);

        Assertions.assertEquals(expectedGeneralSum, generalSum);
    }

    @Test
    public void testOverPayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        Random random = new Random();
        int generalAmount = random.nextInt(500_000) + 1_000;
        int termCredit = random.nextInt(10) + 1;
        int percent = random.nextInt(10) + 5;

        int expectedOverPayment = (generalAmount * percent * termCredit / 100);

        int overPayment = creditCalculator.calculateOverPayment(generalAmount, termCredit, percent);

        Assertions.assertEquals(expectedOverPayment, overPayment);
    }
}

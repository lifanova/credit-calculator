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
        int procent = random.nextInt(10) + 5; // процент кредита


        int expectedMonathlyPayment = (generalAmount + (generalAmount * procent * termCredit / 100)) / (termCredit * 12);

        int monthlyPayment = creditCalculator.calculateMonthlyPayment(generalAmount, termCredit, procent);

        Assertions.assertEquals(expectedMonathlyPayment, monthlyPayment);
    }

    @Test
    public void testGeneralSumPayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        Random random = new Random();
        int generalAmount = random.nextInt(500_000) + 1_000;
        int termCredit = random.nextInt(10) + 1;
        int procent = random.nextInt(10) + 5;

        int expectedGeneralSum = generalAmount + (generalAmount * procent * termCredit / 100);

        int generalSum = creditCalculator.calculateGeneralSum(generalAmount, termCredit, procent);

        Assertions.assertEquals(expectedGeneralSum, generalSum);
    }

    @Test
    public void testOverPayment() {
        CreditCalculator creditCalculator = new CreditCalculator();

        Random random = new Random();
        int generalAmount = random.nextInt(500_000) + 1_000;
        int termCredit = random.nextInt(10) + 1;
        int procent = random.nextInt(10) + 5;

        int expectedOverPayment = (generalAmount * procent * termCredit / 100);

        int overPayment = creditCalculator.calculateOverPayment(generalAmount, termCredit, procent);

        Assertions.assertEquals(expectedOverPayment, overPayment);
    }
}

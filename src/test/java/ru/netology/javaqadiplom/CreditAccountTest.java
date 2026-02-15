package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    //Тесты для Add()
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceUnderTheExisting() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.add(1_000);

        int expected = 4_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                1_500,
                5_000,
                15
        );
        boolean result = account.add(-200);

        boolean expected = false;
        boolean actual = result;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddToNegativeBalanceNotChange() {
        CreditAccount account = new CreditAccount(
                1_500,
                5_000,
                15
        );
        account.add(-200);

        int expected = 1_500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        boolean result = account.add(0);

        boolean expected = false;
        boolean actual = result;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddZeroNotChange() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.add(0);

        int expected = 2_000;
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddLargeAmount() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                15
        );
        account.add(10_000);

        int expected = 13_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddTopUpToTheCreditLimit() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );
        account.add(1_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddMinimalAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(1);

        int expected = 1_001;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotExceedCreditLimit() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15);
        boolean result = account.add(2_000);

        int expected = 4_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(result);
    }

    //Тесты на Pay()
    @Test
    public void shouldPayPositiveBalance() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(1_000);

        int expected = 3_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayExactlyToCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.pay(5_000);

        int expected = -5_000;
        int actual = account.getBalance();

        Assertions.assertTrue(result);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayNotChangeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.pay(6_000);

        int expected = 0;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldNotPayZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

         account.pay(0);

         int expected = 1_000;
         int actual = account.getBalance();

         Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayNegativeAmount() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.pay(-500);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
        Assertions.assertFalse(result);
    }

    //Тесты на yearChange()
    @Test
    public void shouldReturnZeroWhenBalancePositive() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(2_000);

        int expected = -300;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateYearChange() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_050);

        int expected = -457;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    //Тесты на конструктор
    @Test
    public void shouldThrowExceptionWhenInitialBalanceNegative() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CreditAccount(-1, 5_000, 15)
        );
    }

    @Test
    public void shouldThrowExceptionWhenCreditLimitNegative() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CreditAccount(0, -5_000, 15)
        );
    }

    @Test
    public void shouldThrowExceptionWhenRateNegative() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CreditAccount(0, 5_000, -10)
        );
    }

    @Test
    public void shouldThrowExceptionWhenRateZero() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new CreditAccount(0, 5_000, 0)
        );
    }
}

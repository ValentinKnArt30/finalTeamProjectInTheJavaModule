package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void negativeInitialBalance(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(-2_000, 3_000, 3_500, 10)
        );
    }
    @Test
    public void negativeMinBalance(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(2_000, -3_000, 3_500, 10)
        );
    }
    @Test
    public void negativeMaxBalance(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(2_000, 3_000, -3_500, 10)
        );
    }
    @Test
    public void negativeRate(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(2_000, 3_000, 3_500, -10)
        );

    }
    @Test
    public void minMoreMax(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SavingAccount(2_000, 3_500, 3_000, 10)
        );

    }
    @Test
    public void negativeAmount(){
        SavingAccount account = new SavingAccount(
                2_000,
                3_500,
                4000,
                10
        );
        account.pay(-10);

        int expected = 2000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void negativeAmountFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                3_500,
                4000,
                10
        );
        boolean result = account.pay(-10);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void amountZero(){
        SavingAccount account = new SavingAccount(
                2_000,
                3_500,
                4000,
                10
        );
        account.pay(0);

        int expected = 2000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void amountZeroFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                3_500,
                4000,
                10
        );
        boolean result = account.pay(0);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalanceEqualsMin(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        account.pay(1500);

        int expected = 500;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalanceEqualsMinFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        boolean result = account.pay(500);
        boolean actual = result;
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalanceLessMin(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        account.pay(1800);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalanceLessMinFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        boolean result = account.pay(1800);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalancePositive(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        account.pay(1000);

        int expected = 1_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void payBalancePositiveTrue(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        boolean result = account.pay(1000);
        boolean actual = result;
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addAmountNegative(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        account.add(-10);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addAmountNegativeFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        boolean result = account.add(-10);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addAmountZero(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        account.add(0);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addAmountZeroFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4000,
                10
        );
        boolean result = account.add(0);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceEqualsMax(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        account.add(2_000);

        int expected = 4_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceEqualsMaxTrue(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        boolean result = account.add(2_000);
        boolean actual = result;
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceMoreMax(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        account.add(3_000);

        int expected = 2_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceMoreMaxFalse(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        boolean result = account.add(3_000);
        boolean actual = result;
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceLessMax(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        account.add(1_000);

        int expected = 3_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void addBalanceLessMaxTrue(){
        SavingAccount account = new SavingAccount(
                2_000,
                500,
                4_000,
                10
        );
        boolean result = account.add(1_000);
        boolean actual = result;
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void  yearChangeBalanceZero(){
        SavingAccount account = new SavingAccount(
                0,
                500,
                4_000,
                10
        );
        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  yearChangeBalanceEquals50(){
        SavingAccount account = new SavingAccount(
                50,
                500,
                4_000,
                10
        );
        int expected = 7;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  yearChangeBalanceMore100(){
        SavingAccount account = new SavingAccount(
                150,
                500,
                4_000,
                10
        );
        int expected = 15;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  yearChangeRateZero(){
        SavingAccount account = new SavingAccount(
                150,
                500,
                4_000,
                0
        );
        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void  yearChangePositive(){
        SavingAccount account = new SavingAccount(
                100,
                500,
                4_000,
                20
        );
        int expected = 20;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }



}

package org.example;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    public Wallet wallet;
    public Wallet wallet2;
    public Wallet wallet3;

    @BeforeEach
    void setupMethod() {
        wallet = new Wallet(100000.0, "IDR");
        wallet2 = new Wallet(500.0, "USD");
        wallet3 = new Wallet(25000000.0, "IDR");
    }

    @AfterEach
    void cleanMethod(){
        wallet = null;
    }

    @Test
    void testGetBalance() {
        assertEquals(100000.0, wallet.getBalance());
    }

    @Test
    void testGetCurrency() {
        assertEquals("IDR", wallet.getCurrency());
    }

    @Test
    void testDepositAmount() {
        assertThrows(IllegalArgumentException.class, () -> wallet.depositAmount(-1000.0));
    }

    @Test
    void testDepositAmount2(){
        wallet.depositAmount(200000.0);
        assertEquals(300000.0, wallet.getBalance());
    }
    @Test
    void testWithdrawAmount() {
        assertThrows(IllegalArgumentException.class, () -> wallet.withdrawAmount(-300000.0));
    }

    @Test
    void testWithdrawAmount2(){
        assertFalse(wallet.withdrawAmount(300000.0));
        assertEquals(100000.0, wallet.getBalance());
    }

    @Test
    void testWithdrawAmount3(){
        assertTrue(wallet.withdrawAmount(50000.0));
        assertEquals(50000.0, wallet.getBalance());
    }

    @Test
    void testTransferFunds() {
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(wallet2, 2300000.0));
    }

    @Test
    void testTransferFunds2(){
        assertNotSame(wallet.getCurrency(), wallet2.getCurrency());
        assertThrows(IllegalArgumentException.class, () -> wallet.transferFunds(wallet2, 100000.0));
    }

    @Test
    void testTransferFunds3(){
        wallet.transferFunds(wallet3, 100000.0);
        assertEquals(0.0, wallet.getBalance());
        assertEquals(25100000.0, wallet3.getBalance());
    }
}
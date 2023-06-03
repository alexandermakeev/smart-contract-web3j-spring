package com.example.smartcontract;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CounterContractServiceTest {

    @Autowired
    private CounterContractService counterContractService;

    @Test
    @Order(0)
    void getCount() {
        assertEquals(BigInteger.ZERO, counterContractService.getCount());
    }

    @Test
    @Order(1)
    void increment() {
        counterContractService.increment();
        assertEquals(BigInteger.valueOf(1), counterContractService.getCount());
    }

    @Test
    @Order(2)
    void decrement() {
        counterContractService.decrement();
        assertEquals(BigInteger.ZERO, counterContractService.getCount());
    }
}

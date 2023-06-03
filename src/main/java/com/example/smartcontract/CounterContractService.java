package com.example.smartcontract;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@Service
@Slf4j
public class CounterContractService {

    @Autowired
    private CounterContract counterContract;

    @SneakyThrows
    public BigInteger getCount() {
        return counterContract.getCount().send();
    }

    @SneakyThrows
    public void increment() {
        TransactionReceipt transactionReceipt = counterContract.increment().send();
        log.info("increment transaction : {}", transactionReceipt.getTransactionHash());
    }

    @SneakyThrows
    public void decrement() {
        TransactionReceipt transactionReceipt = counterContract.decrement().send();
        log.info("decrement transaction : {}", transactionReceipt.getTransactionHash());
    }
}

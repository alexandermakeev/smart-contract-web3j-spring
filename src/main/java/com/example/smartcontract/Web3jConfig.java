package com.example.smartcontract;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

@Configuration
@Slf4j
public class Web3jConfig {
    @Value("${ethereum.provider}")
    private String ethereumProvider;
    @Value("${ethereum.private-key}")
    private String ethereumPrivateKey;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(ethereumProvider));
    }

    @Bean
    public Credentials credentials() {
        return Credentials.create(ethereumPrivateKey);
    }

    @Bean
    public CounterContract counterContract() {
        CounterContract counterContract;
        try {
            counterContract = CounterContract.deploy(web3j(), credentials(), new DefaultGasProvider()).send();
//			counter = Counter.load(counterContractAddress, web3j(), credentials(), new DefaultGasProvider());
        } catch (Exception e) {
            log.error("Error while deploying a contract", e);
            throw new RuntimeException(e);
        }
        log.info("Counter contract has been deployed: {}", counterContract.getContractAddress());
        return counterContract;
    }
}

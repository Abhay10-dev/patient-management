package com.lazycoder.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BillingServiceGrpcClient {

    private final BillingServiceGrpc.BillingServiceBlockingStub billingServiceBlockingStub;

    // localhost:9001/BillingService/createBillingAccount
    public BillingServiceGrpcClient(
      @Value("${billing.service.address:localhost}") String serverAddress,
      @Value("${billing.service.port:9001}") int serverPort
    ){
        log.info("Initializing BillingServiceGrpcClient with server address: {} and port: {}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        billingServiceBlockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBilling(BillingRequest billingRequest) {

        BillingRequest request = BillingRequest.newBuilder()
                .setName(billingRequest.getName())
                .setEmail(billingRequest.getEmail())
                .setAge(billingRequest.getAge())
                .setAddress(billingRequest.getAddress())
                .build();

        BillingResponse billingAccount = billingServiceBlockingStub.createBillingAccount(request);

        log.info("Received request from billing service via GRPC {}", billingAccount);

        return billingAccount;
    }
}

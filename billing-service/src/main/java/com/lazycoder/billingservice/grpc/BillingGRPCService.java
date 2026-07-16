package com.lazycoder.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class BillingGRPCService extends BillingServiceGrpc.BillingServiceImplBase {

    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> observerResponse) {

        log.info("Received BillingRequest: {}", billingRequest.toString());

        // Business logic eg. save to database, perform calculations, etc.


        // Dummy data
        BillingResponse response = BillingResponse
                .newBuilder()
                .setBillingAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        observerResponse.onNext(response);
        observerResponse.onCompleted();

    }

}

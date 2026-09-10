package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class DataAggregator {

    public ProductInfo aggregateProductInfo(String productName) {
        CompletableFuture<Double> priceFuture = CompletableFuture
                .supplyAsync(() -> fetchPrice(productName))
                .exceptionally(ex -> 0.0);

        CompletableFuture<String> descriptionFuture = CompletableFuture
                .supplyAsync(() -> fetchDescription(productName))
                .exceptionally(ex -> "Нет данных");

        CompletableFuture<Double> ratingFuture = CompletableFuture
                .supplyAsync(() -> fetchRating(productName))
                .exceptionally(ex -> 0.0);

        return CompletableFuture
                .allOf(priceFuture, descriptionFuture, ratingFuture)
                .thenApply(v -> new ProductInfo(
                        productName,
                        priceFuture.join(),
                        descriptionFuture.join(),
                        ratingFuture.join()
                ))
                .join();
    }

    private double fetchPrice(String productName) {
        simulateDelay();
        throwOnFailure();
        return 899.99;
    }

    private String fetchDescription(String productName) {
        simulateDelay();
        throwOnFailure();
        return "Мощный ноутбук для работы и игр";
    }

    private double fetchRating(String productName) {
        simulateDelay();
        throwOnFailure();
        return 4.7;
    }

    private void simulateDelay() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private void throwOnFailure() {
        if (ThreadLocalRandom.current().nextInt(100) < 20) {
            throw new RuntimeException();
        }
    }
}
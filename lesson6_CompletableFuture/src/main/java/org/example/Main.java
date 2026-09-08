package org.example;

public class Main {
    public static void main(String[] args) {
        DataAggregator aggregator = new DataAggregator();
        ProductInfo info = aggregator.aggregateProductInfo("Ноутбук");
        System.out.println(info);
    }
}
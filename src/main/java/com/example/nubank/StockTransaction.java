package com.example.nubank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockTransaction {

    private String operation;
    private double unitCost;
    private int quantity;

    public StockTransaction() {
    }

    @JsonCreator
    public StockTransaction(
            @JsonProperty("operation") String operation,
            @JsonProperty("unit-cost") double unitCost,
            @JsonProperty("quantity") int quantity) {
        this.operation = operation;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

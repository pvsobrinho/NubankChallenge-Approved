package com.example.nubank;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorService {
    private double costBasis = 0;
    private int heldShares = 0;
    private double accumulatedLoss = 0;

    public List<Tax> calculateTaxes(List<StockTransaction> transactions) {
        List<Tax> taxes = new ArrayList<>();
        double averageCost = costBasis / (heldShares > 0 ? heldShares : 1);

        for (StockTransaction transaction : transactions) {
            double transactionValue = transaction.getUnitCost() * transaction.getQuantity();
            if ("buy".equals(transaction.getOperation())) {
                averageCost = (costBasis + transactionValue) / (heldShares + transaction.getQuantity());
                costBasis += transactionValue;
                heldShares += transaction.getQuantity();
                taxes.add(new Tax(0));
            } else if ("sell".equals(transaction.getOperation())) {
                double gainOrLoss = transaction.getUnitCost() * transaction.getQuantity() - averageCost * transaction.getQuantity();

                if (transactionValue > 20000) {
                    double gainAfterLoss = Math.max(0, gainOrLoss - accumulatedLoss);
                    accumulatedLoss = Math.max(0, accumulatedLoss - gainOrLoss);
                    double tax = gainAfterLoss > 0 ? gainAfterLoss * 0.20 : 0;
                    taxes.add(new Tax(tax));
                } else {
                    if (gainOrLoss < 0) {
                        accumulatedLoss += Math.abs(gainOrLoss);
                    }
                    taxes.add(new Tax(0));
                }
                heldShares -= transaction.getQuantity();
                costBasis = heldShares > 0 ? averageCost * heldShares : 0;
            }
        }

        resetState();
        return taxes;
    }

    private void resetState() {
        costBasis = 0;
        heldShares = 0;
        accumulatedLoss = 0;
    }
}

package com.example.nubank;
import java.util.Objects;

public class Tax {
    private double tax;

    public Tax(double tax) {
        this.tax = tax;
    }


    public double getTax() {
        return tax;
    }

    //Sobreescrevi os metodos equals e hasCode por conta dos testes unitarios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax1 = (Tax) o;
        return Double.compare(tax1.tax, tax) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tax);
    }

    @Override
    public String toString() {
        return "Tax{" + "tax=" + tax + '}';
    }
}

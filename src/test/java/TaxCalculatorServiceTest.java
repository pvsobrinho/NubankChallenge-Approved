import com.example.nubank.StockTransaction;
import com.example.nubank.Tax;
import com.example.nubank.TaxCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class TaxCalculatorServiceTest {

    private TaxCalculatorService service;

    // Isso garante que o estado seja resetado antes de cada teste
    @BeforeEach
    void setUp() {
        service = new TaxCalculatorService();
    }

    @Test
    void testCase1() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 100),
                new StockTransaction("sell", 15.00, 50),
                new StockTransaction("sell", 15.00, 50)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(
                new Tax(0),
                new Tax(0),
                new Tax(0)
        );
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase2() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("sell", 20.00, 5000),
                new StockTransaction("sell", 5.00, 5000)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(
                new Tax(0.0),
                new Tax(10000.0),
                new Tax(0.0)
        );
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase3() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("sell", 5.00, 5000),
                new StockTransaction("sell", 20.00, 3000)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(
                new Tax(0.0),
                new Tax(0.0),
                new Tax(1000.0)
        );
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase4() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("buy", 25.00, 5000),
                new StockTransaction("sell", 15.00, 10000)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(new Tax(0.0), new Tax(0.0), new Tax(0.0));
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase5() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("buy", 25.00, 5000),
                new StockTransaction("sell", 15.00, 10000),
                new StockTransaction("sell", 25.00, 5000)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(new Tax(0.0), new Tax(0.0), new Tax(0.0), new Tax(10000.0));
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase6() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("sell", 2.00, 5000),
                new StockTransaction("sell", 20.00, 2000),
                new StockTransaction("sell", 20.00, 2000),
                new StockTransaction("sell", 25.00, 1000)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(new Tax(0.0), new Tax(0.0), new Tax(0.0), new Tax(0.0), new Tax(3000.0));
        assertEquals(expectedTaxes, calculatedTaxes);
    }

    @Test
    void testCase7() {
        List<StockTransaction> transactions = List.of(
                new StockTransaction("buy", 10.00, 10000),
                new StockTransaction("sell", 2.00, 5000),
                new StockTransaction("sell", 20.00, 2000),
                new StockTransaction("sell", 20.00, 2000),
                new StockTransaction("sell", 25.00, 1000),
                new StockTransaction("buy", 20.00, 10000),
                new StockTransaction("sell", 15.00, 5000),
                new StockTransaction("sell", 30.00, 4350),
                new StockTransaction("sell", 30.00, 650)
        );
        List<Tax> calculatedTaxes = service.calculateTaxes(transactions);
        List<Tax> expectedTaxes = List.of(new Tax(0.0), new Tax(0.0), new Tax(0.0), new Tax(0.0), new Tax(3000.0),
                new Tax(0.0), new Tax(0.0), new Tax(3700.0), new Tax(0.0));
        assertEquals(expectedTaxes, calculatedTaxes);
    }
}

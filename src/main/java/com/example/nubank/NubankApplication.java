package com.example.nubank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class NubankApplication {

    public static void main(String[] args) {
        SpringApplication.run(NubankApplication.class, args);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ObjectMapper mapper = new ObjectMapper();
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        System.out.println(" -> Aplicação iniciada - Ganho de Capital.");
        System.out.println(" -> Insira as operações de mercado em formato JSON. Uma lista por vez. pressione enter. Será validado apos a linha em branco");
        System.out.println(" -> Insira uma linha vazia para terminar as entradas.");

        StringBuilder jsonInputBuilder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {

                if (line.isEmpty()) {
                    if (jsonInputBuilder.length() > 0) {
                        String jsonInput = jsonInputBuilder.toString();
                        List<StockTransaction> transactions = mapper.readValue(jsonInput, new TypeReference<List<StockTransaction>>() {});
                        List<Tax> taxes = taxCalculatorService.calculateTaxes(transactions);
                        System.out.println(mapper.writeValueAsString(taxes));
                        jsonInputBuilder.setLength(0);
                    }
                } else {

                    jsonInputBuilder.append(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro na leitura ou processamento da entrada: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" -> Aplicação finalizada - Ganho de Capital.");
    }
}

package com.iitj.ecgserver;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {
    private List<Integer> numbers;

    public CsvReaderService() {
        this.numbers = new ArrayList<>();
        loadNumbersFromCsv(); // Specify your CSV file path here
    }

    private void loadNumbersFromCsv() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/static/mock_data_ecg.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Assuming each line contains a number, parse it and add to the list
                    numbers.add(Integer.parseInt(line.trim())); // Parse and add to the list
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("exception in csv reader: " + e.getMessage());
        }
    }
    public Integer getNextNumber() {
        if (!numbers.isEmpty()) {
            return numbers.remove(0); // Return and remove the first number
        }
        return null; // Return null if no numbers are left
    }
}

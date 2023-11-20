package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    private int numSales;
    private final List<Double> salesData = new ArrayList<>();
    private int forecastPeriod;
    private double averageSales;

    @FXML
    private TextField numSalesInput;

    @FXML
    private VBox salesInputBox;

    @FXML
    private TextField salesInput;

    @FXML
    private VBox forecastInputBox;

    @FXML
    private TextField forecastPeriodInput;

    @FXML
    private Label salesInputLabel;

    @FXML
    private Label forecastLabel;

    @FXML
    private Label predictedSalesLabel;

    @FXML
    protected void onNumSalesInput() {
        try {
            numSales = Integer.parseInt(numSalesInput.getText());
            salesInputBox.setVisible(true);
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    protected void onSalesInput() {
        try {
            double sales = Double.parseDouble(salesInput.getText());
            salesData.add(sales);
            if (salesData.size() < numSales) {
                salesInput.clear();
            } else {
                forecastInputBox.setVisible(true);
            }
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    protected void onForecastPeriodInput() {
        try {
            forecastPeriod = Integer.parseInt(forecastPeriodInput.getText());
            // Calculate average sales
            double totalSales = 0;
            for (double sales : salesData) {
                totalSales += sales;
            }
            averageSales = totalSales / numSales;

            // Display the calculated average sales
            predictedSalesLabel.setText("Average Sales: " + averageSales);
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    @FXML
    protected void onPredictButtonClick() {
        try {
            // Calculate forecasted sales
            double forecastedSales = averageSales * forecastPeriod;

            // Display the predicted sales
            predictedSalesLabel.setText("Predicted Sales: " + forecastedSales);
        } catch (NumberFormatException e) {
            predictedSalesLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
}

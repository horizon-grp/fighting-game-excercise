package org.example.garbbage;

import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        float number = 12.12345f;

        // Create a DecimalFormat instance with the desired format pattern
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        // Set the rounding mode to down
        decimalFormat.setRoundingMode(java.math.RoundingMode.DOWN);

        // Format the number using the DecimalFormat
        String roundedNumber = decimalFormat.format(number);

        // Parse the rounded number back to float
        float roundedFloat = Float.parseFloat(roundedNumber);

        // Print the rounded float value
        System.out.println("Rounded Number: " + roundedFloat);
    }
}

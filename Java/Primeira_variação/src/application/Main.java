package application;

import java.util.Locale;
import java.util.Random;

import entitiesSources.Triangle;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Locale.setDefault(Locale.US);
        
        // Define the center X, Y and the radius of the circle
        double centerX = 200;
        double centerY = 200;
        double radius = 100;

        int total = 1000000;
        int counter = 0;

        for (int i = 0; i < total; i++) {
            // Create a triangle with two fixed angles
            Triangle triangle = new Triangle(90, 210, radius, centerX, centerY);

            // Generate two random angles to define the chord
            double angle1 = random.nextDouble() * 360;
            double angle2 = random.nextDouble() * 360;

            // Calculate coordinates of the two chord endpoints
            double x1 = Math.cos(Math.toRadians(angle1)) * radius + centerX;
            double y1 = Math.sin(Math.toRadians(angle1)) * radius + centerY;

            double x2 = Math.cos(Math.toRadians(angle2)) * radius + centerX;
            double y2 = Math.sin(Math.toRadians(angle2)) * radius + centerY;

            // Calculate chord length
            double chordLength = triangle.distance(x1, x2, y1, y2);

            // Compare it to the triangle's fixed side
            if (chordLength > triangle.side_distance()) {
                counter++;
            }
        }

        System.out.println("Total times the chord was longer than the triangle side: " + counter);
        double percentage = (double) counter * 100 / total;
        System.out.printf("Percentage: %.2f%%%n", percentage);
    }
}

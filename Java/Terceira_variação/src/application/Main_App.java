package application;

import java.util.Locale;
import java.util.Random;

import entities.Triangle;

public class Main_App {
    public static void main(String[] args) {
        Random random = new Random();
        Locale.setDefault(Locale.US);

        long start = System.currentTimeMillis();

        // Sine corresponds to vertical value (y)
        // Cosine corresponds to horizontal value (x)

        double centerX = 200; // sets the X coordinate of the circle's center
        double centerY = 200; // sets the Y coordinate of the circle's center
        double radius = 100;  // sets the radius of the circle

        // Creates a triangle with 3 defined angles on the circle
        Triangle triangle = new Triangle(90, 210, 330, radius, centerX, centerY);

        double inscribedRadius = radius / 2; // radius of the inner circle (half of the outer)
        int total = 10_000_000;
        int counter = 0;

        for (int i = 0; i < total; i++) {
            // Generate random angle and distance from center (polar coordinates)
            double randomAngle = random.nextDouble() * 2 * Math.PI;
            double randomDistance = Math.sqrt(random.nextDouble()) * radius;

            // Convert polar coordinates to Cartesian
            double pmX = Math.cos(randomAngle) * randomDistance + centerX;
            double pmY = Math.sin(randomAngle) * randomDistance + centerY;

            // Calculate distance from the generated point to the center
            double distanceToCenter = triangle.distance(pmX, centerX, pmY, centerY);

            // Check if the point lies within the inner circle
            if (distanceToCenter <= inscribedRadius) {
                counter++;
            }
        }

        long end = System.currentTimeMillis();
        long executionTime = end - start;

        System.out.println("Total times the point was inside the smaller circle: " + counter);
        counter = (counter * 100) / total;
        System.out.printf("Success rate: %d%%%n", counter);
        System.out.println("Execution time: " + executionTime + " ms");
    }
}

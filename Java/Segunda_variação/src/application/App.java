package application;

import java.util.Random;
import entities.Sources;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        double centerX = 200;
        double centerY = 200;
        double radius = 100;

        Random random = new Random();
        Locale.setDefault(Locale.US);

        int total = 1_000_000;
        int counter = 0;

        for (int i = 0; i < total; i++) {

            // Create a triangle using two fixed angles and circle parameters
            Sources source = new Sources(90, 210, radius, centerX, centerY);
            double triangleSide = source.side_distance();

            // Generate a random angle and a random distance from the center
            double angle = random.nextDouble() * 360;
            double distanceFromCenter = random.nextDouble() * radius;

            // Midpoint of the chord
            double midX = Math.cos(Math.toRadians(angle)) * distanceFromCenter + centerX;
            double midY = Math.sin(Math.toRadians(angle)) * distanceFromCenter + centerY;

            // Half of the chord length (based on distance from center)
            double halfChord = Math.sqrt(radius * radius - distanceFromCenter * distanceFromCenter);

            // Angle perpendicular to the radius direction
            double anglePerp = angle + 90;

            // Point Q1 (one endpoint of the chord)
            double Q1X = Math.cos(Math.toRadians(anglePerp)) * halfChord + midX;
            double Q1Y = Math.sin(Math.toRadians(anglePerp)) * halfChord + midY;

            // Point Q2 (the other endpoint of the chord)
            double Q2X = Math.cos(Math.toRadians(anglePerp + 180)) * halfChord + midX;
            double Q2Y = Math.sin(Math.toRadians(anglePerp + 180)) * halfChord + midY;

            // Calculate the chord length
            double chord = source.distance(Q1X, Q2X, Q1Y, Q2Y);

            // Compare chord length with triangle side length
            if (chord >= triangleSide) {
                counter++;
            }
        }

        System.out.println("Total times the chord was longer than the triangle side: " + counter);
        double result = (double) counter * 100 / total;
        System.out.printf("Success rate: %.2f%%%n", result);
    }
}

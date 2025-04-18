package entitiesSources;

public class Triangle {
    private double Px1, Py1;
    private double Px2, Py2;

    // Construtor que define dois vértices de um triângulo com base em dois ângulos
    public Triangle(int angle1, int angle2, double radius, double centerX, double centerY) {
        Px1 = Math.cos(Math.toRadians(angle1)) * radius + centerX;
        Py1 = Math.sin(Math.toRadians(angle1)) * radius + centerY;

        Px2 = Math.cos(Math.toRadians(angle2)) * radius + centerX;
        Py2 = Math.sin(Math.toRadians(angle2)) * radius + centerY;
    }

    // Calcula o tamanho do lado do triângulo (distância entre os dois pontos definidos)
    public double side_distance() {
        double dx = Px1 - Px2;
        double dy = Py1 - Py2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Calcula a distância entre dois pontos quaisquer
    public double distance(double x1, double x2, double y1, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

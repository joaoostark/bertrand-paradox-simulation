package entities;

public class Sources {
    
    double Px1, Py1;
    double Px2, Py2;
    double Px3, Py3;

    public Sources (int a, int b, double radius, double centerX, double centerY) {
        Px1 = Math.cos(Math.toRadians(a)) * radius + centerX; 
        Py1 = Math.sin(Math.toRadians(a)) * radius + centerY; 

        Px2 = Math.cos(Math.toRadians(b)) * radius + centerX; 
        Py2 = Math.sin(Math.toRadians(b)) * radius + centerY; 
    }

    public double side_distance() {
        double difference_X = Px1 - Px2;
        double difference_Y = Py1 - Py2;
        double size = Math.sqrt((difference_X * difference_X) + (difference_Y * difference_Y));
        return size;

    }

    public  double distance (double p1, double p2, double p3, double p4) {
        double DiferencaX = p1 - p2;
         double DiferencaY = p3 - p4;
         double Tamanho = Math.sqrt((DiferencaX * DiferencaX)+ (DiferencaY* DiferencaY));
        return Tamanho;

    }
    
}

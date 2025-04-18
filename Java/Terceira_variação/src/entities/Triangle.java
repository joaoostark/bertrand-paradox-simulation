package entities;

public class Triangle {
    double Px1, Px2, Py1, Py2, Py3, Px3;


    public  Triangle (int x, int y, int z, double Raio, double CenterX, double CenterY) {
        Px1 = Math.cos(Math.toRadians(x)) * Raio + CenterX; // define o X do primeiro vértice do triângulo
        Py1 = Math.sin(Math.toRadians(x)) * Raio + CenterY; // define o Y do primeiro vértice do triângulo

         Px2 = Math.cos(Math.toRadians(y)) * Raio + CenterX; // define o X do segundo vértice
         Py2 = Math.sin(Math.toRadians(y)) * Raio + CenterY; // define o Y do segundo vértice

         Px3 = Math.cos(Math.toRadians(z)) * Raio + CenterX; // define o X do terceiro vértice
         Py3 = Math.sin(Math.toRadians(z)) * Raio + CenterY; // define o Y do terceiro vértice

    
    }

    public double DistanciaLado() {
        double DiferencaX = Px1 - Px2;
         double DiferencaY = Py1 - Py2;
         double Tamanho = Math.sqrt((DiferencaX * DiferencaX)+ (DiferencaY* DiferencaY));
         return Tamanho;
    }

    public  double distance (double p1, double p2, double p3, double p4) {
        double DiferencaX = p1 - p2;
         double DiferencaY = p3 - p4;
         double Tamanho = Math.sqrt((DiferencaX * DiferencaX)+ (DiferencaY* DiferencaY));
        return Tamanho;

    }

    public double RadiusMediumX (double v1, double v2, double v3) {
        double Diferencax = v1- v2;
        double Vetorx = Diferencax/ v3;
        return Vetorx;

    }

    public double RadiusMediumY (double v4, double v5, double v6) {
        double Diferencay = v4- v5;
        double Vetory = Diferencay/ v6;
        return Vetory;

    }
    


    }


    


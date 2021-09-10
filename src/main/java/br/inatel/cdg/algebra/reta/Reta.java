package br.inatel.cdg.algebra.reta;

public class Reta {

    private Ponto p1,p2;

    public Reta(Ponto p1, Ponto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double coeficienteAngular(){
        double angular = 0.0;
        angular = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());

        return angular;
    }

    public double coeficienteLinear(){
        double linear = 0.0;
        linear = p1.getY() - coeficienteAngular()*p1.getX();

        return linear;
    }
}

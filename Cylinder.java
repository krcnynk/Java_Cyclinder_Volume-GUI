package com.company;

public class Cylinder {
    double h;
    double w;
    double hole;
    double reqLiq;

    //Constructor
    public Cylinder(double a, double b , double c)
    {
        //Calculate the requiredLiquid volume
        h=a;
        w=b;
        hole=c;
        double holeVol = Math.PI*Math.pow(hole,2)*h;
        double cylinderVol = Math.PI*Math.pow((hole+b),2)*h;
        reqLiq = cylinderVol - holeVol;
    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

// All of the code here is designed to be realistic to real-world ratios, so some outputs may look too long and too narrow.
public class Drawings extends JPanel {
    double d1=0,d2=0,h=0;
    //set variables
    void setVariables(double a,double b,double c)
    {
        h=a;//height
        d2=b;//thickness
        d1=c;//hole
    }
    //Override the JPanels paintComponent subroutine
    @Override
    public void paintComponent(Graphics g) {

        double w1, h1, w2, h2, h3;
        double WidthToHeightRatio = 2 * (d1 + d2) / this.h;
        double HoleRatio = d1 / (d1 + d2);
        Graphics2D g2 = (Graphics2D) g;
        //Top cylinder width and height
        w1 = 100;
        h1 = 70;
        //Hole cylinder widht and height, A function of hole radius and total radius
        w2 = w1 * HoleRatio;
        h2 = h1 * HoleRatio;

        // Technically cylinder height but a rectangle
        h3 = 100;

        //Scale for different width and height ratios, there are bounds attached to if loops so that picture doesnt go out of frame
        double scalex, scaley;
        if (WidthToHeightRatio > 1.7) {

            g2.scale(1.7, 2.89 / WidthToHeightRatio); // Scale the image
            scalex = 1.7;
            scaley = 2.89 / WidthToHeightRatio;
            System.out.println(WidthToHeightRatio);
        } else if (WidthToHeightRatio < 0.6) {

            g2.scale(WidthToHeightRatio, 1 / 0.6); // Scale the image
            scalex = WidthToHeightRatio;
            scaley = 1 / 0.6;
        } else //Between the bounds
        {
            g2.scale(WidthToHeightRatio, 1 / WidthToHeightRatio); // Scale freely
            scalex = WidthToHeightRatio;
            scaley = 1 / WidthToHeightRatio;
        }
        /*
        double t1 = -((w1*scalex/2) - (w1/2));
        double height = ((h1/2)+h3+(h2/2));
        double t2 = -((height*scaley/2) - (height/2));
*/

        //Lotta math down here
        g2.setPaint(Color.cyan); // Set color
        g2.fill(new Rectangle2D.Double(0, h1 / 2, w1, h3)); // Rectangle
        g2.setPaint(Color.black);
        g2.draw(new Rectangle2D.Double(0, h1 / 2, w1, h3)); // Rectangle borders

        g2.setPaint(Color.cyan);
        g2.fill(new Ellipse2D.Double(0, 0, w1, h1)); // Top ellipse
        g2.setPaint(Color.black);
        g2.draw(new Ellipse2D.Double(0, 0, w1, h1)); // Top ellipse borders

        g2.setPaint(Color.cyan);
        g2.fill(new Ellipse2D.Double(0, h3, w1, h1)); // Bottom ellipse
        g2.setPaint(Color.black);
        g2.draw(new Ellipse2D.Double(0, h3, w1, h1)); // Bottom ellipse borders
        g2.setPaint(Color.cyan);

        if (d1 != 0) { // If there a hole do
            g2.setPaint(Color.white);
            g2.fill(new Ellipse2D.Double((w1 - w2) / 2, (h1 - h2) / 2, w2, h2)); // Top hole ellipse
            g2.fill(new Ellipse2D.Double((w1 - w2) / 2, h3 + (h1 - h2) / 2, w2, h2)); // Bottom hole ellipse
            g2.setPaint(Color.black);
            g2.draw(new Ellipse2D.Double((w1 - w2) / 2, (h1 - h2) / 2, w2, h2)); // Top hole ellipse borders
            g2.draw(new Ellipse2D.Double((w1 - w2) / 2, h3 + (h1 - h2) / 2, w2, h2)); // Bottom hole ellipse borders
            g2.draw(new Line2D.Double((w1 - w2) / 2, h1 / 2, (w1 - w2) / 2, h1 / 2 + h3));//Inner hole side walls left
            g2.draw(new Line2D.Double((w1 - w2) / 2 + w2, h1 / 2, (w1 - w2) / 2 + w2, h1 / 2 + h3));// Inner hole side walls right
        }
    }
}

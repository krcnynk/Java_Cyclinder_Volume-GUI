package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    //Create Frame,Panel,Textfields,Button, and 2D Drawing objects
    JFrame frame = new JFrame("Part Calculator");
    JPanel panel = new JPanel();
    JTextField field1 = new JTextField(20);
    JTextField field2 = new JTextField(20);
    JTextField field3 = new JTextField(20);
    JTextField field4 = new JTextField(10);
    JButton button = new JButton("Calculate");
    Drawings myDrawing = new Drawings();

    Cylinder myCylinder;
    public void run() {
        //Set bounds for the input panel, change color,make borders, layout is custom and make it visible.
        panel.setBounds(20,60,250,200);
        panel.setBackground(Color.yellow);
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(1.0f)));
        panel.setVisible(true);
        //Do the same for the 2D drawing
        myDrawing.setBounds(320,50,280,300);
        myDrawing.setLayout(null);
        //At first we do not want to show the drawing so false
        myDrawing.setVisible(false);
        //Write input textfield labels and set their bounds/placement
        JLabel label1 = new JLabel();
        label1.setText("Enter height(m) :");
        label1.setBounds(20, 20, 200, 50);

        JLabel label2 = new JLabel();
        label2.setText("Enter thickness(m) :");
        label2.setBounds(20, 60, 200, 50);

        JLabel label3 = new JLabel();
        label3.setText("Enter hole radius(m) :");
        label3.setBounds(20, 100, 200, 50);

        JLabel label4 = new JLabel();
        label4.setText("Needed liquid(m3):");
        label4.setBounds(130,135,110,20);

        //Set bounds for the textfields and button
        field1.setBounds(145,35,100,20);
        field2.setBounds(145,75,100,20);
        field3.setBounds(145,115,100,20);
        field4.setBounds(145,155,100,25);
        button.setBounds(30,150,90,30);
        //Set buttons background color and text color
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        //Add to labels,textfields and button to the input panel
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(field1);
        panel.add(field2);
        panel.add(field3);
        panel.add(field4);
        panel.add(button);
        //Make button an subroutine invoker
        button.addActionListener(this);
        //Add input panel and 2d drawing to the main frame
        frame.add(panel);
        frame.add(myDrawing);
        //Set custom layout, set behaviour on close,set size and make it visible
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        //When button is pressed read from the textfields, create a Cylinder object with corresponding parameters
        double a = Double.parseDouble(field1.getText());
        double b = Double.parseDouble(field2.getText());
        double c = Double.parseDouble(field3.getText());
        myCylinder = new Cylinder(a,b,c);
        //Format the string to 5 decimal places, print the requiredLiquid on field4 textfield
        String out = String.format("%.5f",myCylinder.reqLiq);
        field4.setText(out);

        //Set variables for mydrawing and make it visible + repaint incase variables has changed
        myDrawing.setVariables(a,b,c);
        myDrawing.setVisible(true);
        frame.repaint();
    }
}

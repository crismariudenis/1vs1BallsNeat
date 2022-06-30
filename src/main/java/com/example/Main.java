package com.example;

import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet p;

    public static void main(String[] args) {
        PApplet.main("com.example.Main", args);
    }

    public void settings() {
        size(900, 900);
    }

    public void setup() {
//        frameRate(100);
        p = this;
        Player p1 = new Player();
        Player p2 = new Player();

        Match m = new Match(p1, p2, true);
        NeuralNetwork n = new NeuralNetwork(new int[]{3, 3, 4});
    }

    public void draw() {
        background(180);

    }
}

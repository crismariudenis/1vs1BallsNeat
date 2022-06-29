package com.example;

import processing.core.PVector;

import static java.lang.Math.PI;

public class Match {
    //Dev changeable
    int timeLimit = 100;
    //NN output
    Player p1, p2;
    Bullet b1, b2;
    boolean live;
    Player winner = null;

    public Match(Player p1, Player p2, boolean live) {
        this.p1 = p1;
        this.p2 = p2;
        this.live = live;
        b1=new Bullet(p1.pos,p1.angle);
        b2=new Bullet(p2.pos,p2.angle);
        play();
    }

    private void show() {
        //The matches should be displayed
        if (live) {
            p1.show();
            p2.show();
            if (b1.shoted)
                b1.show();
            if (b2.shoted)
                b2.show();
        }
    }

    private void play() {
        while (timeLimit != 0) {
            //
            //----------NN MAGIC----------
            //INPUT

            //
            //OUTPUT
            float outX1 = 0.5f;// -1.0--1.0
            float outY1 = -0.1f;// -1.0--1.0
            boolean shoot1 = true;
            float angle1 = (float) PI / 2;
            //
            PVector move1 = new PVector(outX1, outY1);
            p1.update(move1,shoot1,angle1);


            if (p1.dead) {
                winner = p1;
                break;
            }
            if (p2.dead) {
                winner = p2;
                break;
            }
            timeLimit--;
            show();
        }
    }
}

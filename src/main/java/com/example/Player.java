package com.example;

import processing.core.PVector;

import static com.example.Main.*;
import static com.example.Main.p;

public class Player {
    //Constants//
    int d = 50, D = 50;
    float speed = 3;
    boolean dead = false;
    ////////////
    Color c;
    Bullet b;
    ///////////
    PVector pos;
    float angle;

    Player(boolean pRight, Bullet b) {
        if (pRight) {
            pos = new PVector(p.width - d / 2, p.height / 2);
            angle = PI;
            c = new Color(0, 0, 200);
        } else {
            pos = new PVector(d / 2, p.height / 2);
            angle = 0;
            c = new Color(200, 0, 0);
        }
    }

    void update(PVector move, boolean shoot, float angle) {
        if(hit()){
            dead=true;
        }
        else if (shoot && !dead && !b.shoted) {
            shoot();
        }

    }

    void show() {
        p.stroke(0);
        p.fill(c.r, c.g, c.b);
        p.ellipse(pos.x, pos.y, d, d);
        p.noStroke();
        p.fill(c.r, c.g, c.b, 100);
        p.arc(pos.x, pos.y, p.width * 1.2f, p.height * 1.2f, angle - PI / 12, angle + PI / 12);

    }
    private boolean hit(){
        float dst=dist(pos.x, pos.y, b.pos.x,b.pos.y);
        return dst<=this.d/2+b.d/2;
    }

    void shoot() {
            ///shot the bullet
            b.shoted = true;
            b.pos = pos;
            b.angle = angle;
    }

}

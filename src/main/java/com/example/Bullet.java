package com.example;

import processing.core.PVector;

import static com.example.Main.*;
import static com.example.Main.p;

public class Bullet {
    int d = 20;
    float speed = 5;
    boolean shoted=false;
    PVector pos;
    float angle;

    Bullet(PVector pos, float angle) {
        this.pos = new PVector();
        this.pos = pos.copy();
        this.angle = angle;
    }

    void show() {
        p.stroke(0);
        p.fill(100);
        p.ellipse(pos.x, pos.y, d, d);
    }

    void move() {
        if(inside()) {
            PVector newPos = PVector.fromAngle(angle);
            pos.add(newPos.x * speed, newPos.y * speed);
        }
        else
            shoted=false;
        show();
    }

    private boolean inside() {
        return min(pos.x, pos.y) > d / 2 && pos.x + d / 2 <p.width && pos.y+d/2<p.height;
    }
}

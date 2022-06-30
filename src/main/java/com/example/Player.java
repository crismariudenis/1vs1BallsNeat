package com.example;

import processing.core.PVector;

import static com.example.Main.*;
import static com.example.Main.p;

public class Player {
    //Constants//
    int d = 50, D = 50;
    float speed = 3;
    boolean dead;
    ////////////
    Color c;
    Bullet b;
    ///////////
    PVector pos;
    float angle;
    Player enemy;
    Player() {
        dead=false;
    }

    void setTeam(boolean pRight) {
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
    void setBullet(Bullet b){
        this.b=b;
    }
    void setEnemy(Player enemy){
       this.enemy=enemy;
    }

    void update(PVector move, boolean shoot, float angle) {
        System.out.println("update");
        if (hitBullet(enemy.b)) {
            ////--------------------------------I the wrong one dies
            dead = true;
        } else if (shoot && !dead && !b.shoted) {
            shoot();
        }
        if(validPose()){
            pos.add(move);
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

    private boolean hitBullet(Bullet bul) {
        float dst = dist(pos.x, pos.y, bul.pos.x, bul.pos.y);
        return dst <= this.d / 2 + b.d / 2;
    }
    private boolean validPose(){
        boolean wallHit=pos.x<d/2 | pos.x> p.width-d/2 | pos.y<d/2 | p.height-d/2<pos.y;
        boolean playerHit= dist(pos.x,pos.y,enemy.pos.x,enemy.pos.y)<d;//distance in smaller than dimater(player1 r= p2 r)
    return !(wallHit | playerHit);
    }

    void shoot() {
        ///shot the bullet
        b.shoted = true;
        b.pos = pos;
        b.angle = angle;
    }

}

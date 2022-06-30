package com.example;

import processing.core.PVector;

import java.time.Instant;

import static java.lang.Math.PI;

public class Match {
    //Dev changeable
    int timeLimit = 1_000_000;//in ms
    //NN output
    Player p1, p2;
    Bullet b1, b2;
    boolean live;
    Player winner = null;

    public Match(Player p1, Player p2, boolean live) {
        this.p1 = p1;
        this.p2 = p2;
        p1.setTeam(true);
        p2.setTeam(false);
        this.live = live;
        b1=new Bullet(p1.pos,p1.angle);
        b2=new Bullet(p2.pos,p2.angle);
        p1.setBullet(b1);
        p2.setBullet(b2);
        setEnemies();
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
        long start = Instant.now().toEpochMilli();
        long now=Instant.now().toEpochMilli();
        //do for timeLimit ms
        while (now-start<timeLimit) {
            //get current time
            now=Instant.now().toEpochMilli();
            //
            //----------NN MAGIC----------
            //INPUT

            //
            //OUTPUT
            float outX1 = 10f;// -1.0--1.0
            float outX2 = -10f;// -1.0--1.0
            float outY1 = 2.1f;// -1.0--1.0
            float outY2=-10.1f;// -1.0--1.0
            boolean shoot1 = false;
            float angle1 = (float) PI / 2;
            //
            PVector move1 = new PVector((int)outX1, (int)outY1);
            PVector move2 = new PVector((int)outX1,(int)outY2);
            p1.update(move1,shoot1,angle1);
            p2.update(move1,shoot1,angle1);


            if (p1.dead) {
                winner = p1;
                System.out.println("Winner is P1");
                break;
            }

            if (p2.dead) {
                winner = p2;
                System.out.println("Winner is P2");
                break;
            }

            show();
        }
    }
    private  void setEnemies(){
        p1.setEnemy(p2);
        p2.setEnemy(p1);
    }
}

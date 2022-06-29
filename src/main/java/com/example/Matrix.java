package com.example;

import java.util.Random;

public class Matrix {
    float[][] mat;
    int height;
    int width;

    Matrix(int height, int width,float mini,float maxi) {
        this.height = height;
        this.width = width;
        mat = new float[height][width];
        initialize(mini,maxi);
    }

    private void initialize(float mini, float maxi) {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                Random R = new Random();
                mat[i][j] = mini + R.nextFloat() * (maxi - mini);
            }
    }

    void print() {
        for (int i = 0; i < height; i++,System.out.println())
            for (int j = 0; j < width; j++) {
                System.out.print(mat[i][j]);
            }
    }

}

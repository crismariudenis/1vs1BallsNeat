package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class NeuralNetwork {
    Matrix[] weights;
    ArrayList<Float>[] bias;
    float minWeight = -10;
    float maxWeight = 10;
    float minBias = -10;
    float maxBias = 10;

    NeuralNetwork(int[] v) {
        bias = (ArrayList<Float>[]) new ArrayList[v.length];
        weights = new Matrix[v.length - 1];
        for (int i = 0; i < v.length; i++) {
            if (i != v.length - 1)//last layer
                weights[i] = new Matrix(v[i], v[i + 1],minWeight,maxWeight);
            bias[i] = new ArrayList<Float>();
            initialize(bias[i],v[i]);

        }
        Matrix m = new Matrix(5, 5,minWeight,maxWeight);
    }

    private void initialize(ArrayList<Float> v,int size) {
        for (int i=0;i<size;i++) {
            Random R = new Random();
            v.add( minBias + R.nextFloat() * (maxBias - minBias));
        }

    }
}


//3,2,1
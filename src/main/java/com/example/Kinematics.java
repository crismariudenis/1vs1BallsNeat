package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Math.*;

public class Kinematics {
    final double l1 = 142.03;
    final double l2 = 124.793;
    final double l3 = 307.085;

    Kinematics() {

    }

    public double[] calc(double x, double y, double z) {

        double alfa3 = acos(y / (sqrt(y * y + z * z)));
        ///y=y'
        y = sqrt(y * y + z * z);
        double alfa2 = -acos((x * x + y * y - l1 * l1 - l2 * l2) / (2 * l1 * l2));
        double alfa1 = atan(y / x) - atan((l2 - sin(alfa2)) / (l1 + l2 * cos(l2)));

        return new double[]{alfa1,alfa2,alfa3};
    }
}

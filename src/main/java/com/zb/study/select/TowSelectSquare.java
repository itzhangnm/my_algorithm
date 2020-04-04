package com.zb.study.select;

public class TowSelectSquare {
    public static void main(String[] args) {
        TowSelectSquare selectSquare = new TowSelectSquare();
        System.out.println(selectSquare.square(5.00,0.000001));
        System.out.println(2.2360679507255554 * 2.2360679507255554);
        System.out.println(2.236067 * 2.236067);
    }

    public double square(double x, double precision) {
        double low = 0;
        double hig = x;
        //小数平方根相反


        if (x > 0 && x < 1) {
            low = x;
            hig = 1;
        }
        double mid = low + (hig - low) / 2;
        while (hig - low > precision) {
            if (mid * mid > x) {
                hig = mid;
            } else if (mid * mid < x) {
                low = mid;
            } else {
                return mid;
            }
            mid = low + (hig - low) / 2;
        }
        return mid;
    }
}

package com.example.surface.calculation01;

/**
 * Created by surface on 2016-09-29.
 */

public class getAverage extends MyValues
{
    double result;

    public double getResult()
    {
        double sum = 0;
        for(int i=0; i<values.length; i++)
            sum+=values[i];

        return result = sum/values.length;
    }
}

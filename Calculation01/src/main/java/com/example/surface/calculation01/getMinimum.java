package com.example.surface.calculation01;

/**
 * Created by surface on 2016-09-29.
 */

public class getMinimum extends MyValues
{
    public double getResult()
    {
        double result = values[0];

        for (int i = 0; i<values.length; i++)
        {
            if(values[i] < result)
                result = values[i];
        }

        return result;
    }

}

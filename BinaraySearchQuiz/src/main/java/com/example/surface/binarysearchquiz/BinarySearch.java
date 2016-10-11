package com.example.surface.binarysearchquiz;

import java.util.Random;

public class BinarySearch
{
    Random rd = new Random();
    int random = rd.nextInt(500);
    int first = 0;
    int last = 500;
    int mid = random;
    int count = 0;


    public int ShowRandomNumber()
    {
        return random;
    }

    public int Bigger()
    {
        first = mid+1;
        mid = (first+last)/2;
        count++;
        return    mid;
    }

    public int Smaller()
    {
        last = mid-1;
        mid = (first+last)/2;
        count++;
        return mid;
    }

    public int Bingo()
    {
        return mid;
    }

}

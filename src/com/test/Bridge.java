package com.test;

import java.util.*;

/*
 * 테스트명 : 징검다리
 * 
 * @ KwangHyeon
 * 기본 테스트만 통과
 * 
 * */


class Bridge 
{
    public int solution(int distance, int[] rocks, int n) 
    {
        
        ArrayList<Integer> minl = new ArrayList<Integer>();
        
        // 순차정렬
        Arrays.sort(rocks);
        // 초기값
        minl.add(rocks[0]);
        // 맨 마지막 값
        minl.add(distance-rocks[rocks.length-1]);
        
        for(int i=1; i<rocks.length; i++)
        {
            minl.add(rocks[i]-rocks[i-1]);
        }
        
        // 최솟값 순차정렬
        Collections.sort(minl);
        
        if(minl.size()==1)
        {
            return minl.get(0);
        }
        else
        {
            return minl.get(rocks.length+1-n);
        }

    }
}

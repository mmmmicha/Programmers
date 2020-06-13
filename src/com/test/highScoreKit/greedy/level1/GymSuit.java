package com.test.highScoreKit.greedy.level1;

import java.util.*;

/*
 * 테스트 명 : 체육복
 * 
 * @KwangHyeon
 * 
 * */

class GymSuit 
{
    public int solution(int n, int[] lost, int[] reserve) 
    {
        int[] total = new int[n];
        Arrays.fill(total, 1);
        int answer = 0;
        
        // reserve
        for(int i=0; i<reserve.length; i++)
        {
            total[reserve[i]-1]=2;
        }
        
        // lost
        for(int i=0; i<lost.length; i++)
        {
            if(total[lost[i]-1]==2)
                total[lost[i]-1] = 1;
            else
                total[lost[i]-1] = 0;
        }
        
        if(total.length>1 && total[0]==2 && total[1]==0)
        {
            total[0]=1;
            total[1]=1;
        }
        
        for(int i=1; i<n-1; i++)
        {
            if(total[i]==2 && total[i-1]==0)
            {
                total[i]=1;
                total[i-1]=1;
            }
            else if(total[i]==2 && total[i+1]==0)
            {
                total[i]=1;
                total[i+1]=1;
            }
        }
        
        if(total[n-1]==2 && total[n-2]==0)
        {
            total[n-1] = 1;
            total[n-2] = 1;
        }
        
        for(int i=0; i<n; i++)
        {
            if(total[i]>=1)
                answer++;
        }
        
        
        return answer;
    }
}

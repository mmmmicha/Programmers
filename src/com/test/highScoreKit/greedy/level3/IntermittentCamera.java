package com.test.highScoreKit.greedy.level3;

import java.util.*;

/*
 * 테스트 명 : 단속카메라
 * 
 * @KwangHyeon
 * 
 * */

class IntermittentCamera 
{
    public int solution(int[][] routes) 
    {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>()
            {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0]<o2[0])
                    return -1;
                else
                    return 1;
            }
        });
        
        /*
        for(int i=0; i<routes.length; i++)
        {
            System.out.println("출 : " + routes[i][0] + ", " + routes[i][1]);
        }
        */
        int s = routes[0][1];
        
        for(int i=0; i<routes.length; i++)
        {
            if(s<routes[i][0])
            {
                answer++;
                s = routes[i][1];
            }   
            else if(s>=routes[i][0])
            {
                s = routes[i][1] <= s ? routes[i][1] : s;
            }
                
        }
        
        return answer;
    }
}
package com.test.highScoreKit.stackAndQueue.level2;

import java.util.*;

/*
 * 테스트 명 : 탑
 * 
 * @KwangHyeon
 * 
 * */

class Top 
{
    public int[] solution(int[] heights) 
    {
        int[] answer = new int[heights.length];
        
        Arrays.fill(answer, 0);
        
        for(int j=heights.length-1; j>0; j--)
        {
            for(int i=j-1; i>-1; i--)
            {
                if(heights[i]>heights[j])
                {
                    answer[j] = i+1;
                    break;
                }
            }
        }
        
        answer[0] = 0;
        
        
        return answer;
    }
}
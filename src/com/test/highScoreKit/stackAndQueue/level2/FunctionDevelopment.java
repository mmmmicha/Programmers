package com.test.highScoreKit.stackAndQueue.level2;

import java.util.*;

/*
 * 테스트 명 : 기능개발
 * 
 * @KwangHyeon
 * 
 * */

class FunctionDevelopment 
{
    public int[] solution(int[] progresses, int[] speeds) 
    {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int max = 0;
        int preMax = 0;
        int count = 0;
        
        if((100-progresses[0])%speeds[0]!=0)
                max = Math.max(((100-progresses[0])/speeds[0])+1, max);
            else
                max = Math.max(((100-progresses[0])/speeds[0]), max);
        
        for(int i=0; i<progresses.length; i++)
        {
            if((100-progresses[i])%speeds[i]!=0)
                preMax = Math.max(((100-progresses[i])/speeds[i])+1, max);
            else
                preMax = Math.max(((100-progresses[i])/speeds[i]), max);
            System.out.println("preMax : " + preMax);
            
            if(preMax==max)
            {
                count++;
            }
            else
            {
                max = preMax;
                ans.add(count);
                count = 1;
            }
        }
        
        ans.add(count);
        
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
}

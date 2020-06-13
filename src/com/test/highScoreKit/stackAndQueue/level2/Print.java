package com.test.highScoreKit.stackAndQueue.level2;

import java.util.*;

/*
 * 테스트 명 : 프린트
 * 
 * @KwangHyeon
 * 
 * */

class Print 
{
    public int solution(int[] priorities, int location) 
    {
        int answer = 1;
        
        LinkedList<Pick> link = new LinkedList<Pick>();
        
        // queue 에 목록들 담기
        for(int i=0; i<priorities.length; i++)
        {
            link.add(new Pick(priorities[i]));
            if(location==i)
                link.get(i).check();
        }
    
        
        while(true)
        {
            Pick temp = link.poll();
            int max = 0;
            for(int j=0; j<link.size(); j++)
            {
                max = Math.max(max, link.get(j).value);
            }
            
            if(max>temp.value)
                link.add(temp);
            else if(temp.status)
                return answer;
            else
                answer++;
                
            
        }
        
       
    }
}

class Pick
{
    int value;
    boolean status = false;
    
    public Pick(int value)
    {
        this.value = value;
    }
    
    public Pick()
    {
        
    }
    
    public boolean check()
    {
        status = true;
        return status;
        
    }
}
package com.test.highScoreKit.hash.level1;

import java.util.*;

/*
 * 
 * 테스트 명 : 완주하지못한 선수
 * 
 * @KwangHyeon
 * 
 * */

public class UnsuccessfulPlayer
{
    public String solution(String[] participant, String[] completion) 
    {
        String answer = "";
        
        HashMap<String, Integer> parti = new HashMap<String,Integer>();
        
        for(int i=0; i<participant.length; i++)
        {
            if(parti.containsKey(participant[i]))
                parti.put(participant[i], parti.get(participant[i])+1);
            else
                parti.put(participant[i], 1);
        }
        
        for(int i=0; i<completion.length; i++)
        {
            if(!parti.containsKey(completion[i]))
                return completion[i];
            else
                parti.put(completion[i], parti.get(completion[i])-1);
        }
        
        Iterator<String> keys = parti.keySet().iterator();
        
        String tempKey = "";
        
        while(keys.hasNext())
        {
            tempKey = keys.next();
            
            if(parti.get(tempKey)!=0)
                answer = tempKey;
            
        }
        
        return answer;
        
    }
}

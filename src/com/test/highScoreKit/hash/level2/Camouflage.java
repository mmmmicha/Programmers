package com.test.highScoreKit.hash.level2;

import java.util.*;

/*
 * 테스트 명 : 위장
 * 
 * @KwangHyeon
 * 
 * */

class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> kind = new HashMap<String, Integer>();
        
        
        for(int i=0; i<clothes.length; i++)
        {
            if(kind.containsKey(clothes[i][1]))
                kind.put(clothes[i][1], kind.get(clothes[i][1])+1);
            else
                kind.put(clothes[i][1], 1);
        }
        
        for(int value : kind.values())
            answer *= (value+1);            
        
        answer -= 1;
        
        
        return answer;
    }
}

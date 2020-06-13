package com.test.highScoreKit.sorting.level1;

import java.util.*;

/*
 * 테스트 명 : K번째 수
 * 
 * @KwangHyeon
 * 
 * */

class KthNumber 
{
    public int[] solution(int[] array, int[][] commands) 
    {
        int[] answer = {};
        
        ArrayList<Integer> temp = null;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        int start = 0;
        int end = 0;
        int num = 0;
        
        answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++)
        {
            start = commands[i][0]-1;
            end = commands[i][1]-1;
            
            temp = new ArrayList<Integer>();
            
            for(int j=start; j<=end; j++)
                temp.add(array[j]);
            
            Collections.sort(temp);
            
            num = commands[i][2]-1;
            
            ans.add(temp.get(num));       
            
        }
        
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
}

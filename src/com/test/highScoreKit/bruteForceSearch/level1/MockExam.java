package com.test.highScoreKit.bruteForceSearch.level1;

import java.util.*;

/*
 * 테스트 명 : 모의고사
 * 
 * @KwangHyeon
 * 
 * */

class MockExam 
{
    public int[] solution(int[] answers) 
    {
        int[] answer = {};
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int count1=0;
        int count2=0;
        int count3=0;
        
        int max = 0;        
        
        for(int i=0; i<answers.length; i++)
        {
            if(answers[i]==one[i%5])
                count1++;
            if(answers[i]==two[i%8])
                count2++;
            if(answers[i]==three[i%10])
                count3++;
        }
        
        max = Math.max(max, count1);
        max = Math.max(max, count2);
        max = Math.max(max, count3);
        
        TreeSet<Integer> trr = new TreeSet<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        trr.add(count1);
        trr.add(count2);
        trr.add(count3);
        
        
        
        if(trr.last()==count1)
            temp.add(1);
        if(trr.last()==count2)
            temp.add(2);
        if(trr.last()==count3)
            temp.add(3);
        
        answer = new int[temp.size()];
        
        for(int i=0; i<temp.size(); i++)
            answer[i] = temp.get(i);
        
        return answer;
        
    }
}
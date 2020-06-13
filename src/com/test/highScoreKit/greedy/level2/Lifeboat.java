package com.test.highScoreKit.greedy.level2;

import java.util.Arrays;

/*
 * 테스트 명 : 구명보트
 * 
 * @KwangHyeon
 * 
 * */

class Lifeboat 
{
    public int solution(int[] people, int limit) 
    {
        int answer = 0;
        
        Arrays.sort(people);
        boolean[] check = new boolean[people.length];
        boolean doing = false;
        
        int end = people.length-1;
        
        for(int i=0; i<people.length; i++)
        {
            if(!check[i])
            {
                for(int j=end; j>i; j--)
                {
                    //System.out.println("j : " + j);
                    if(!check[j])
                    {
                        if(people[i]+people[j]<=limit)
                        {
                            //System.out.println("people : " + people[i] + ", people[j] : " + people[j] + ", limit : " + limit + ", answer : " + answer);
                            check[j]=true;
                            doing = true;
                            answer++;
                            end = j-1;
                            break;
                        }
                        else
                        {
                            check[j]=true;
                            answer++;
                        }
                    }
                }
                if(!doing)
                    answer++;
                
                check[i]=true;
            }
            doing = false;
        }
        
        if(!check[0])
            answer++;
        
        return answer;
    }
}
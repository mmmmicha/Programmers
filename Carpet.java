package com.test;

/*
 * Test명 : 카펫
 * 
 * @KwangHyeon
 * 테스트케이스 4,6,7 안됨.
 * 
 * 
 * */

class Carpet 
{
    public int[] solution(int brown, int red) 
    {
        int[] answer = new int[2];
        int sum = brown+red;
        
        for(int i=1; i<sum; i++)
        {
            answer[0] = i;
            
            if(sum%i==0)
            {
                answer[1]=sum/i;
            }
            
            if(answer[0]>=answer[1])
            {
                break;
            }
        }
        
        return answer;
    }
}

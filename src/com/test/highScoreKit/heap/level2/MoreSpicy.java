package com.test.highScoreKit.heap.level2;

import java.util.*;

/*
 * 테스트 명 : 더 맵게
 * 
 * @KwangHyeon
 * 
 * */

class MoreSpicy 
{
    
    public static int solution(int[] scoville, int K) 
    {
        int answer = -1;
        int s1 = 0, s2 = 0;
        int temp = 0, times = 0;
        Queue<Integer> pq = new PriorityQueue<Integer>(scoville.length);
        
        for(int i=0; i<scoville.length; i++)
        {
            pq.offer(scoville[i]);
        }
        
        while(pq.size() > 1)
        {
            if(pq.peek() >= K)
            {
                answer = times;
                break;
            }
            
            s1 = pq.poll();
            s2 = pq.poll();
            temp = s1+s2*2;
            pq.offer(temp);
            times++;
        }
        
        if(pq.poll() >= K)
            answer = times;
        
        return answer;
    }
    
    public static void main(String[] args)
    {
        int K = 7;
        int[] scoville = {1,2,3,9,10,12};
        
        solution(scoville, K);
        
    }
}

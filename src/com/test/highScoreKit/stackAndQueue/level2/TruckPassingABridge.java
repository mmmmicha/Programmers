package com.test.highScoreKit.stackAndQueue.level2;

import java.util.*;

/*
 * 테스트 명 : 다리를 지나는 트럭
 * 
 * @KwangHyeon
 * 
 * */

class TruckPassingABridge 
{
    public static int solution(int bridge_length, int weight, int[] truck_weights) 
    {
        int answer = 0;
        
        ArrayList<Integer> bridge = new ArrayList<Integer>();
        Stack<Integer> truck = new Stack<Integer>();
        
        // stack 에 truck 저장
        for(int i=truck_weights.length-1; i>-1; i--)
            truck.push(truck_weights[i]);
        
        int limit;
        
        while(true)
        {
            // 시간 증가
            answer++;
            
            limit = 0;
            
            // 맨마지막에 도달한 트럭은 제거
            if(bridge.size()==bridge_length)
                bridge.remove(0);
            
            
            
            for(int i=0; i<bridge.size(); i++)
            {
                // 현재 다리에 있는 트럭들의 총 무게 계산
                limit += bridge.get(i);
            }
            // 이제 들어올 트럭의 무게 더하기
            if(!truck.isEmpty())
            {
            	limit += truck.peek();
                
            }
            else
            	limit += 0;
            
            if(limit == 0)
            	return answer;
            
            
            
            // 다리에 무게 허용이 가능한 경우 pop() 을 해주기
            // 무게허용이 불가한 경우 0 을 넣어주기
            if(limit > weight)
            {
            	if(bridge.size()==bridge_length)
            	{
            		for(int i=0; i<bridge.size(); i++)
                    {
                        bridge.set(i, bridge.get(i+1));
                    }
            		
            		bridge.set(bridge_length-1, 0);
            	}
            	else
            	{
            		bridge.add(0);
            	}
                
            }
            else
            {
            	
            	if(bridge.size()==bridge_length)
            	{
            		for(int i=0; i<bridge.size(); i++)
                    {
                        bridge.set(i, bridge.get(i+1));
                    }
            		
            		if(!truck.isEmpty())
            			bridge.set(bridge_length-1, truck.pop());
            		else
            			bridge.set(bridge_length-1, 0);
            	}
            	else
            	{
            		if(!truck.isEmpty())
            			bridge.add(truck.pop());
            		else
            			bridge.add(0);
            	}
            }
            
        }
        
    }
    
    public static void main(String[] args)
    {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        
        solution(bridge_length, weight, truck_weights);
        
    }
}

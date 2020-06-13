package com.test.highScoreKit.heap.level3;

import java.util.*;

/*
 * 테스트 명 : 이중우선순위큐
 * 
 * @KwangHyeon
 * 
 * */

class DoublePriorityQueue 
{
    public int[] solution(String[] operations) 
    {
        int[] answer = {};
        String[] div = null;
        ArrayList<Integer> num = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++)
        {
            div = operations[i].split(" ");
            
            if(div[0].equals("I"))
            {
                num.add(Integer.parseInt(div[1]));
                Collections.sort(num);
            }   
            else if(div[0].equals("D")&&num.size()!=0)
            {
                if(div[1].equals("1"))
                {
                    num.remove(num.size()-1);
                }
                else if(div[1].equals("-1"))
                {
                    num.remove(0);
                }
            }
        }
        
        answer = new int[2];
        
        if(num.size()==0)
        {
            answer[0] = 0;
            answer[1] = 0;
        }
        else if(num.size()==1)
        {
            if(num.get(0)>0)
            {
                answer[0] = num.get(0);
                answer[1] = 0;
            }
            else
            {
                answer[0] = 0;
                answer[1] = num.get(0);
            }
            
        }
        else
        {
            answer[0] = num.get(num.size()-1);
            answer[1] = num.get(0);
        }
       
        
        return answer;
    }
}

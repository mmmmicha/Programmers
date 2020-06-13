package com.test.highScoreKit.stackAndQueue.level2;

import java.util.Stack;

class IronBar 
{
    public int solution(String arrangement) 
    {
        int answer = 0;
        // 배열 저장
        String[] arr = arrangement.split("");
        
        Stack<String> st = new Stack<String>();
        
        for(int i=0; i<arr.length-1; i++)
        {
            if((arr[i]+arr[i+1]).equals("()"))
            {
                i++;
                if(st.isEmpty())
                    answer += 0;
                else
                    answer += st.size();
            }
            else if(arr[i].equals("("))
                st.push("(");
            else if(arr[i].equals(")"))
            {
                st.pop();
                answer += 1;
            }
        }
        
        answer += st.size();
        
        return answer;
    }
}

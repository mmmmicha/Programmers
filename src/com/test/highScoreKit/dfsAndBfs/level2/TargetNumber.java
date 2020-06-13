package com.test.highScoreKit.dfsAndBfs.level2;

/*
 * 테스트 명 : 타겟 넘버
 * 
 * @KwangHyeon
 * 
 * */

class TargetNumber 
{
    
    static int answer = 0;
    static int[] numarr = null;
    
    public static int solution(int[] numbers, int target) 
    {
        numarr = new int[numbers.length];
        int count = 0;
            
        for(int i=0; i<numbers.length; i++)
        {
            numarr[i] = numbers[i];
        }
        
        dfs(0, target, numbers.length, count);
        return answer;
    }
    
    public static void dfs(int num, int target, int end, int count)
    {
        int temp = num;
        
        
        if(count==end)
        {
            if(temp==target)
            {
                answer++;
                return;
            }
            return;
        }
            

        
        
        dfs(temp + numarr[count], target, end, count+1);
        dfs(temp - numarr[count], target, end, count+1);
        return;
        
    }
    
    public static void main(String[] args)
    {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        solution(numbers, target);
    }
}
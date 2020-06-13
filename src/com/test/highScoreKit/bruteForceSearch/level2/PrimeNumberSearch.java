package com.test.highScoreKit.bruteForceSearch.level2;

import java.util.*;

/*
 * 테스트 명 : 소수 찾기
 * 
 * @KwangHyeon
 * 
 * */

class PrimeNumberSearch 
{
    TreeSet<String> trr = new TreeSet<String>();
    
    public int solution(String numbers) 
    {
        int answer = 0;
        
        String[] numCh = numbers.split("");
        boolean[] check = new boolean[numCh.length];
        
        //System.out.println(numCh.length);
        
        Arrays.fill(check, false);
        
        for(int i=0; i<numCh.length; i++)
        {
            check[i] = true;
            if(numCh[i].equals("0"))
                dfs(numCh, "", check);
            else
            {
                //System.out.println("여기 : " + numCh[i]);
                dfs(numCh, numCh[i], check);
                trr.add(numCh[i]);
            }
            check[i] = false;
        }
        
        // 최댓값 까지의 배열 숫자 구하기
        boolean[] prime = new boolean[Integer.parseInt(trr.last()+1)];
        
        prime[0] = true;
        prime[1] = true;
        
        // 소수 구하기
        for(int i=2; i<Integer.parseInt(trr.last()+1); i++)
        {
            if(!prime[i])
            {
                for(int j=i*2; j<Integer.parseInt(trr.last()+1); j+=i)
                {
                    prime[j] = true;
                }
            }
        }
        
        for(String temp : trr)
        {
            int tempi = Integer.parseInt(temp);
            
            if(!prime[tempi])
            {
                System.out.println("temp : " + tempi);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String[] numCh, String pre, boolean[] check)
    {
        for(int i=0; i<numCh.length; i++)
        {
            //System.out.println("여기 2 : " + numCh[i] + ", check : " + check[i]);
            if(!check[i])
            {
                
                if(pre.equals("") && numCh[i].equals("0"))
                {
                    check[i] = true;
                    dfs(numCh, "", check);
                    check[i] = false;
                }
                else
                {
                    check[i] = true;
                    //System.out.println("조합 : " + pre+numCh[i]);
                    dfs(numCh, pre+numCh[i], check);
                    check[i] = false;
                    trr.add(pre+numCh[i]);
                }
                
            }
            
        }
        return;
    }
}

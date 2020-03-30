package com.test;

import java.util.*;

/*
 * Test명 : 단어변환
 * 
 * @ KwangHyeon 
 *   테스트케이스 3번이 안풀림..
 *
 */

class Word_conversion 
{
    static TreeSet<Integer> min = new TreeSet<Integer>();
    static String tar;
    
    public static int solution(String begin, String target, String[] words) 
    {
        tar = target;
        
        boolean check = false;
        boolean[] cw = new boolean[words.length];
        for(int i=0; i<words.length; i++)
        {
            if(words[i].equals(target))
                check = true;
        }
        
        if(!check)
            return 0;
        
        int count = 0;
        dfs(begin, words, cw, count);
        
        //System.out.println("answer : " + min.first());
        
        return min.first();
    }
    
    public static void dfs(String pre, String[] words, boolean[] cw, int count)
    {
        if(pre.equals(tar))
        {
            min.add(count);
            return;
        }
        
        for(int i=0; i<words.length; i++)
        {
            int cnt=0;
            
            if(!cw[i])
            {
                for(int j=0; j<pre.length(); j++)
                {
                    if(words[i].indexOf(pre.substring(j,j+1))!=-1)
                        cnt++;
                }
                
                if(cnt==(tar.length()-1))
                {
                	//System.out.println("answer : " + words[i]);
                    cw[i] = true;
                    dfs(words[i], words, cw, count+1);
                    cw[i] = false;
                }
            }
            
        }
        return;
            
    }
}
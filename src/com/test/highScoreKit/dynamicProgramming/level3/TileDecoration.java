package com.test.highScoreKit.dynamicProgramming.level3;

import java.util.*;

/*
 * 테스트 명 : 타일장식물
 * 
 * @KwangHyeon
 * 
 * */

class TileDecoration 
{
    public long solution(int N) 
    {
        long answer = 0;
        
        ArrayList<Long> list = new ArrayList<Long>();
        
        if(N==1)
            return 4;
        if(N==2)
            return 6;
        
        list.add(1L);
        list.add(1L);
        
        for(int i=2; i<N; i++)
        {
            list.add(list.get(i-2)+list.get(i-1));
        }
        
        return (list.get(list.size()-2)+2*list.get(list.size()-1))*2;
    }
}
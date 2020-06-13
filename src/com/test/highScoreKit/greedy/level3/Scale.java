package com.test.highScoreKit.greedy.level3;

import java.util.*;

/*
 * 테스트 명 : 저울
 * 
 * @KwangHyeon
 * 
 * */

class Scale
{
	public int solution(int[]weight)
	{
		Arrays.sort(weight);
		
		if(weight[0]!=1)
			return 1;
		
		int[]sum=new int[weight.length];
		
		int tmpsum=0;
		
		for(int i=0;i<weight.length;i++)
		{
			tmpsum+=weight[i];
			sum[i]=tmpsum;
			
			if(i<weight.length-1&&sum[i]+1<weight[i+1])
			{
				return sum[i]+1;
			}
		}
		return sum[sum.length-1]+1;
	}
}

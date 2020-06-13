package com.test.highScoreKit.binarySearch.level4;

import java.util.*;

/*
 * 테스트 명 : 징검다리
 * 
 * @KwangHyeon
 * 
 * */

class SteppingStones 
{
    public int solution(int distance, int[] rocks, int n) {
    
    Arrays.sort(rocks);

    int answer = 1;
    int start = 1;
    int end = distance;
    
    while (start <= end) {
      int mid = (start + end) / 2;
        //System.out.println("start : " + start + ", end : " + end + ", mid : " + mid);
      
      int cnt = 0;
      int last = 0;
      for (int i = 0; i < rocks.length + 1; i++) {
        int gap = i != rocks.length ? rocks[i] - last : distance - rocks[i-1];
        if (gap < mid) {
          cnt++;
        } else if(i != rocks.length) {
          last = rocks[i];
        }
          //System.out.println("last : " + last + ", cnt : " + cnt + ", gap : " + gap);
      }
      
        //System.out.println("cnt : " + cnt + ", n : " + n);
        
      if (cnt > n) {
        end = mid - 1;
      } else {
        start = mid + 1;
        answer = mid;
      }
    }
    
    return answer;
  }
}

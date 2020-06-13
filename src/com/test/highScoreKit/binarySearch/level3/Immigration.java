package com.test.highScoreKit.binarySearch.level3;

/*
 * 테스트 명 : 입국 심사
 * 
 * @KwangHyeon
 * 
 * */

class Immigration {
    public long solution(int n, int[] times) {
        int max = 0;
        for (int time : times) {
            if(time > max) max = time;
        }
 
        long low = 1;
        long high = (long)max * n;  // 최악의 상황
 
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            long count = passCount(mid, times);
            if (count < n) low = mid;
            else high = mid;
        }
 
        if(passCount(low, times) >= n) return low;
        return high;
    }
 
 
    public long passCount(long mid, int[] times) {
        long count = 0;
        for (int time : times) {
            if (time > mid) continue;
            count += (mid / time);
        }
        return count;
    }
}
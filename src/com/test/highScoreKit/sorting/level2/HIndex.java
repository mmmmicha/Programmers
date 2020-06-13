package com.test.highScoreKit.sorting.level2;

import java.util.Arrays;
import java.util.Collections;
 
/*
 * 테스트 명 : H-인덱스
 * 
 * @KwangHyeon
 * 
 * */

class HIndex {
    public int solution(int[] citations) {
        Integer[] cArr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cArr[i] = citations[i];
        }
        Arrays.sort(cArr, Collections.reverseOrder());
        for (int i = 0; i < citations.length; i++) {
            if (cArr[i]<i+1) {
                return i;
            }
        }
        return citations.length;
    }
}

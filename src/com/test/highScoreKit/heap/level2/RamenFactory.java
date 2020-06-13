package com.test.highScoreKit.heap.level2;

import java.util.*;

/*
 * 테스트 명 : 라면공장
 * 
 * @KwangHyeon
 * 
 * */

class RamenFactory {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
 
        int index = 0;
        for (int i = 0; i < k; i++) {
            if(index < dates.length && i == dates[index])
                priorityQueue.add(supplies[index++]);
            //System.out.println("i : " + i + ", stock : " + stock);
            if(stock == 0) {
                stock += priorityQueue.poll();
                answer++;
            }
            stock -= 1;
        }
        return answer;
    }
}

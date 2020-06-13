package com.test.highScoreKit.heap.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 테스트 명 : 디스크 컨트롤러
 * 
 * @KwangHyeon
 * 
 * */

class DiskController {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();
        
        //PriorityQueue를 활용한 Job 정렬
        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }
        
        //list에 우선순위 순으로 정렬된 Job 순차적으로 삽입
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }
        
        int time = 0;
        int sum = 0;
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //시작시간이 현재 시간보다 이전이라면 시작 가능
                if (time>=list.get(i).start) {
                    time+=list.get(i).workTime;
                    sum+=time-list.get(i).start;
                    list.remove(i);
                    break;
                }
                //시작시간이 현재 시간보다 이전인 것이 없다면 시간 1초 증가
                if (i == list.size()-1) time++;
            }
        }
        
        int answer = (sum/jobs.length);
        return answer;
    }
}

class Job implements Comparable<Job> {
    int start;
    int workTime;
    
    public Job(int start, int time) {
        this.start = start;
        this.workTime = time;
    }
    
    //걸리는 소요시간이 짧을수록, 시작 시간이 짧을 수록 우선수위를 높게함
    @Override
    public int compareTo(Job o) {
        if (this.workTime < o.workTime) return -1;
        else if (this.workTime == o.workTime) {
            if (this.start < o.start) return -1;
            else return 1;
        } else return 1;
    }
}
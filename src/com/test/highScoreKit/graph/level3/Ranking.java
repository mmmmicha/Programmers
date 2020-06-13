package com.test.highScoreKit.graph.level3;

import java.util.*;

/*
 * 테스트 명 : 순위
 * 
 * @KwangHyeon
 * 
 * */

class Ranking
{
    // 방문 불가
    int INF = 987654321;
    
    public int solution(int n, int[][] results)
    {
        int answer = 0;
        int[][] scores = new int[n+1][n+1];
        int win, lose;
        
        // 배열 초기화
        for(int[] score : scores)
        {
            Arrays.fill(score, INF);
        }
        
        // 대각선을 0
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i==j)
                    scores[i][j]=0;
            }
        }       
        
        // 한방향 그래프 win -> lose
        for(int[] result : results)
        {
            win=result[0];
            lose=result[1];
            scores[win][lose]=1;
        }
        
        //scores[i][j] 로 가는 최단 경로 저장
        for(int k=1; k<=n; k++)
        {
            for(int i=1; i<=n; i++)
            {
                for(int j=1; j<=n; j++)
                {
                    if(scores[i][j]>scores[i][k]+scores[k][j])
                        scores[i][j] = scores[i][k]+scores[k][j];
                }
            }
        }
        // for(int[] score:scores){
         //     System.out.println(Arrays.toString(score));
         // }
         //선수들이 게임을 한 적이 있는지 확인
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=1; i<=n; i++)
        {   // 사람 i 기준
            for(int j=1; j<=n; j++)
            {   // j 선수들과 게임한 적 있는지 체크
                if(i==j)    // 스스로 제외
                    continue;
                
                if(scores[i][j]==INF&&scores[j][i]==INF)
                {   // 경로가 존재하지 않으면(i 와 j 가 게임하지 않았다면)
                    flag[i]=false;
                    break;    // 모두와 게임을 해야함
                }
            }
        }
        
        for(int i=1; i<flag.length; i++)
        {
            if(flag[i])
                answer++;
        }
        
        return answer;
    }
    
}

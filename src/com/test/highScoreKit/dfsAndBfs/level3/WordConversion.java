package com.test.highScoreKit.dfsAndBfs.level3;

import java.util.HashSet;

/*
 * 테스트 명 : 단어 변환
 * 
 * @KwangHyeon
 * 
 * */

public class WordConversion {
    static String[] wordset;
    static boolean[] visited;
    static String strTarget;
    static int totalcount;
    public int solution(String begin, String target, String[] words){
        int answer = 0;
        HashSet<String>isPossible = new HashSet<>();

        visited = new boolean[words.length];
        strTarget= target;
        totalcount = 2147483647;
        int count = 0;
        if(begin.equals(target)){
            return 0;
        }
        for(String tmp : words){
            if(begin.equals(tmp)){
                continue;
            }
            isPossible.add(tmp);
        }
        wordset = isPossible.stream().toArray(String[]::new);
        if(!isPossible.contains(target)){
            return 0;
        }else{
            dfs(0,begin);
        }
        return totalcount;

    }

    private void dfs(int i, String begin) {
        if(begin.equals(strTarget)){
            if(totalcount>i){
                totalcount = i;
            }
            return;

        }else{
            for(int counting = 0;counting<wordset.length;counting++){
                if(!visited[counting] && isChanged(begin,wordset[counting])){
                    visited[counting] = true;
                    dfs(i+1,wordset[counting]);
                    visited[counting] = false;
                }
            }
        }
    }

    private boolean isChanged(String begin, String s) {
        int count =0;
        for(int i=0;i<begin.length();i++){
            if(begin.charAt(i)!=s.charAt(i)){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
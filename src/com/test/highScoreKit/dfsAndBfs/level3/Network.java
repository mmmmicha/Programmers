package com.test.highScoreKit.dfsAndBfs.level3;

import java.util.*;

/*
 * 테스트 명 : 네트워크
 * 
 * @KwangHyeon
 * 
 * */

class Network {
    public int solution(int n, int[][] computers) 
    {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        ArrayList<Node> nodes = new ArrayList<Node>();
        // 네트워크 종류 담기 위한 treeSet
        TreeSet<Integer> jongList = new TreeSet<Integer>();
        
        for(int i=0; i<computers.length; i++)
        {
            computers[i][i] = 0;
            nodes.add(new Node(i));
        }
        
        for(int i=0; i<computers.length; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(computers[i][j]==1)
                {
                    nodes.get(i).adj.add(j);
                }
            }
        }
        
        // 담아놓고 꺼낼 큐
        Queue<Node> q = new LinkedList<Node>();
        
        for(int i=0; i<n; i++)
        {
            if(!check[i])
            {
                q.add(nodes.get(i));
                check[i] = true;
            }
            
            while(!q.isEmpty())
            {
                Node node = q.poll();
                //System.out.println("node : " + node.v);
                
                for(Integer no : node.adj)
                {
                    if(!check[no])
                    {
                        check[no] = true;
                        Node temp = nodes.get(no);
                        temp.jong = node.jong;
                        jongList.add(temp.jong);
                        q.add(temp);
                    }
                }
                
                jongList.add(node.jong);
                   
            }
        }
        
        return jongList.size();
    }
}

class Node
{
    // 노드 번호
    public int v;
    // 인접 노드 정보 저장
    ArrayList<Integer> adj = new ArrayList<Integer>();
    // 종속 번호
    public int jong;
    
    public Node(int v)
    {
        this.v = v;
        this.jong = v;
    }
}
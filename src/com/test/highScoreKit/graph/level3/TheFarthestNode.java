package com.test.highScoreKit.graph.level3;

import java.util.*;

/*
 * 테스트 명 : 가장 먼 노드
 * 
 * @KwangHyeon
 * 
 * */

class TheFarthestNode 
{ 
    public int solution(int n, int[][] edge) 
    {
        int answer=0;
        
        // 노드들 준비시키기
        ArrayList<Node> nodes = new ArrayList<Node>();
        
        // 빈 노드 0 하나 넣어두기
        nodes.add(new Node(0,0));
        
        // 노드 생성 후 넣어두기
        for(int i=1; i<=n; i++)
        {
            nodes.add(new Node(i,0));
        }
        
        // 인접 노드들 입력하기
        for(int i=0; i<edge.length; i++)
        {
            
            nodes.get(edge[i][1]).addAdj(nodes.get(edge[i][0]));

            nodes.get(edge[i][0]).addAdj(nodes.get(edge[i][1]));
        }
        
        // 각 노드 방문확인 배열
        boolean[] visited = new boolean[n+1];
        
        Arrays.fill(visited, false);
        
        // 노드 방문시마다 로그를 남기는 queue
        Queue<Node> q = new LinkedList<Node>();
        
        // depth 만 담는 ArrayList
        ArrayList<Integer> dep = new ArrayList<Integer>();
        
        visited[1] = true;
        q.offer(nodes.get(1));
        
        Node node = null;
        
        while(!q.isEmpty())
        {
            // 하나 꺼내기
            node = q.poll();
            
            // adj 꺼내기
            Iterator<Node> i = node.adj.iterator();
            Node adjNode = null;
            while(i.hasNext())
            {
                adjNode = i.next();
                
                // 이미 방문했으면 이 과정 건너 뛰기
                if(visited[adjNode.v])
                    continue;
                
                nodes.get(adjNode.v).setDepth(node.getDepth()+1);
                q.offer(nodes.get(adjNode.v));
                dep.add(node.getDepth()+1);
                visited[adjNode.v] = true;
            }
            
        }
        
        int max = 0;
        for(Integer d : dep)
            max = Math.max(d, max);
        
        for(Integer d : dep)
        {
            
            if((int)d==max)
                answer++;
        }
        
        return answer;
    }
}

class Node
{
    // 노드 번호
    public int v;
    // 인접한 노드의 리스트
    ArrayList<Node> adj = new ArrayList<Node>();
    // 거리 번호
    public int depth;
    
    public Node(int v, int depth)
    {
        this.v = v;
        this.depth = depth;
    }
    
    public Node()
    {
        
    }
    
    public int getDepth()
    {
        return this.depth;
    }
    
    public void setDepth(int depth)
    {
        this.depth = depth;
    }
    
    public void addAdj(Node v)
    {
        adj.add(v);
    }
    

}
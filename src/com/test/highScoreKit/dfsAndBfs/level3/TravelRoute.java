package com.test.highScoreKit.dfsAndBfs.level3;

import java.util.*;

/*
 * 테스트 명 : 여행 경로
 * 
 * @KwangHyeon
 * 
 * 미해결
 * 
 * */

class TravelRoute 
{
    public static String[] solution(String[][] tickets) 
    {
        ArrayList<String> answerL = new ArrayList<String>();
        
        HashMap<String, Defi> world = new HashMap<String, Defi>();
        
        for(int i=0; i<tickets.length; i++)
        {
            Defi d = new Defi(tickets[i][0]);
            
            if(world.containsKey(tickets[i][0]))
                continue;
            
            for(int j=0; j<tickets.length; j++)
            {
                if(tickets[i][0].equals(tickets[j][0]))
                    d.setSide(tickets[j][1]);
            }
            //System.out.println("ticket : " + tickets[i][0] + ", side size : " + d.side.size());
            world.put(tickets[i][0], d);
        }
        
        Queue<Defi> relay = new LinkedList<Defi>();
        
        relay.add(world.get("ICN"));
        answerL.add("ICN");
        
        while(!relay.isEmpty())
        {
            Defi de = relay.poll();
            System.out.println(de.isSideEmpty());
            if(!de.isSideEmpty())
            {
                String temp = de.popSide();
                answerL.add(temp);
                
                if(world.containsKey(temp))
                	relay.offer(world.get(temp));
            }
               
        }
        
        String[] answer = new String[answerL.size()];
        
        for(int i=0; i<answerL.size(); i++)
        {
            answer[i] = answerL.get(i);
        }
        
        return answer;
    }
    
}

class Defi
{
    String name;
    PriorityQueue<String> side = new PriorityQueue<String>();
    
    public Defi(String name)
    {
        this.name = name;
    }
    
    public Defi()
    {}
    
    public void setSide(String name)
    {
        side.add(name);
    }
    
    public boolean isSideEmpty()
    {
        if(!side.isEmpty())
            return false;
        else
            return true;
    }
    
    public String popSide()
    {
        if(!side.isEmpty())
            return side.poll();
        else
            return "-1";
    }
}
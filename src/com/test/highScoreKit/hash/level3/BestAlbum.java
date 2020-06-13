package com.test.highScoreKit.hash.level3;

import java.util.*;

/*
 * 테스트명 : 베스트앨범
 * 
 * @KwangHyeon
 * Test 2, 15 통과 못함.
 * 
 * */

class BestAlbum 
{
    public int[] solution(String[] genres, int[] plays) 
    {
        int[] answer = {};

		HashMap<String, Integer> playSum = new HashMap<String, Integer>();
		ArrayList<Integer> gl = new ArrayList<Integer>();
		ArrayList<Integer> temp = null;
		
		ArrayList<String> genreList = new ArrayList<String>();
		ArrayList<Integer> playsList = new ArrayList<Integer>();

		for (int i = 0; i < genres.length; i++)
		{
			if (playSum.containsKey(genres[i]))
				playSum.put(genres[i], playSum.get(genres[i]) + plays[i]);
			else
				playSum.put(genres[i], plays[i]);
		}
		
		for(int i=0; i<plays.length; i++)
		{
			playsList.add(plays[i]);
		}
		
		// plays 자체 내림차순 정렬
		Collections.sort(playsList, Collections.reverseOrder());
		
		// plays 내림차순에 따라 genre 저장
		for(int i=0; i<playsList.size(); i++)
		{
			for(int j=0; j<plays.length; j++)
			{
				if(playsList.get(i)==plays[j])
					genreList.add(genres[j]);
			}
		}

		Iterator<String> it = playSum.keySet().iterator();
		String tempKey = "";
		

		while (it.hasNext())
		{

			tempKey = it.next();
			// 장르 재생순서 정하기용으로 리스트에 담기
			gl.add(playSum.get(tempKey));

		}

		Collections.sort(gl, Collections.reverseOrder());

		ArrayList<String> genrelist = new ArrayList<String>();

		for (int i=0; i<gl.size(); i++)
		{
			it = playSum.keySet().iterator();

			while (it.hasNext())
			{
				tempKey = it.next();
				if (gl.get(i) == playSum.get(tempKey))
				{
					genrelist.add(tempKey);
				}
			}
		}

		ArrayList<Integer> answerlist = new ArrayList<Integer>();
		ArrayList<Integer> answerdepart = new ArrayList<Integer>();
		
		for (int i = 0; i < gl.size(); i++)
		{
			temp = new ArrayList<Integer>();

			for (int j = 0; j < plays.length; j++)
			{
				if (genrelist.get(i).equals(genreList.get(j)))
				{
					temp.add(playsList.get(j));
					System.out.println("욜로 : " + playsList.get(j));
				}
			}

			Collections.sort(temp, Collections.reverseOrder());
			
			if(temp.size()==1)
			{
				answerlist.add(temp.get(0));
				answerdepart.add(i);
			}
			else 
			{
				answerlist.add(temp.get(0));
				answerdepart.add(i);
				answerlist.add(temp.get(1));
				answerdepart.add(i);
			}

		}
		
		HashMap<Integer, String> primary = new HashMap<Integer, String>();
		
		for(int i=0; i<genrelist.size(); i++)
		{
			primary.put(i, genrelist.get(i));
		}

		answer = new int[answerlist.size()];
		
		for (int i = 0; i < answerlist.size(); i++)
		{
			for(int j=0; j<plays.length; j++)
			{
				if(answerlist.get(i)==plays[j] && primary.get(answerdepart.get(i)).equals(genres[j]))
				{
					answer[i] = j;
					System.out.println("답 : " + j);
					break;
				}
				
			}
		}

		return answer;
    }
}
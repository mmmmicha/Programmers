package com.test.highScoreKit.hash.level2;

/*
 * 
 * 테스트 명 : 전화번호목록
 * 
 * @KwangHyeon
 * 
 * */

class CallList 
{
    public boolean solution(String[] phone_book) 
    {
        boolean answer = true;
        
        for(int i=0; i<phone_book.length; i++)
            for(int j=0; j<phone_book.length; j++)
            {
                if(i!=j && phone_book[j].indexOf(phone_book[i])!=-1 && phone_book[j].substring(0,1).equals(phone_book[i].substring(0,1)))
                    return false;
            }
        
        return answer;
    }
}

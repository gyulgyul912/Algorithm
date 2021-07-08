package com.algo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.io.*;

public class BJ1543_문서검색{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text = in.readLine();
        String word = in.readLine();
        int textSize = text.length();
        int wordSize = word.length();
        int cnt = 0;
        for(int i=0;i<=textSize-wordSize;){
            String nowWord = text.substring(i,i+wordSize);
            if(nowWord.equals(word)){
                cnt++;
                i+=wordSize;
            }else{
                i++;
            }
        }
        System.out.println(cnt);
    }
}

package com.example.kuro.syoyuwalk;

/**
 * Created by keinon on 2015/09/24.
 */
public class AnswerList {
    private int[] answers = new int[18];

    /**
     * 問題の番号に答えた番号を入れる
     * @param qId 問題の番号
     * @param answer 問題の答えの番号
     */
    public void setAnswer(int qId,int answer){
        this.answers[qId] = answer;
    }

    /**
     * 問題番号に対する答えた番号を返す
     * @param qId 問題の番号
     * @return 問題の答えた番号 その門ぢアを答えていなかったらnullを返す
     */
    public int getAnswer(int qId){
        return answers[qId];
    }
}

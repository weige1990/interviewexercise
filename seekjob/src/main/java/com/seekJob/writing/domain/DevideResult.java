package com.seekJob.writing.domain;
//每次分词的结果
/**
 * author: cheweiwen
 * date: 2020/02/19
 *
 */
public class DevideResult {


    private String validWord;//合法的单词,builder格式

    private String validSentence;//合法的单词的目前的语句

    private boolean divisible=true;//默认可以再分

    private String remainStr;//剩余的字符数组

    public DevideResult()
    {}


    public DevideResult(String validWord, String validSentence, String remainStr)
    {
        this.validSentence =validSentence;
        this.validWord = validWord;
        this.remainStr =remainStr;
    }


    public void setValidWord(String validWord) {
        this.validWord = validWord;
    }

    public String getRemainStr() {
        return remainStr;
    }

    public void setRemainStr(String remainStr) {
        this.remainStr = remainStr;
    }

    /**
     *
     * @return 返回今次得到的合法的单词的String形式
     */
    public String getValidWord(){
        return validWord.toString();
    }



    public void setValidSentence(String validSentence) {
        this.validSentence = validSentence;
    }

    /**
     *
     * @return 返回今次得到的合法的单词的String形式
     */
    public String getValidSentence() {
        return validSentence;
    }

    public boolean isDivisible() {
        return divisible;
    }

    public void setDivisible(boolean divisible) {
        this.divisible = divisible;
    }

    @Override
    public String toString() {
        return "DevideResult{" +

                " validSentence='" + validSentence + '\'' +
                ", remainStr='" + remainStr + '\'' +

                '}';
    }
}

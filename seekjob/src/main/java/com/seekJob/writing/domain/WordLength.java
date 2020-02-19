package com.seekJob.writing.domain;

import java.util.Map;

//一个首字母的索引对应多个长度的词语
//一个索引的一个长度下对应多个内容不同的词语

/**
 * author: cheweiwen
 * date: 2020/02/19
 *
 */
public class WordLength {


    private Map<String,Word> wordMap;//这个索引底下低词语



    public Map<String, Word> getWordMap() {
        return wordMap;
    }

    public void setWordMap(Map<String, Word> wordMap) {
        this.wordMap = wordMap;
    }

    @Override
    public String toString() {
        return "WordLength{" +
                "wordMap=" + wordMap +
                '}';
    }
}

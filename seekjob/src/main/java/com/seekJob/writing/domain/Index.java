package com.seekJob.writing.domain;

import java.util.Map;

/**
 * 一个索引对应多个长度
 */
/**
 * author: chenweiwen
 * date: 2020/02/19
 *
 */
public class Index {



    private Map<Integer,Map<String,Word>> wordLengthMap;//这个索引底下低词语



    public Map<Integer, Map<String,Word>> getWordLengthMap() {
        return wordLengthMap;
    }

    public void setWordLengthMap(Map<Integer, Map<String,Word>> wordLengthMap) {
        this.wordLengthMap = wordLengthMap;
    }


    @Override
    public String toString() {
        return "Index{" +
                "wordLengthMap=" + wordLengthMap +
                '}';
    }
}

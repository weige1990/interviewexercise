package com.seekJob.writing.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一个词典对应多个索引
 */
/**
 * author: cheweiwen
 * date: 2020/02/19
 *
 */
public class Dictionary {
    private Map<Character,Index> indexMap;//索引


    public Dictionary()
    {

    }
    public Dictionary(String ... contents)
    {
        setContents(contents);
    }
    public Dictionary(List<String> contentList)
    {
        setContents(contentList);
    }


    public void setContents(Collection<String> contentList)
    {
        Map<String, Word> wordMapTemp;
        Map<Integer, Map<String, Word>> wordLengthMapTemp;
        Word wordTemp;
        Index indexTemp;

        indexMap =new HashMap<>(contentList.size());
        for (String content : contentList) {
            wordTemp= new Word(content);
            if(indexMap.get(wordTemp.getFirstChar())==null){
                wordMapTemp = new HashMap<>();
                wordLengthMapTemp=new HashMap<>();
                indexTemp=new Index();
                indexTemp.setWordLengthMap(wordLengthMapTemp);
                wordLengthMapTemp.put(wordTemp.getLength(),wordMapTemp);
                indexMap.put(wordTemp.getFirstChar(),indexTemp);
                wordMapTemp.put(wordTemp.getContent(),wordTemp);
            }
            else {
                indexTemp=indexMap.get(wordTemp.getFirstChar());
                wordLengthMapTemp=indexTemp.getWordLengthMap();
                wordMapTemp=wordLengthMapTemp.get(wordTemp.getLength());
                if(wordMapTemp==null)
                {
                    wordMapTemp=new HashMap<>();
                    wordLengthMapTemp.put(wordTemp.getLength(),wordMapTemp);

                }
                wordMapTemp.put(wordTemp.getContent(),wordTemp);


            }


        }
    }


    public void setContents(String ... contents)
    {
        Map<String, Word> wordMapTemp;
        Map<Integer, Map<String, Word>> wordLengthMapTemp;
        Word wordTemp;
        Index indexTemp;

        indexMap =new HashMap<>(contents.length);
        for (String content : contents) {
            wordTemp= new Word(content);
            if(indexMap.get(wordTemp.getFirstChar())==null){
                wordMapTemp = new HashMap<>();
                wordLengthMapTemp=new HashMap<>();
                indexTemp=new Index();
                indexTemp.setWordLengthMap(wordLengthMapTemp);
                wordLengthMapTemp.put(wordTemp.getLength(),wordMapTemp);
                indexMap.put(wordTemp.getFirstChar(),indexTemp);
                wordMapTemp.put(wordTemp.getContent(),wordTemp);
            }
            else {
                indexTemp=indexMap.get(wordTemp.getFirstChar());
                wordLengthMapTemp=indexTemp.getWordLengthMap();
                wordMapTemp=wordLengthMapTemp.get(wordTemp.getLength());
                if(wordMapTemp==null)
                {
                    wordMapTemp=new HashMap<>();
                    wordLengthMapTemp.put(wordTemp.getLength(),wordMapTemp);

                }
                wordMapTemp.put(wordTemp.getContent(),wordTemp);


            }


        }
    }

    public Map<Character,Index> getIndexMap() {
        return indexMap;
    }

    public void setIndexMap(Map<Character,Index> indexMap) {
        this.indexMap = indexMap;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "indexMap=" + indexMap +
                '}';
    }
}

package com.seekJob.writing.service.impl;

import com.seekJob.writing.domain.DevideResult;
import com.seekJob.writing.domain.Dictionary;
import com.seekJob.writing.domain.Index;
import com.seekJob.writing.domain.Word;
import com.seekJob.writing.service.WritingService;

import java.util.*;
/**
 * author: cheweiwen
 * date: 2020/02/19
 *
 */
public class WritingServiceImpl implements WritingService {
    @Override
    public List<DevideResult> breakSentenceWithConfirmedDictonary(String srcSentence) {

        String[] words={"i","like","sam","sung","samsung","mobile","ice","cream","man","go"};
       return breakSentenceWithUserProvidedDictonary(srcSentence,words);
    }

    private List<DevideResult> oneDevideResultToManyDevideResult(DevideResult devideResult,Dictionary dictonary)
    {
        List<DevideResult> nowResult=new LinkedList<>();
        String remainStrTemp=devideResult.getRemainStr();

        String validSentence=devideResult.getValidSentence();
        int startIndexNum=0;
        char fistChar = remainStrTemp.charAt(startIndexNum);
        Map<Character, Index> indexMap = dictonary.getIndexMap();
                if(indexMap.get(fistChar)==null)
                {
                    devideResult.setDivisible(false);
                    nowResult.add(devideResult);
                    return nowResult;
                }
        Map<Integer, Map<String, Word>> wordLengthMap = indexMap.
                get(fistChar).
                getWordLengthMap();

        for (Integer wordLength : wordLengthMap.keySet()) {
            if(startIndexNum+wordLength<=remainStrTemp.length())
            {
                Map<String, Word> wordMap = wordLengthMap.get(wordLength);
                String targetStr = remainStrTemp.substring(startIndexNum, startIndexNum+wordLength);
                if(wordMap.get(targetStr)!=null)
                {
                    nowResult.add(new DevideResult(targetStr,validSentence+" "+targetStr
                            ,remainStrTemp.substring(startIndexNum+wordLength,remainStrTemp.length())));

                }
            }
            else {
                continue;
            }
        }


    return nowResult;
    }


    @Override
    public List<DevideResult> breakSentenceWithUserProvidedDictonary(String srcSentence, String... words) {

        //1输入词语,生成词典,生成索引,生成单词
        Dictionary dictionary = new Dictionary(words);
//        System.out.println(dictonary);
        //2长字符串,得出字符数组(必须建立在句子是合法的基础上,以下操作才有意义)

        // 2.1字符串按照首字母分词 ,
        // 先检索第一个字符,
        // 从长度为1至字符串末尾叠加字符串,每叠加一个字符串就去索引那里找出对应的单词有就加入结果集
        // 在字典在找到对应的索引,
        //
        final  int strlength=srcSentence.length();
        char[] chars=srcSentence.toCharArray();
        int point=0;
        StringBuilder strTemp;


        // 按照最小长度,
        // 在找到索引的长度下面的词逐个对
        List<DevideResult> finalResults=null;
        List<DevideResult> resultsTemp=null;
        List<DevideResult> newResults=new LinkedList<>();
        newResults.add(new DevideResult("","",srcSentence));
        while(newResults.size()>0)
        {
            finalResults=newResults;
            resultsTemp=new LinkedList<>();
            int round=0;
            for (DevideResult newResult : newResults) {

                if(newResult.getRemainStr().length()>0)
                {

                    resultsTemp.addAll(oneDevideResultToManyDevideResult(newResult,dictionary));
                }else
                {
                    round++;
                    resultsTemp.add(newResult);
                }
            }
            if(round==newResults.size())
            {
                return resultsTemp;

            }
            newResults=resultsTemp;

        }
        return finalResults;
    }

    @Override
    public List<DevideResult> breakSentenceWithBothDictonaries(String srcSentence, String... words)
    {
        String[] confirmedWords={"i","like","sam","sung","samsung","mobile","ice","cream","man","go","blue"};
        Set<String> wordFilterSet=new HashSet<>();//1两个数组进行去重
        //2生成新的词典
        for (String word : words) {
            wordFilterSet.add(word);
        }
        for (String confirmedWord : confirmedWords) {
            wordFilterSet.add(confirmedWord);
        }
        return breakSentenceWithUserProvidedDictonary(srcSentence,wordFilterSet.toArray(words));
    }


    public static void main(String[] args) {
        System.out.println("ilikesamsungmobile".substring(0,1)+":这就是结果");
        System.out.println("ilikesamsungmobile".length()+":这就是结果");//18
        System.out.println("ilikesamsungmobile".substring(1,18)+":这就是结果");
    }
}

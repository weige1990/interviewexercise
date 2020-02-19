package com.seekJob.writing.service;

import com.seekJob.writing.domain.DevideResult;

import java.util.List;
/**
 * author: cheweiwen
 * date: 2020/02/19
 *
 */
public interface WritingService {

    /**
     * 输入句子根据固定的词典进行分词,实现的是第1个需求
     * @param srcSentence
     * @return
     */
    List<DevideResult> breakSentenceWithConfirmedDictonary(String srcSentence);

    /**
     * 输入句子根据用户给的词典进行分词,实现的是第2个需求
     * @param srcSentence
     * @param dictionary
     * @return
     */
    List<DevideResult> breakSentenceWithUserProvidedDictonary(String srcSentence,String ... dictionary);

    /**
     * 输入句子根据用户给的词典和给的固定的词典的词总和进行分词,实现的是第3个需求
     * @param srcSentence
     * @param dictionary
     * @return
     */
    List<DevideResult> breakSentenceWithBothDictonaries(String srcSentence,String ... dictionary);

}

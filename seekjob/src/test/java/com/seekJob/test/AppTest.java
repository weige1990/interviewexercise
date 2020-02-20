package com.seekJob.test;

import static org.junit.Assert.assertTrue;

import com.seekJob.writing.domain.DevideResult;
import com.seekJob.writing.service.impl.WritingServiceImpl;
import org.junit.Test;

import java.util.List;


public class AppTest 
{
    /**
     * 测试需求1
     */
    @Test
    public void testBreakSentenceWithConfirmedDictonary1()
    {

       List<DevideResult> resultList= new WritingServiceImpl
                ().breakSentenceWithConfirmedDictionary("ilikesamsungmobilemango");
        for (DevideResult devideResult : resultList) {

        System.out.println(  devideResult.getValidSentence() );
        }

    }

    /**
     * 测试需求1
     */
    @Test
    public void testBreakSentenceWithConfirmedDictonary2()
    {

        List<DevideResult> resultList= new WritingServiceImpl
                ().breakSentenceWithConfirmedDictionary("ilikeicecreammango1");
        for (DevideResult devideResult : resultList) {

            System.out.println(  devideResult.getValidSentence() );
        }

    }
    /**
     * 测试需求2
     */
    @Test
    public void testBreakSentenceWithUserProvidedDictonary()
    {


        List<DevideResult> resultList= new WritingServiceImpl
                ().breakSentenceWithUserProvidedDictionary("ilikesamsungmobile","i","like","sam","sung"
                ,"mobile","ice","cream","man","go");
        for (DevideResult devideResult : resultList) {

            System.out.println(  devideResult.getValidSentence() );
        }
    }


    /**
     * 测试需求3
     */
    @Test
    public void testBreakSentenceWithBothDictonaries()
    {


        List<DevideResult> resultList= new WritingServiceImpl
                ().breakSentenceWithBothDictionaries("ilikesamsungmobileblueyellow","i","like","sam","sung"
                ,"mobile","ice","cream","man","go","yellow");
        for (DevideResult devideResult : resultList) {

            System.out.println(  devideResult.getValidSentence() );
        }
    }
}

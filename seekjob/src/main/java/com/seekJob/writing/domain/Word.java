package com.seekJob.writing.domain;

/**
 * 单词
 */

/**
 * author: chenweiwen
 * date: 2020/02/19
 *
 */
public class Word {


    private String content;
    private Character firstChar;
    private int length;


    public Word()
    {

    }

    public Word(String content)
    {
    setContent(content);
    setFirstChar(content.charAt(0));
    setLength(content.length());

    }

    public Character getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(Character firstChar) {
        this.firstChar = firstChar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Word{" +
                "content='" + content + '\'' +
                ", firstChar=" + firstChar +
                ", length=" + length +
                '}';
    }
}

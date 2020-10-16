package com.cl.leetcode.arithmetic.simple.string;

import com.cl.dataStructures.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {
    public static void main(String[] args) {
        //todo
        String[] list = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            wordList.add(list[i]);
        }
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (wordList.indexOf(endWord) == -1)
            return 0;


        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (word.equals(endWord)) {
                return 1;
            }
            int num = 0;
            for (int j = 0; j < beginWord.length(); j++) {
                if (word.indexOf(beginWord.charAt(j)) != -1) {
                    num++;
                }
            }
            if (num == beginWord.length() - 1) {
                List<String> next = new ArrayList<>();
                next.addAll(wordList);
                next.remove(i);
                int index = ladderLength(word, endWord, next);
                if (index != 0) {
                    return index + 1;
                }
            }
        }
        return 0;
    }

    public static int test(String beginWord, String word) {
        int num = 0;
        for (int j = 0; j < beginWord.length(); j++) {
            if (word.indexOf(beginWord.charAt(j)) != -1) {
                num++;
            }
        }
        return num;
    }
}

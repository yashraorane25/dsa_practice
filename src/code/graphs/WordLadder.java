package code.graphs;

import java.util.*;

public class WordLadder {

    static class Pair {
        String first;
        int second;

        Pair(String _first, int _second) {
            first = _first;
            second = _second;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wordLadder = new WordLadder();
        int maxSequence = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("The ladder length is: " + maxSequence);

    }

    //TC: O(N *  wordlen * 26* log N)
    // SC: O(N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();
        int length = wordList.size();
        for (int i = 0; i < length; i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if (word.equals(endWord)) return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    //check if it exits in the set
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

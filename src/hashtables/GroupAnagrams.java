package hashtables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> list = ga.groupAnagrams(strs);
        System.out.println(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hs = new HashMap<>();
        for (String word : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                freq[word.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(freq);
            hs.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(hs.values());
    }
}

package bucket_sort;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        TopKFrequentWords frequentWords = new TopKFrequentWords();
        List<String> fqWords = frequentWords.topKFrequent(words, k);
        System.out.println(fqWords);
    }


    //brute force - using custom comparator
   /* public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList<>(freq.keySet());
        candidates.sort((a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return a.compareTo(b);
            }
            return freq.get(b) - freq.get(a);
        });

        return candidates.subList(0, k);
    }*/

    //beter appraoch using map and min heap
   /* public List<String> topKFrequent(String[] words, int k) {
        //Count frequencies
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }
            return freq.get(a) - freq.get(b);

        });
        //keep only the k in the heap
        for (String word : freq.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // extract and reverse
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;

    }*/

    //optimal apprach using map and buckets
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        //create buckets
        List<String>[] buckets = new List[words.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        for (List<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        List<String> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            for (String word : buckets[i]) {
                result.add(word);
                if (result.size() == k) return result;
            }
        }
        return result;
    }
}

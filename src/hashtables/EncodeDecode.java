package hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecode {
    Map<String, String> code2url = new HashMap<>();
    Map<String, String> url2code = new HashMap<>();
    private static final String PREFIX = "http://tinyurl.com/";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();

    public static void main(String[] args) {
        EncodeDecode ed = new EncodeDecode();
        String longUrl = "https://leetcode.com/probles/design-tinryurl";
        String encoded = ed.encode(longUrl);
        String decoded = ed.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(String longUrl) {
        if (url2code.containsKey(longUrl)) {
            return PREFIX + url2code.get(longUrl);
        }
        String key = generateKey();
        while (code2url.containsKey(key)) {
            key = generateKey();
        }
        code2url.put(key, longUrl);
        url2code.put(longUrl, key);
        return PREFIX + key;
    }

    public String decode(String shortUrl) {
        String key = shortUrl.replace(PREFIX, "");
        return code2url.get(key);
    }

    private String generateKey() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));

        }
        return sb.toString();
    }
}

public class Codec {
    Map<String, String> lToS = new HashMap<>();
    Map<String, String> sToL = new HashMap<>();
    static String HOST = "http://tinyurl.com/";
    public String encode(String longUrl) {
        if (lToS.containsKey(longUrl)) {
            return HOST + lToS.get(longUrl);
        }
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = (int)(Math.random() * charSet.length());
                sb.append(charSet.charAt(index));
            }
            key = sb.toString();
        } while (sToL.containsKey(key)); // regenerate key if there is duplicate
        lToS.put(longUrl, key);
        sToL.put(key, longUrl);
        return HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String tiny = shortUrl.replace(HOST, "");
        return sToL.get(tiny);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

import java.util.HashMap;

public class InterleavedString {
    private static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        //System.out.println(interleavePossible("aaaabbbbb"));
        System.out.println(transform("aaaabbbbb"));
    }

    private static String transform(String input) {
        if (!interleavePossible(input)) return null;

        char[] charArray = new char[input.length()];
        int max = 0;
        char maxChar = input.charAt(0);
        for (Character k : map.keySet()) {
            int f = map.get(k);
            if (max < f) {
                max = f;
                maxChar = k;
            }
        }
        int i = 0;
        for (; i < max * 2; i = i + 2) {
            charArray[i] = maxChar;
        }
        map.remove(maxChar);

        while (i < input.length() && map.size() > 0) {
            char ch = (char)map.keySet().toArray()[0];
            charArray[i] = ch;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                map.remove(ch);
        }

        for (i =1 ; i < input.length() && map.size() > 0; i+=2) {
            char ch = (char)map.keySet().toArray()[0];
            charArray[i] = ch;
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0)
                map.remove(ch);
        }

        return new String(charArray);


    }

    private static boolean interleavePossible(String input) {
        if (input == null || input.length() < 1)
            return true;

        //
        for (char c : input.toCharArray()) {
            int freq = 0;
            if (!map.containsKey(c)) {
                freq = 1;
                map.put(c, freq);
            } else {
                freq = map.get(c);
                map.put(c, freq + 1);
            }
            if (freq > Math.ceil(input.length() / 2))
                return false;
        }

        System.out.println(map.toString());

        return true;
    }



}

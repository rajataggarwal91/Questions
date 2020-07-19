import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private static int CACHE_SIZE = 10;
    private static Map<Integer, Integer> cacheMap = new HashMap<>();
    private static Deque<Integer> cacheQueue = new LinkedList<>();
    public static void main(String args[]) {
        for (int i = 0 ; i < 20 ; i++) {
            insert(i, i + 1);
            System.out.println(cacheQueue.toString());
        }
        System.out.println(get(15));
        System.out.println(cacheQueue.toString());
        System.out.println(get(18));
        System.out.println(cacheQueue.toString());
    }

    public static void insert(Integer key, Integer value) {
        if (cacheMap.containsKey(key)) {
            cacheQueue.remove(key);
        }
        cacheQueue.offerFirst(key);
        if (cacheQueue.size() > CACHE_SIZE) {
            cacheMap.remove(cacheQueue.removeLast());
        }
        cacheMap.put(key, value);
    }

    public static Integer get(Integer key) {
        if (cacheMap.containsKey(key)) {
            cacheQueue.remove(key);
            cacheQueue.offerFirst(key);
            return cacheMap.get(key);
        }
        return null;
    }

}

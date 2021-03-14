package everyday;

import AlgorithmIdea.math.Base7;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 *
 * @author Ernest
 * @version 1.0, 13/3/2021
 * @since 1.0.0
 */
public class MyHashSet {

    private static final int BASE = 769;
    private LinkedList<Integer>[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer e = iterator.next();
            if (e == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer e = iterator.next();
            if (e == key) {
                data[h].remove(e);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer e = iterator.next();
            if (key == e) {
                return true;
            }
        }
        return false;
    }
}

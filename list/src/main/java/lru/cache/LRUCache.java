package lru.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cacheMap = new HashMap<>();
    private class Node {
        int key;
        Node next, prev;
        Node(int key) {
            this.key = key;
        }
    }
    private class DoubleList {
        Node front, rear;
        int size;
        void add(int key) {
            Node temp = new Node(key);
            if(front == null && rear == null) {
                front = temp;
                rear = temp;
            } else {
                front.prev = temp;
                temp.next = front;
                temp.prev = null;
                front = temp;
            }
            size++;
        }

        Node evict() {
            Node leastRecentlyUsed = rear;
            Node prev = rear.prev;
            prev.next = null;
            rear.prev = null;
            rear = prev;
            size--;
            return leastRecentlyUsed;
        }

        void shiftOnAccess(int key) {
            if(front.key != key) {
                Node current = front.next;
                while(current != null) {
                    if(current.key == key) {
                        if(current.key == rear.key) {
                            Node prev = current.prev;
                            prev.next = null;
                            current.prev = null;
                            rear = prev;
                        }else {
                            current.next.prev = current.prev;
                            current.prev.next = current.next;
                        }
                        front.prev = current;
                        current.next = front;
                        front = current;
                        break;
                    }
                    current = current.next;
                }
            }
        }

        List<Integer> traverse() {
            Node current = front;
            var resultList = new ArrayList<Integer>();
            while(current != null) {
                resultList.add(current.key);
                current = current.next;
            }
            return resultList;
        }

    }

    private final DoubleList nodeShifter;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeShifter = new DoubleList();
    }

    public int get(int key) {
        int returnVal = -1;
        if(cacheMap.containsKey(key)) {
            returnVal = cacheMap.get(key);
            nodeShifter.shiftOnAccess(key);
        }
        return returnVal;
    }

    public void add(int key, int val) {
        if(nodeShifter.size >= capacity) {
            Node evicted = nodeShifter.evict();
            var value = cacheMap.remove(evicted.key);
            System.out.println("Cache Reached Capacity...Evicting the least recently used entry");
            System.out.println("evicted (key,val): ("+evicted.key+","+value+")");
        }
        nodeShifter.add(key);
        cacheMap.put(key, val);
    }

    public void showCacheInOrder() {
        var keys = nodeShifter.traverse();
        keys.forEach(k-> System.out.println("key="+k+", value="+cacheMap.get(k)));
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.add(1,10);
        cache.add(2,20);
        cache.add(3,30);
        cache.add(4,40);
        cache.add(5,50);
        cache.showCacheInOrder();
        cache.add(6, 60);
        cache.get(2);
        cache.showCacheInOrder();
    }

}

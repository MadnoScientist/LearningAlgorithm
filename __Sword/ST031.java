import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 031 - LRU (Least recently used) cache
 * 运用所掌握的数据结构，设计和实现一个 LRU (Least Recently Used，最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *      LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 *      int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *      void put(int key, int value)如果关键字已经存在，则变更其数据值；
 *      如果关键字不存在，则插入该组「关键字-值」。
 *      当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */

public class ST031 {
    class LRUCache {
        class DLinkNode {
            int key;
            int value;
            DLinkNode prev;
            DLinkNode next;
            public DLinkNode() {}
            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private int capacity;
        private int size;
        private Map<Integer, DLinkNode> cache = new HashMap<>();
        private DLinkNode head, tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                DLinkNode newNode = new DLinkNode(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }
        private void addToHead(DLinkNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        private DLinkNode removeTail() {
            DLinkNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private void moveToHead(DLinkNode node) {
            removeNode(node);
            addToHead(node);
        }
    }
}


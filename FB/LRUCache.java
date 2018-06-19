class LRUCache {
    private class Node {
        int key;
        int val;
        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }

        Node() {
           this(-1, -1);
        }
    }
    private int capacity;
    private Map<Integer, Node> hash;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new HashMap<Integer, Node>();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }
        Node node = hash.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        toTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            hash.get(key).val = value;
        } else {
            if (hash.size() == capacity) {
                hash.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
            Node newNode = new Node(key, value);
            hash.put(key, newNode);
            toTail(newNode);
        }
    }

    private void toTail(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

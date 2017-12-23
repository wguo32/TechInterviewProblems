class LRUCache {
    private class Node {
      int val;
      int key;
      Node pre;
      Node next;
      Node(int key, int value) {
        this.key = key;
        this.val = value;
        this.pre = null;
        this.next = null;
      }
      Node() {
        this(-1, -1);
      }
    }

    private int capacity;
    private Map<Integer, Node> hash;
    private Node head = new Node();
    private Node tail = new Node();

    public LRUCache(int capacity) {
      this.capacity = capacity;
      head.next = tail;
      tail.pre = head;
      hash = new HashMap<Integer, Node>();
    }

    public int get(int key) {
      if (!hash.containsKey(key)) {
        return -1;
      }
      Node node = hash.get(key);
      node.pre.next = node.next;
      node.next.pre = node.pre;
      moveToTail(node);
      return node.val;
    }

    public void put(int key, int value) {
      if (get(key) != -1) {
        hash.get(key).val = value;
        return;
      }

      if (hash.size() == capacity) {
        hash.remove(head.next.key);
        head.next = head.next.next;
        head.next.pre = head;
      }
      Node newNode = new Node(key, value);
      hash.put(key, newNode);
      moveToTail(newNode);
    }

    private void moveToTail(Node node) {
      node.pre = tail.pre;
      node.next = tail;
      node.pre.next = node;
      tail.pre = node;
    }
}

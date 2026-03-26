class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> mp;
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //map contains
        if(mp.containsKey(key) == true){
            //1. get value;
            //2. update node to front 
            Node node = mp.get(key);
            int ans = node.value;

            remove(node);
            insertAtFront(node); 
        return ans;   
        }else return -1;

    }
    
    public void put(int key, int value) {
        //if(map contains already)
            if(mp.containsKey(key) == true){
                //update and insert at front
                Node node = mp.get(key);
                node.value = value;
                remove(node);
                insertAtFront(node);

            }
        //if map donot contains 
            //1. mp full
            //2. mp.has space
            else{
                if(mp.size() == capacity){
                    Node lru = tail.prev;
                    remove(lru);
                    mp.remove(lru.key);
                }
                Node newNode = new Node(key, value);
                insertAtFront(newNode);
                mp.put(key, newNode);
            }
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
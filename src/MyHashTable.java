public class MyHashTable<K, V> {
    private class HashNode <K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private static int M = 11;
    private int size;
    public MyHashTable() {
        this(M);
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        int res = 0;
        String keyString = key.toString();
        for (int i = 0; i < keyString.length(); i++) {
            res += keyString.charAt(i);
        }
        return res % M;
    }
    public void put(K key, V value) {
        int ind = hash(key);
        HashNode<K,V> newNode = new HashNode<>(key, value);
        if(chainArray[ind] == null) {
            chainArray[ind] = newNode;
        } else {
            HashNode<K,V> cur = chainArray[ind];
            while(cur.next != null) {
                if(cur.key.equals(key)) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            cur.next = newNode;
        }
        size++;
    }
    public V get(K key) {
        int ind = hash(key);
        HashNode<K,V> current = chainArray[ind];
        while (current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public V remove(K key) {
        int ind = hash(key);
        HashNode<K,V> cur = chainArray[ind];
        HashNode<K,V> prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) {
                    chainArray[ind] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }

        return null;
    }

    public boolean contains(V value) {
        for(HashNode<K,V> node: chainArray) {
            if(node.value.equals(value)) {
                return true;
            }
        }
        return false;
    }
    public K getKey(V value) {
        for(HashNode<K,V> node: chainArray) {
            if(node.value.equals(value)) {
                return node.key;
            }
        }
        return null;
    }
}


package org.example;

import javax.swing.tree.TreeNode;
import java.util.*;

public class MyHashMap<K, V> implements Map<K,V> {

    //Default Shared empty table, when first elemnt added tab
    private final Object[] EMPTY_TABLE = {}; //0 to capcity
    private final Object[] TABLE_WITH_DEFAULT_CAPACITY = {}; //0 to capcity
    private final Object[] hashTable;

    private transient float loadFacotor;
    private int size = 0;

    class Node<K,V> {
        int hash;
        K key;
        V value;
        Node<K,V> next;
        Node(K key, V value, int hash)  {
            key = key;
            value = value;
            this.hash = hash;
        }
    }
    public MyHashMap() {
        hashTable = EMPTY_TABLE;
        loadFacotor = 0.75f;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    //TODO
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V get(Object key) {
        Node<K,V> node = getNode((K)key);
        return  node == null ? null : node.value;
    }
    Node<K,V> getNode(K key) {
        //  0     1     2      3     4    5          15  table.length -1
        //
        // 111000000000 111000000 1100000000 1100000
        // 000000000000 000000000 0000000001 11111111
        // 0000000000000000000000 11 00000000 00 0000
        Object object = hashTable[hash(key) & hashTable.length - 1];
        if(object == null) {
            return null;
        }
        Node first  = (Node) object;
        if(first.key == key) {
            return first;
        }
        if(object instanceof TreeNode treeNode) {
            //TODO
        }
        Node tmp = first;
        do {
            if(tmp.hash == hash(key) && tmp.equals(key)) {
                return tmp;
            }
            tmp = tmp.next;

        }while (tmp != null);
        return null;
    }
    int hash(Object key) {
        //111111111 00000000  1111111 0000000
        //2, 3, 4,5 ,6 => same higher bits different lower bits
        //
        //effective distribution, effective computation, effective memory usage
        if(key == null) {
            return  0;
        }
        int h = keySet().hashCode();
        int hash = (h) ^ (h >>> 16);
        return hash;
    }

    @Override
    //TODO
    public V put(K key, V value) {
        if(size + 1 > loadFacotor * hashTable.length) {
            int preferredCapcity = hashTable.length << 1;
            int minCapacity =  size + 1;
            grow(minCapacity, preferredCapcity);
        }
        putNode(new Node(key, value, hash(key)));
        return value;

    }

    private void grow(int minCapacity, int prefereedCapacity) {
        int newCapcity = Math.max(minCapacity, prefereedCapacity);
        Object[] newTable = new Object[newCapcity];
        for (int i = 0; i < hashTable.length; i++) {
            Object bin = hashTable[i];

        }

    }

    public void putNode(Node node) {
        Object bin = hashTable[node.hash & hashTable.length - 1];
        if(bin == null) {
            hashTable[node.hash & hashTable.length - 1] = node;
            return;
        }
        if(bin instanceof  TreeNode) {

        }
        Node first = (Node) bin;
        Node tmp = first;
        Node prev = null;
        do {
            if(tmp.hash == node.hash && tmp.key.equals(node.key)) {
                tmp.value = node.value;
                return;
            }
            prev = tmp;
            tmp = tmp.next;
        }while(tmp != null);
        assert prev != null;
        prev.next = node;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}

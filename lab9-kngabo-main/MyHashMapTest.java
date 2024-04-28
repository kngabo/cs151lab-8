import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void testPut(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        Integer key = hashMap.put("kelig",20);
        Integer sameKey = hashMap.put("kelig", 15);
        
        // assertEquals(1, hashMap.size());
        assertNull(key);
        Integer expected = 20;
        assertEquals(expected, sameKey);
    }

    @Test
    public void testGet(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("Kelig", 1);
        hashMap.put("Jikel", 2);
        hashMap.put("Lior", 3);
        hashMap.put("Elio", 4);
        Integer birthday = hashMap.put("Lior", 25);

        Integer expected1 = 1;
        Integer expected2 = 3;

        assertEquals(expected1, hashMap.get("Kelig"));
        assertEquals(expected2, birthday);
        assertNull(hashMap.get("Alice"));
    }

    @Test
    public void testRemove(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("Kelig", 1);
        hashMap.put("Jikel", 2);
        assertEquals(2, hashMap.size());
        Integer removed = hashMap.remove("Kelig");
        assertEquals(1, hashMap.size());
        Integer expected = 1;
        assertEquals(expected, removed);
    }

    @Test
    public void testContains(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("Kelig", 1);
        hashMap.put("Jikel", 2);

        assertTrue(hashMap.containsKey("Kelig"));
        assertFalse(hashMap.containsKey("none"));
        assertTrue(hashMap.containsValue(2));
        assertFalse(hashMap.containsValue(3));
    }

    @Test
    public void testEntrySet(){
        MyHashMap<String, Integer> hashMap = new MyHashMap<String, Integer>();
        hashMap.put("Kelig", 1);
        hashMap.put("Jikel", 2);

        assertEquals(hashMap.size(), hashMap.entrySet().size());
            
    }
}

package tutorial.lib.fastutil.ints;


import it.unimi.dsi.fastutil.ints.Int2IntRBTreeMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Int2IntRBTreeMapTest
{
    @SuppressWarnings("deprecation")
    @Test
    public void testContainsNull()
    {
        Int2IntRBTreeMap m = new Int2IntRBTreeMap(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertFalse(m.containsKey(null));
        assertTrue(m.get(null) == null);
    }

    @SuppressWarnings("boxing")
    @Test
    public void testEquals()
    {
        Int2IntRBTreeMap m = new Int2IntRBTreeMap(new int[]{1, 2}, new int[]{1, 2});
        assertFalse(m.equals(new Object2ObjectOpenHashMap<Integer, Integer>(new Integer[]{1, null}, new Integer[]{1, 1})));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void entrySetContainsTest()
    {
        Int2IntRBTreeMap m = new Int2IntRBTreeMap();
        m.put(0, 0);
        assertFalse(m.int2IntEntrySet().contains(new AbstractMap.SimpleEntry(new Object(), null)));
        assertFalse(m.entrySet().contains(new AbstractMap.SimpleEntry(null, new Object())));
        assertFalse(m.entrySet().contains(new AbstractMap.SimpleEntry(null, null)));
        assertFalse(m.entrySet().contains(new AbstractMap.SimpleEntry(new Object(), new Object())));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    public void entrySetRemoveTest()
    {
        Int2IntRBTreeMap m = new Int2IntRBTreeMap();
        m.put(0, 0);
        assertFalse(m.entrySet().remove(new AbstractMap.SimpleEntry(new Object(), null)));
        assertFalse(m.entrySet().remove(new AbstractMap.SimpleEntry(null, new Object())));
        assertFalse(m.entrySet().remove(new AbstractMap.SimpleEntry(null, null)));
        assertFalse(m.entrySet().remove(new AbstractMap.SimpleEntry(new Object(), new Object())));
    }

    @Test
    public void removeFromKeySetTest()
    {
        Int2IntRBTreeMap m = new Int2IntRBTreeMap();
        m.put(0, 0);
        assertTrue(m.keySet().remove(0));
    }
}

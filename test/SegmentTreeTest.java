import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentTreeTest {

    @org.junit.Before
    public void setUp() {
    }

    @org.junit.After
    public void tearDown() {
    }

    @Test
    public void testCeilLogBase2Case1() {
        assertEquals(0, SegmentTree.ceilLogBase(1, 2));
    }

    @Test
    public void testCeilLogBase2Case2() {
        assertEquals(1, SegmentTree.ceilLogBase(2, 2));
    }

    @Test
    public void testCeilLogBase2Case3() {
        assertEquals(3, SegmentTree.ceilLogBase(5, 2));
    }

    @Test
    public void testCeilLogBase2Case4() {
        assertEquals(3, SegmentTree.ceilLogBase(8, 2));
    }

    @Test
    public void testCeilLogBase2Case5() {
        assertEquals(4, SegmentTree.ceilLogBase(16, 2));
    }

    @Test
    public void testCeilLogBase2Case6() {
        assertEquals(5, SegmentTree.ceilLogBase(30, 2));
    }

    @Test
    public void testCeilLogBase3Case1() {
        assertEquals(0, SegmentTree.ceilLogBase(1, 3));
    }

    @Test
    public void testCeilLogBase3Case2() {
        assertEquals(1, SegmentTree.ceilLogBase(2, 3));
    }

    @Test
    public void testCeilLogBase3Case3() {
        assertEquals(2, SegmentTree.ceilLogBase(5, 3));
    }

    @Test
    public void testCeilLogBase3Case4() {
        assertEquals(2, SegmentTree.ceilLogBase(9, 3));
    }

    @Test
    public void testCeilLogBase3Case5() {
        assertEquals(3, SegmentTree.ceilLogBase(16, 3));
    }

    @Test
    public void testCeilLogBase3Case6() {
        assertEquals(4, SegmentTree.ceilLogBase(30, 3));
    }

    @Test
    public void testSegmentTreeSizeCase1() {
        assertEquals(1, SegmentTree.computeSegTreeSize(1));
    }

    @Test
    public void testSegmentTreeSizeCase2() {
        assertEquals(3, SegmentTree.computeSegTreeSize(2));
    }

    @Test
    public void testSegmentTreeSizeCase3() {
        assertEquals(7, SegmentTree.computeSegTreeSize(4));
    }

    @Test
    public void testSegmentTreeSizeCase4() {
        assertEquals(15, SegmentTree.computeSegTreeSize(6));
    }

    @Test
    public void testSegmentTreeSizeCase5() {
        assertEquals(63, SegmentTree.computeSegTreeSize(31));
    }

    @Test
    public void testPower() {
        assertEquals(9, SegmentTree.power(3, 2));
    }

    @Test
    public void testSegmentTreeCaseMax() {
        SegmentTree<Integer> segTree = new SegmentTree<>(new Integer[]{1, 2, 3, 4});
        segTree.buildSegmentTree(Integer::max);
        assertEquals("4 2 4 1 2 3 4 ", segTree.printTree());
    }

    @Test
    public void testSegmentTreeCaseSum() {
        SegmentTree<Integer> segTree = new SegmentTree<>(new Integer[]{1, 3, 5, 7, 9, 11});
        segTree.buildSegmentTree(Integer::sum);
        assertEquals("36 9 27 4 5 16 11 1 3 7 9 ", segTree.printTree());
    }

    @Test
    public void testSegmentTreeCaseLongestString() {
        SegmentTree<String> segTree = new SegmentTree<>(new String[]{"aa", "a", "aaa", "aa", "aaaa", "a"});
        segTree.buildSegmentTree((s1, s2) -> s1.length() > s2.length() ? s1 : s2);
        assertEquals("aaaa aaa aaaa aa aaa aaaa a aa a aa aaaa ", segTree.printTree());
    }

    @Test
    public void testSegmentTreeCaseMultipleOperationOnSameInput() {
        SegmentTree<Integer> segTree = new SegmentTree<>(new Integer[]{1, 2, 3, 4});
        segTree.buildSegmentTree(Integer::max);
        assertEquals("4 2 4 1 2 3 4 ", segTree.printTree());
        segTree.buildSegmentTree(Integer::sum);
        assertEquals("10 3 7 1 2 3 4 ", segTree.printTree());
    }

    @Test
    public void testSegmentTreeWithMergerFunctionCaseSum() {
        SegmentTree<Integer> segTree = new SegmentTree<>(new Integer[]{1, 3, 5, 7, 9, 11}, Integer::sum);
        assertEquals("36 9 27 4 5 16 11 1 3 7 9 ", segTree.printTree());
    }

}
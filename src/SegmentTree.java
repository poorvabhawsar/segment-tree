import java.util.Arrays;
import java.util.function.BiFunction;

public class SegmentTree<T> {

    private final T[] inputArray;
    private final int segmentTreeSize;
    private SegmentTreeNode[] segmentTree;

    SegmentTree(T[] input) {
        inputArray = Arrays.copyOf(input, input.length);
        segmentTreeSize = computeSegTreeSize(inputArray.length);
    }

    SegmentTree(T[] input, BiFunction<T, T, T> mergerFunction) {
        this(input);
        buildSegmentTree(mergerFunction);
    }

    protected static int computeSegTreeSize(int length) {
        final int height = ceilLogBase(length, 2);
        final int maxLeafNodes = power(2, height);
        return (2 * maxLeafNodes) - 1;
    }

    protected static int ceilLogBase(int n, int base) {
        int pow = 0;
        int multiple = 1;
        while (multiple < n) {
            multiple *= base;
            pow++;
        }
        return pow;
    }

    protected static int power(int n, int pow) {
        return (int) Math.pow(n, pow);
    }

    public void buildSegmentTree(BiFunction<T, T, T> mergerFunction) {
        initTree();
        int arraySize = inputArray.length;
        buildSegmentTree(0, 0, arraySize - 1, mergerFunction);
    }

    private void initTree() {
        segmentTree = new SegmentTreeNode[segmentTreeSize];
    }

    private SegmentTreeNode<T> buildSegmentTree(int pos, int start, int end, BiFunction<T, T, T> mergerFunction) {
        if (start == end) {
            final SegmentTreeNode<T> treeNode = new SegmentTreeNode<>(inputArray[start]);
            segmentTree[pos] = treeNode;
            return treeNode;
        }
        int leftMid = (start + end) / 2;
        final SegmentTreeNode<T> left = buildSegmentTree((pos * 2) + 1, start, leftMid, mergerFunction);
        final SegmentTreeNode<T> right = buildSegmentTree((pos * 2) + 2, leftMid + 1, end, mergerFunction);

        SegmentTreeNode<T> parent = new SegmentTreeNode<>(mergerFunction.apply(left.getNodeValue(), right.getNodeValue()));
        segmentTree[pos] = parent;
        return parent;
    }

    public String printTree() {
        if (segmentTree == null) {
            return "Segment Tree is not built. Call buildSegmentTree";
        }
        StringBuilder output = new StringBuilder();
        for (SegmentTreeNode treeNode : segmentTree) {
            if (treeNode != null) {
                output.append(treeNode.getNodeValue()).append(" ");
            }
        }
        return output.toString();
    }


    private static class SegmentTreeNode<C> {
        C nodeValue;

        SegmentTreeNode(C val) {
            nodeValue = val;
        }

        C getNodeValue() {
            return nodeValue;
        }
    }


}

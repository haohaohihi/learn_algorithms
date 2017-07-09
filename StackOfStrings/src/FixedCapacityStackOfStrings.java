import edu.princeton.cs.algs4.StdOut;

/**
 * Created by haohao on 17-7-8.
 */
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings() {
        s = new String[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(String item) {
        // push操作前进行扩容
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
        StdOut.println("Length:" + s.length);
        StdOut.println("N:" + N);
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;
        // pop操作后进行缩小
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        StdOut.println("Length:" + s.length);
        StdOut.println("N:" + N);
        return item;
    }

    private void resize(int capacity) {
        String[] newArray = new String[capacity];
        for (int i = 0; i < N; i++) {
            newArray[i] = s[i];
        }
        s = newArray;
    }
}

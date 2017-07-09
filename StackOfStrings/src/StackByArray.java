import edu.princeton.cs.algs4.StdOut;

/**
 * Created by haohao on 17-7-9.
 */
public class StackByArray<Item> {
    private Item[] s;
    private int N = 0;

    public StackByArray() {
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        // push操作前进行扩容
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
        StdOut.println("Length:" + s.length);
        StdOut.println("N:" + N);
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        // pop操作后进行缩小
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        StdOut.println("Length:" + s.length);
        StdOut.println("N:" + N);
        return item;
    }

    private void resize(int capacity) {
        Item[] newArray = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            newArray[i] = s[i];
        }
        s = newArray;
    }
}

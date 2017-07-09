/**
 * Created by haohao on 17-3-14.
 */
public class QuickFindUF {
    private int[] id;
    private int[] sz;

    public QuickFindUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int i) {
        while (i != id[i]){
            id[i] = id[id[i]];  //压平树
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
        int i = this.root(p);
        int j = this.root(q);
        if (i == j) return;
        // 加权
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }
        else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}

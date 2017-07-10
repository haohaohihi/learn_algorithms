/**
 * Created by haohao on 17-7-10.
 */
public class MergeBU {
    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++ )  aux[i] = a[i];
        int i = lo, j = mid+1;

        for(int k = lo; k <= hi; k++){
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(aux[j].compareTo(aux[i]) < 0)
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz=1; sz < N; sz = sz+sz){
            for(int lo=0; lo < N-sz; lo += sz + sz){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }
}

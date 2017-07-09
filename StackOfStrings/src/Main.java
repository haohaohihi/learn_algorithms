/**
 * Created by haohao on 17-7-8.
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args){
        StackByArray stack = new StackByArray();
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if (s.equals("-"))  StdOut.println(stack.pop());
            else                stack.push(s);
        }
    }
}

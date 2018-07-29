import java.util.*;
import java.io.*;
import java.math.*;
class Main {
    PrintWriter out = new PrintWriter(System.out);
    InputReader ir = new InputReader(System.in);

    void solve() throws IOException {
        int t = ir.readInt();
        while(t-- > 0) {
            char arr[] = ir.readString().toCharArray();
            int n = arr.length;
            boolean left_big = false;
            int start = n/2 - 1;
            int end = (n % 2 != 1 ? start + 2: start + 1);

            while (start >= 0 && end < n) {
                if (arr[start] < arr[end]) {
                    break;
                } else if (arr[start] > arr[end]) {
                    left_big = true;
                    break;
                }

                start--;
                end++;
            }

            if (left_big) {
                start = 0;
                end = n - 1;
                while(start < end) {
                    arr[end] = arr[start];
                    start++;
                    end--;
                }

                out.println(String.valueOf(arr));
            } else {
                ArrayList <Character> a = new ArrayList();
                for (int i = 0; i < (n + 1)/2; i++) {
                    a.add(arr[i]);
                }
                Collections.reverse(a);
                int carry = 1;
                for (int i = 0; i < (n + 1)/2; i++) {
                    int num = (a.get(i) - '0');
                    num += carry;
                    if (num > 9) {
                        carry = 1;
                        a.set(i, '0');
                    } else {
                        carry = 0;
                        a.set(i, (char)('0' + num));
                        break;
                    }
                }

                if (carry == 1)
                    a.add('1');
                Collections.reverse(a);
                end = n % 2 == 0 ? a.size() - 1: a.size() - 2;
                if (carry == 1) {
                    char ans[] = new char[n + 1];
                    ans[0] = '1';
                    ans[n] = '1';
                    for (int i = 1; i < n; i++)
                        ans[i] = '0';
                    out.println(String.valueOf(ans));
                    continue;
                }
                for (int i = end; i >= 0; i--)
                    a.add(a.get(i));
                char ans[] = new char[a.size()];
                for (int i = 0; i <= a.size(); i++)
                    ans[i] = a.get(i);
                out.println(String.valueOf(ans));
            }
        }
    }





    void run() throws IOException{
        solve();
        out.close();
    }

    public static void main(String args[]) throws IOException{
        new Main().run();
    }
}

class Node {
    int min;
    int max;
    public Node() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void maximum(int max) {
        this.max = Math.max(this.max, max);
    }

    public void minimum(int min) {
        this.min = Math.min(this.min, min);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}


class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars != -1)
            throw new InputMismatchException();
        if (curChar == numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
    public final int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }
    public double readDouble() {
        return Double.parseDouble(readString());
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' && c == '\n' && c == '\r' && c == '\t' && c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
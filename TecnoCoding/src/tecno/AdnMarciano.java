package tecno;

import java.io.*;
import java.util.*;

public class AdnMarciano {
    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();

        pw.println(solve(sc1, sc2, n));

        pw.close();
    }

    private static int solve(char[] sc1, char[] sc2, int n) {

        int mutations = 0;

        for (int i = 0; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) {
                mutacion(sc1, i, n - 1);
                mutations++;
            }
        }

        for (int i = 0; i < sc1.length; i++) {
            if (sc1[i] != sc2[i]) return -1;
        }

        return mutations;
    }

    private static void mutacion(char[] sc1, int start, int end) {
        int i = start;

        while (start < end) {
            char temp = sc1[start];

            sc1[start] = sc1[end];
            sc1[end] = temp;

            start++;
            end--;
        }

        for (; i < sc1.length; i++) sc1[i] = getConjugado(sc1[i]);
    }

    private static char getConjugado(char c) {
        if (c == 'b') return 'd';
        if (c == 'd') return 'b';
        if (c == 'p') return 'q';
        if (c == 'q') return 'p';

        return c;
    }

    //[b, d, x, w, v, q, p, o]
    //[b, d, x, w, v, q, p, o]
    //[b, d, x, w, v, p, q, o]


    static class FastScanner {
        private final int BS = 1 << 16;
        private final char NC = (char) 0;
        private final byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;

        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }

        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }

        private char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }

        public long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }

        public double nextDouble() {
            double cur = nextLong();
            return c != '.' ? cur : cur + nextLong() / cnt;
        }

        public double[] nextDoubles(int N) {
            double[] res = new double[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextDouble();
            }
            return res;
        }

        public String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }

        public boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }

    public static int[] sort(int[] arr) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);

        return arr;
    }
}
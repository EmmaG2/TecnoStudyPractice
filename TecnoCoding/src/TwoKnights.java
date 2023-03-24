import java.io.*;

public class TwoKnights {
  public static void main(String[] args) throws Exception {
    PrintWriter pw = new PrintWriter(System.out);
    FastScanner sc = new FastScanner();
    
    long n = sc.nextLong();
    
    for (long i = 1; i <= n; i++) {
      long combinations = ((i * i) * ((i * i) - 1)) / 2;
      long knights = 4 * (i - 1) * (i - 2);
      pw.println(combinations - knights);
    }
    pw.close();
  }
  
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
  }
}
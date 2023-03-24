import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int countD = 0;
        int countR = 0;
        for (int i = 0; i < f; i++) {
            String name = sc.next();
            for (int j = 0; j < name.length(); j++) {
                if (j % 2 == 0) {
                    if (name.charAt(j) == 'D') {
                        countD++;
                    }
                } else {
                    if (name.charAt(j) == 'R') {
                        countR++;
                    }
                }
            }
        }
        System.out.println(Math.max(countD, countR));
    }
}

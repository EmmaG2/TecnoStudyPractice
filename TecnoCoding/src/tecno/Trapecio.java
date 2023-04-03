package tecno;

import java.util.*;

public class Trapecio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        // Ordenar las longitudes de mayor a menor
        List<Integer> longitudes = Arrays.asList(a, b, c, d);
        Collections.sort(longitudes);
        int l1 = longitudes.get(0);
        int l2 = longitudes.get(1);
        int bMenor = longitudes.get(2);
        int bMayor = longitudes.get(3);

        // en vez de l2, creo que se deberia dividir entre 2, ya que al tratarse de un trapecio
        // si o si tenemos que recibir minimo dos lados iguales
        // para que en la figura tengamos los dos lados paraledos, que serian b y B
        int g = (bMayor - bMenor) / 2;
        double h = Math.sqrt(Math.pow(l1, 2) - Math.pow(g, 2));

        double area = ((bMayor + bMenor) * h) / 2;

        System.out.println((int) Math.floor(area));
    }
}

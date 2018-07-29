import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        // Get L and R from the input
        int N = s.nextInt();
        s.close();
        // Write here the logic to print all integers between L and R
        boolean isPrime = true;
        System.out.println(N);
        for(int j=2; j<=N; j++ ) {
          //  System.out.println("1.0------"+j+"--"+N / 2);
            for (int i = 2; i <= j / 2; i++) {
                //System.out.println("1.0------"+i);
               // System.out.println("1.1--"+j%i);
                if (j%i == 0) {
                    isPrime = false;
                    break;
                }

            }
            //System.out.println("-1.2---"+j+"--"+isPrime);

            if (isPrime) {
               System.out.print(j+" ");

            }
            isPrime = true;
        }
    }
}
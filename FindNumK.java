import java.io.BufferedReader;
import java.io.InputStreamReader;

class FindNumK {
    public static void main(String[] args) throws java.lang.Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int inputNum = Integer.parseInt(line);
        System.out.println(inputNum);
        String[] arr = line.split("");
        int sum_o=0 ,sum_e =0 ,len = arr.length;
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            int k = Integer.parseInt(arr[i]);
            if(i%2 == 0){
                //odd
                if(k*k < len) sum_o = k;
            } else {
                //even number
                sum_e += k;
            }
        }

        for (int i = 1; ; i++) {
            if((sum_e + i)%(sum_o +i) != 0) {
                System.out.println(i);
                break;
            }
        }

    }
}
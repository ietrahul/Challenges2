import java.util.ArrayList;
import java.util.Scanner;

class PalindromeGen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        //String st[] = str.split("");
        //int[] k;
        ArrayList <Integer> arrayList = new ArrayList<>();
       while(str.length() > 0) {
          String a = String.valueOf(str.charAt(0)) ;
           arrayList.add(str.length() - str.replace(a, "").length());
          str = str.replace(a,"");
       }
        int count_odd =0;
        for (Integer num : arrayList) {
           // System.out.println(num +"--"+num%2);
            if(num%2 != 0) count_odd += 1;
        }
       // System.out.println("count_odd--"+count_odd);
        if (count_odd > 1) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }


    }
}
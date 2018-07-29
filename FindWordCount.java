import java.util.Scanner;

public class FindWordCount {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        s.close();
        String st[] = str.split("");
        boolean isPalindrom = true;

        for(int i=0; i<= st.length/2; i++){
            // System.out.println(st[i]);
            if (!st[i].equals(st[st.length-i-1])){
                isPalindrom = false;
                break;
            }
        }

        if(isPalindrom){
            System.out.print("YES");
        }else{
            System.out.print("NO");
        }

    }
}
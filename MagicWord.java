import java.util.Scanner;

class  MagicWord {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine(), strAscii="";
        for (int i = 0; i < str.length() ; i++) {
            char character = str.charAt(i); // This gives the character 'a'
            //int ascii = (int) character;
            strAscii +=  Integer.toBinaryString(character).toString();
            //System.out.println(strAscii);
        }

        int count_1=0, count_0=0;
        count_1 = strAscii.length() - strAscii.replace("1", "").length();
        count_0 = strAscii.length() - strAscii.replace("0", "").length();
        if(count_0 == count_1){
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }
}
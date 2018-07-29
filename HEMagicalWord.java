import java.util.ArrayList;
import java.util.Scanner;

class HEMagicalWord{
    public static boolean isPrimeNumber(int value) {

        boolean isPrime = true;
        //System.out.println(value);
            for (int i = 2; i <= value/2; i++) {
                //System.out.println("1.0------"+i);
                if (value%i == 0) {
                    isPrime = false;
                    break;
                }

            }
            return isPrime;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer testCases = Integer.parseInt(s.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int j = 0; j < testCases; j++) {
            String str = s.nextLine();
            str = s.nextLine();
            arrayList.add(str);
        }
        for (String str : arrayList) {
            String  strAscii = "";
            //System.out.println(str);
            //if(num%2 != 0) count_odd += 1;
            for (int i = 0; i < str.length() ; i++) {
                char character = str.charAt(i); // This gives the character 'a'
                int ascii = (int) character;
                //strAscii +=  Integer.toBinaryString(character).toString();
                System.out.println(ascii);
                int nearPrime;
                for(int k = 0; ; k++){
                    int lowerNum = ascii - k, higherNum =ascii + k;
                    boolean isLowerPrime = false, isHigherPrime = false;
                    if((lowerNum >= 97 && lowerNum <=122)|| (lowerNum >= 65 && lowerNum <=90)) isLowerPrime = isPrimeNumber(lowerNum);
                    if((higherNum >= 97 && higherNum <=122)|| (higherNum >= 65 && higherNum <=90)) isHigherPrime = isPrimeNumber(higherNum);
                    if (isLowerPrime){
                        nearPrime =   lowerNum;
                        break;
                    } else if(isHigherPrime){
                        nearPrime =   higherNum;
                        break;
                    }
                }
               System.out.println("nearPrime"+nearPrime);
                strAscii = strAscii + (char)nearPrime;
            }
            System.out.println(strAscii);
        }

    }

}
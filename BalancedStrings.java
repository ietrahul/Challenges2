import java.util.ArrayList;
import java.util.Scanner;

class BalancedStrings {
    public static boolean isBalancedString (String str) {
        while(str.length()> 0){
            String a = String.valueOf(str.charAt(0)) ;
            //arrayList.add(str.length() - str.replace(a, "").length());
            //str = str.replace(a,"");
            int len = str.length();
            str = str.replace(a, "");
            if ((len - str.length())%2 !=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer testCases = Integer.parseInt(s.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();
        for (int j = 0; j < testCases; j++) {
            arrayList.add( s.nextLine().trim());
        }
        for (String items: arrayList) {
            int len = items.length(), count =0;
            for (int i = 0; i < len; i++) {
                String lastBalString ="";
                for (int j = i+2; j <=len;) {
                    //System.out.println(i+"--"+j);
                    String subStr = items.substring(i,j);
                    String remainingStr = subStr.substring(lastBalString.length());
                    //System.out.println(subStr);
                    if(isBalancedString(remainingStr)) {
                        count += 1;
                        lastBalString =  subStr;
                    }
                    j += 2;
                }

            }

           // System.out.println(count);

        }

    }
}
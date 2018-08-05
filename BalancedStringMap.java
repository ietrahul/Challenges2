import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class BalancedStringMap {
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
        long start = System.currentTimeMillis();
        for (int j = 0; j < testCases; j++) {
            arrayList.add( s.nextLine().trim());
        }

        for (String items: arrayList) {
            int len = items.length(), count =0;
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
            for (int i = 0; i < len; i++) {
                String lastBalString ="";
                HashMap<Integer,Integer> hm2=new HashMap<Integer,Integer>();
                if (hm.containsKey(i)){
                    continue;
                } else {
                    hm2.put(i,0);
                }
                for (int j = i+2; j <=len; j=j+2) {
                    //System.out.println(i+"--"+j);
                    String subStr = items.substring(i,j);
                    String remainingStr = subStr.substring(lastBalString.length());
                    //System.out.println(subStr);
                    if(isBalancedString(remainingStr)) {
                        count += 1;
                        lastBalString =  subStr;
                        //System.out.println(i+"--"+j+"--count--"+ count);
                        if (hm.containsKey(j)){
                            //System.out.println("contains");
                            for (HashMap.Entry<Integer, Integer> entry : hm2.entrySet()) {
                                //System.out.println(entry.getKey() + " = " + entry.getValue());
                                Integer key = entry.getKey();
                                Integer inc = hm.get(j) + hm2.get(key) ;
                                //System.out.println("Increment--"+ hm.get(j));
                                hm2.put(key, inc);
                                //System.out.println(entry.getKey() + " === " + entry.getValue());
                            }
                            break;

                        } else {
                            for (HashMap.Entry<Integer, Integer> entry : hm2.entrySet()) {
                                //System.out.println(entry.getKey() + " = " + entry.getValue());
                                Integer key = entry.getKey();
                                hm2.put(key, hm2.get(key) + 1);
                                //System.out.println(entry.getKey() + " === " + entry.getValue());
                            }
                            hm2.put(j,0);
                        }
                    }  // ends j loop
                   // j += 2;
                }
                 hm.putAll(hm2);
            }

            //System.out.println(count);
            int count2 =0;
            for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
              count2 += entry.getValue();
            }
            System.out.println(count2);
           long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
           System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        }
        /*
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");*/
    }
}
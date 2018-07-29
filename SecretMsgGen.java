import java.util.ArrayList;
import java.util.Scanner;

class SecretMsgGen{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().replace(" ", ",");
        int count_item = str.length() - str.replace(",", "").length() + 1;
        int start=0, end=0, lword=0;
        String word="";
        ArrayList<String> arrayList = new ArrayList<>();
       // arrayList = str.split(" ");
        //str = str.replace(" ", ",");
        //System.out.println(str+"------"+count_item);
        for (int i = 0; i < count_item; i++) {
            end=str.indexOf(',', start);
            if (i==count_item-1){
                arrayList.add(str.substring(start,str.length()).trim());
                break;
            }
            else {
                arrayList.add(str.substring(start,end).trim());
            }
            start=end+1;
            //System.out.println("arrayList["+i+"]:"+arrayList[i]);
        }

        //ArrayList<String> arrayList2 = new ArrayList<>();
        for (String items : arrayList) {
           // System.out.println(items);
            //arrayList2.addAll(java.util.Arrays.asList(items.split("")));
            if(items.length() > lword) {
                lword = items.length();
                word = items;
            }
        }

        //System.out.println(word+"---"+lword);
        //String[][] out = new String[lword][lword];
        String output="";
       /* for (String items : arrayList) {
            int k =0;
            output = output + items;
            int pos = items.length()+1;
            if(items.length() < lword) {
                for (int i = pos; i <=lword ; i++) {
                    char character1 = word.charAt(pos-2); // This gives the character 'a'
                    int ascii1 = (int) character1;
                    char character2 = word.charAt(pos-1);
                    int ascii2 = (int) character2;
                    ascii2 += ascii1;
                    output = output + ascii2;
                    pos +=1;
                    System.out.println(character1+"--"+character2);
                    System.out.println(ascii1+"--"+ascii2);
                    arrayList2.add();
                }
                k += 1;
            }

            System.out.println(output);
        }*/
        for (int i = 0; i < lword; i++) {
            for (String items : arrayList) {
                //System.out.println(items+"--"+items.length()+"--"+i);
                if (items.length() > i ) {
                    //System.out.println("1.1");
                    output = output + items.charAt(i);
                   // System.out.println("1.2");
                } else {
                    char character1 = word.charAt(i-1); // This gives the character 'a'
                    int ascii1 = (int) character1;
                    char character2 = word.charAt(i);
                    int ascii2 = (int) character2;
                    ascii2 += ascii1;
                    output = output + ascii2;
                }
            }
            //System.out.println(output);
        }
        System.out.println(output);


    }

}
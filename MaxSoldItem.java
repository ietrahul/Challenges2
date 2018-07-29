import java.util.*;

class MaxSoldItem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int count_item = str.length() - str.replace(",", "").length() + 1;
        int start=0, end=0;
        ArrayList<String> arrayList = new ArrayList<>();
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

       /* for (String items : arrayList) {
             System.out.println(items);
            //if(num%2 != 0) count_odd += 1;
        }*/
        Set<String> unique = new HashSet<String>(arrayList);
        //String item="";
        StringBuilder item = new StringBuilder ("");
        int item_count =0;
        for (String key : unique) {
            //System.out.println(key + ": " + Collections.frequency(arrayList, key));
            if(item_count == 0) {
                item_count = Collections.frequency(arrayList, key);
                item = new StringBuilder (key);
            } else if ( Collections.frequency(arrayList, key) > item_count ){
                item_count = Collections.frequency(arrayList, key);
                item = new StringBuilder (key);
            }else if ( Collections.frequency(arrayList, key) == item_count ){
                if( key.length() < item.length()) item = new StringBuilder (key);
            }

        }

        System.out.println(item+":"+item_count);
        //System.out.println(item.length());

    }
}
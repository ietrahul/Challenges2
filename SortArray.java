import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class SortArray
{
    public static int getArrayIndex(int[] arr,int value) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==value){
                k=i;
                break;
            }
        }
        return k;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
		//Scanner s = new Scanner(System.in);
		//String inputString = s.nextLine();
       int N ,start=0,end=0;
       int[] ids, heights, sortedHeights;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        N =Integer.parseInt(line);
        ids = new int[N];
        heights = new int[N];
        sortedHeights = new int[N];

        line = br.readLine();
        for (int i = 0; i < N; i++) {
            end=line.indexOf(',', start);
            if (i==N-1){
                ids[i] =Integer.parseInt(line.substring(start,line.length()));
                break;
            }
            else {
                ids[i] =Integer.parseInt(line.substring(start,end ));
            }
            start=end+1;
           //System.out.println("ids["+i+"]:"+ids[i]);
        }
        line = br.readLine();
        start =0; end =0;
        for (int i = 0; i < N; i++) {
            end=line.indexOf(',', start);
            if (i==N-1){
                heights[i] =Integer.parseInt(line.substring(start,line.length()));
                sortedHeights[i] =  heights[i];
                break;
            }
            else {
                heights[i] =Integer.parseInt(line.substring(start,end ));
                sortedHeights[i] =heights[i];
            }
            start=end+1;
            //System.out.println("heights["+i+"]:"+heights[i]);
        }
        //sortedHeights = heights;
        Arrays.sort(sortedHeights);
        //System.out.println("Hello");
       /* for (int i = 0; i < N; i++) {
            System.out.println(ids[i] + "--" + heights[i]+"--"+  sortedHeights[i]) ;
        }*/
       //System.out.println("Hello22222222");
        for (int i = 0; i < N; i++) {
            //int index = Arrays.binarySearch(heights, 100);
            int index = getArrayIndex(heights,sortedHeights[i]);
            //System.out.println(index);
            if(i == N-1) {
                System.out.print(ids[index] );
            }
            else {
                System.out.print(ids[index] + ",");
            }
        }


    }


}
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;


class OverlapClock
{


    public static void main (String[] args) throws java.lang.Exception
    {
        //Scanner s = new Scanner(System.in);
        //String inputString = s.nextLine();
        int start=0, end=0;
        int[] time1, time2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ;
        time1 = new int[2];
        time2 = new int[2];

        line = br.readLine().trim();
        for (int i = 0; i < 2; i++) {
            end=line.indexOf(':', start);
            if (i==2-1){
                time1[i] =Integer.parseInt(line.substring(start,line.length()));
                break;
            }
            else {
                time1[i] =Integer.parseInt(line.substring(start,end ));
            }
            start=end+1;
            //System.out.println("ids["+i+"]:"+ids[i]);
        }
        line = br.readLine();
        start =0; end =0;
        for (int i = 0; i < 2; i++) {
            end=line.indexOf(':', start);
            if (i==2-1){
                time2[i] =Integer.parseInt(line.substring(start,line.length()));
                break;
            }
            else {
                time2[i] =Integer.parseInt(line.substring(start,end ));
            }
            start=end+1;
            //System.out.println("ids["+i+"]:"+ids[i]);
        }

       /* for (int i = 0; i < 2; i++) {
            System.out.println(time1[i]+"--"+time2[i]);
        }*/

        int totHours= (time2[0]*60 + time2[1] -  time1[0]*60 - time1[1] +1)/60;
        //System.out.println(totHours);
        int output = totHours - totHours/12;
        System.out.println(output);

    }


}
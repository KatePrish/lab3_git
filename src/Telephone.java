/**
 * Created by user on 26.05.2016.
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telephone {
    public static void main(String[] ars){
        Telephone telephonefixer = new Telephone();
        telephonefixer.fix(new File("C:\\Users\\user\\Desktop\\1.txt"));
    }

    public Telephone(){

    }

    public void fix(File file){
        String in="";
        int ch;
        try{
            FileReader inFile= new FileReader(file);
            while((ch=inFile.read())!=-1)
            {
                in+=(char)ch;
            }
        } catch (IOException e){
            System.out.println("Couldn't open file to read");
            return;
        }
        Matcher matcher = Pattern.compile("\\s*\\+?(\\d[\\s\\-\\(\\)\\+]{0,3}){11}").matcher(in);
        StringBuffer out = new StringBuffer();

        System.out.println(matcher.appendTail(out).toString());
    }
}
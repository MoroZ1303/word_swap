package ivan.home;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class Main
{
    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }

    public static String swapLetter(String str,String oldWord, String newWord)
    {
        String newStr = "";
        for(int i=0;i<str.length();i++)
        {
            String blank = " ";
            String c = str.substring(i,i+1);
            if((i==0 || c.equals(blank))&& i+oldWord.length() <= str.length())
            {
                if(oldWord.equals(str.substring(i+1,i+1+oldWord.length())))
                {
                    if (str.substring(i+oldWord.length()+1,i+oldWord.length()+2).equals(blank))
                    {
                        newStr= newStr + " " + newWord;
                        i = i+ oldWord.length()+1;
                    }
                }
            }
            newStr =newStr+c;
            System.out.println(newStr);
        }

        return(newStr);
    }

    public static void main(String[] args) {
        List l = readFileInList("C:\\Users\\theygg\\Desktop\\TestFile.txt");
        Iterator<String> itr =l.iterator();
        while(itr.hasNext())
        {
            String s = itr.next();
            System.out.println(s);
            swapLetter(s,"every one","noone");
            System.out.println(s);
        }
    }
}


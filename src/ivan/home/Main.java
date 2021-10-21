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

    public static Boolean isDel(String s)
    {
        if (s.equals(" ")
                || s.equals(",")
                || s.equals(".")
                ||s.equals("\t")
                ||s.equals("\n")
                ||s.equals("!")
                ||s.equals("?")
                ||s.equals(":")
                || s.equals(";")
                || s.equals("-"))
        {
            return true;
        }
        return false;
    }

    public static String swapLetter(String str,String oldWord, String newWord)
    {
        String newStr = "";
        for(int i=0;i<str.length();i++)
        {
            String blank = " ";
            String c = str.substring(i,i+1);
            if(i==0 && i+oldWord.length() <= str.length() && !isDel(str.substring(0,1)))
            {
                if(oldWord.equals(str.substring(i,i+oldWord.length())))
                {
                    if ((i+oldWord.length() == str.length()))
                    {
                        newStr= newStr + newWord;
                        i = i+ oldWord.length();
                    }
                    else if (isDel(str.substring(i+oldWord.length(),i+oldWord.length()+1)))
                    {
                        newStr= newStr + newWord;
                        i = i+ oldWord.length() - 1;
                    }
                }
            }
            else if(isDel(c) && i+oldWord.length() + 1 <= str.length())
            {
                newStr += c;
                if(oldWord.equals(str.substring(i+1,i+1+oldWord.length())))
                {
                    if ((i+oldWord.length()+1 == str.length()))
                    {
                        newStr= newStr + newWord;
                        i = i+ oldWord.length()+1;
                    }
                    else if (isDel(str.substring(i+oldWord.length()+1,i+oldWord.length()+2)))
                    {
                        newStr= newStr + newWord;
                        i = i+ oldWord.length();
                    }
                }
            }
            else newStr =newStr+c;
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
            swapLetter(s,"a","bb");
            System.out.println(s);
        }
    }
}


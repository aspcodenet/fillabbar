package se.systementor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab1 {
    public void run(){
        String path = "exfil.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            boolean isOddLine = true;
            while (( line = br.readLine()) != null) {
                if(isOddLine)
                    System.out.println(line);    
                isOddLine = !isOddLine;
            }
        }        
        catch(IOException ex){
            System.out.println(ex);
        }
    }
}

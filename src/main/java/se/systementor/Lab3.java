package se.systementor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab3 {
    public void run(){
        String path = "exfil.txt";
        String path2 = "resultat.txt";

        deleteFileIfNotExists(path2);


        try (BufferedReader br = new BufferedReader(new FileReader(path));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
            String line;
            int lineNumber = 1;
            while (( line = br.readLine()) != null) {
                bw.write(lineNumber + " " + line + "\n");
                lineNumber++;
            }
        }        
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    private void deleteFileIfNotExists(String path2) {
        try{
            Files.deleteIfExists(Paths.get(path2));                
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }
    
}

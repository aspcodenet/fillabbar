package se.systementor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lab4 {
    public void run(){
        String path = "Lab5TextFile-InData1.txt";
        String path2 = "sortedBirds.txt";
        deleteFileIfExists(path2);
        //test

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
            List<String> allLines = Files.readAllLines(Paths.get(path));
            allLines.sort(null);

            for(String line : allLines){
                bw.write(line + "\n");
            }

        }
        catch(IOException ex){
            System.out.println(ex);
        }
        


        
    }


    private void deleteFileIfExists(String path2) {
        try{
            Files.deleteIfExists(Paths.get(path2));                
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

}

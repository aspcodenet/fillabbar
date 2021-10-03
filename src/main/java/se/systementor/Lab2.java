package se.systementor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab2 {

    private final String path = "hockeyplayers.txt";

    public void run(){
        while(true){
            showMenu();
            int sel = Integer.parseInt(System.console().readLine());
            if(sel == 1)
                addPlayer();
            else if(sel == 2)
                clearAllPlayers();
            else if(sel == 3)
                break;
            }
    }

    private void clearAllPlayers() {
        try{
            Files.deleteIfExists(Paths.get(path));                
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        
    }

    private void addPlayer() {
        System.out.print("Ange namn:");
        String namn = System.console().readLine();

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
            br.write(namn + "\n");
        }
        catch(IOException ex){
            System.out.println(ex);
        }



    }

    private void showMenu() {
        System.out.println("1. Lägg till hockeyspelare");
        System.out.println("2. Rensa alla");
        System.out.println("3. Exit");
    }
}

package se.systementor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab5 {

    String path = "users.txt";

    public void run(){

        while(true){
            printMenu();
            String input = System.console().readLine();
            if(input.equalsIgnoreCase("a"))
                login();
            else if(input.equalsIgnoreCase("b"))
                registerAccount();
            else if(input.equalsIgnoreCase("c"))
                break;
        }

    }

    private void registerAccount() {
        System.out.print("Ange användarnamn:");
        String inputUserName = System.console().readLine();
        System.out.print("Lösenord:");
        String inputPassword = System.console().readLine();

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path,true))) {
            br.write(inputUserName + "!" + inputPassword +"\n");
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        

    }

    private void login() {
        System.out.print("Ange användarnamn:");
        String inputUserName = System.console().readLine();
        System.out.print("Lösenord:");
        String inputPassword = System.console().readLine();

        boolean foundUserAndPassword = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while (( line = br.readLine()) != null) {
                if(line.equals(inputUserName + "!" + inputPassword )){
                    foundUserAndPassword = true;
                    break;
                }
            }
        }        
        catch(IOException ex){
            System.out.println(ex);
        }
        if(foundUserAndPassword == false)
            System.out.println("Inloggning misslyckades");
        else
            System.out.println("Inloggning lyckades");

    }

    private void printMenu() {
        System.out.println("a) Login");
        System.out.println("b) Registrera nytt konto");
        System.out.println("c) Avsluta");
        System.out.print("Ange val:");
    }
    
}

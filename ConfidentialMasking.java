/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confidentialmasking;
import java.util.*;
import confidentialmasking.ConfidentialName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author KM
 */
public class ConfidentialMasking {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // To get file name
        Scanner scanner = new Scanner(System.in);    
        
        System.out.println("*** Confidential Data Masking ***");
        System.out.println(" - to mask server.log");
        System.out.print("Enter file name: ");
        
        String filename;
        filename = scanner.next();
                
        // To get input from file line by line;
        String filetext;
        filetext = "";
        String fileloc = "C:\\JAVA\\";
        File input = new File(fileloc + filename);
        File output = new File(fileloc + "masked" + filename);
        /*
        File input = new File(filename);
        File output = new File("masked" + filename);
        */
        FileWriter fw = new FileWriter(output);
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\n");
        int i = 0;  //counter for line read
        while(sc.hasNext()){
            /* To call ConfidentialName class
               - to check SndPNA & RcvPNA in the file
            */
            i++;
            filetext = sc.nextLine();
            System.out.println(filetext);
            ConfidentialName CheckPNA = new ConfidentialName();
            CheckPNA.inputPNA = filetext;
            CheckPNA.Identify();
            if (CheckPNA.maskedPNA.equals(filetext)){
                filetext = filetext;
            } else {
                filetext = filetext.replaceAll(CheckPNA.foundPNA, CheckPNA.maskedPNA);
            }
            System.out.println(filetext);
            fw.write(filetext.concat("\n"));
        }
        System.out.println("Line read: " + i);
        fw.close();
    }
}

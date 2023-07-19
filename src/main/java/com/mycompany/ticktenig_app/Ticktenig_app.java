/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ticktenig_app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2m
 */
public class Ticktenig_app {

    public static void main(String[] args) throws IOException {
         Scanner sc = new Scanner(System.in);
        String categoryFile = "issue categories.txt";// name of the file containing issue categories and types
              ArrayList<String> categories = new ArrayList<String>();
// put categories from file 
 
 ArrayList<String> types = new ArrayList<String>();//put types from file
  String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(categoryFile));
             while ((line = reader.readLine()) != null) {
                 char c=line.charAt(0);
                 if(c=='-'){String newStr= line.substring(1);
                     types.add(newStr);}
                 else
                categories.add(line);
            }
        reader.close();} catch (FileNotFoundException ex) {
              System.out.println("Error reading issue categories" );
           
        }
//        System.out.println(types);
//        System.out.println(categories);
       

           while(true)
           { System.out.println("please enter number for option" );
         System.out.println("1.Add new ticket");
          System.out.println("2.View tickets");
           System.out.println("3.Exit");
          String userInput = sc.nextLine();
            if (userInput.equals("1")) {
                // Create a new ticket
                System.out.println("Enter your name:");
                String name = sc.nextLine();
                System.out.println("Enter a description of the problem:");
                String description = sc.nextLine();
                System.out.println("Select an issue category:");
                   // Display the list of issue categories to the user
                for (int i = 0; i < categories.size(); i++) {
                    System.out.println((i + 1) + ". " + categories.get(i));
                }

                // Prompt the user to select an issue category
                int categoryIndex = Integer.parseInt(sc.nextLine()) - 1;
                if (categoryIndex < 0 || categoryIndex >= categories.size()) {
                    System.out.println("Invalid category index");
                    continue;
                }
                String category = categories.get(categoryIndex);
                // Display the list of issue types to the user
                int j=0;
                
                int n=categoryIndex+1;
                for (int i = n*3; i>=(n*3)-2; i--) {
                    
                    System.out.println((j + 1) + ". " + types.get(i));
                    j=j+1;
                }
                int typeIndex = Integer.parseInt(sc.nextLine()) - 1;
                if (typeIndex  < 0 || typeIndex  >= categoryIndex+3) {
                    System.out.println("Invalid category index");
                    continue;
                }
                String type = types.get(typeIndex);
                   // Save the ticket to a file
                try {
                    FileWriter writer = new FileWriter("tickets.txt", true); // append to the end of the file
                    writer.write(name + "," + description + "," + category +","+type+"\n");
                    writer.close();
                    System.out.println("Ticket saved");
                } catch (IOException e) {
                    System.out.println("Error saving ticket to file");
                }
                
                
           }
            else if (userInput.equals("2")) {
                // View existing tickets
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("tickets.txt"));
                    
                    while ((line = reader.readLine()) != null) {
                        String[] fields = line.split(",");
                        System.out.println("Name: " + fields[0]);
                        System.out.println("Description: " + fields[1]);
                        System.out.println("Category: " + fields[2]);
                        System.out.println("Type of issue: " + fields[3]);
                        System.out.println();
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error reading tickets from file");
                }
            }
            else if (userInput.equals("3")) {
                // Exit the program
                System.out.println("Thanks");
                break;
            } else {
                System.out.println("Kindly check your data");
            }
             sc.close();
        }
            
                
          
 
    }
}


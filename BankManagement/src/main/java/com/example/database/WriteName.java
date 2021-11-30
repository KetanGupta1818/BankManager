package com.example.database;
import com.example.bankmanagement.Party;
import java.util.*;
import java.io.*;

public class WriteName {
    public static File file = new File("C:\\Users\\Admin\\Documents\\Intellij files\\Preloaded Names1.txt");
    public static void writeNamesToFile(List<Party> people) throws IOException {
        FileWriter fw = new FileWriter(file);
        for(Party person: people){
            fw.write(person.getName()+" "+person.getPassword()+"\n");
        }
        fw.close();
    }
}

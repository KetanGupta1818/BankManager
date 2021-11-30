package com.example.database;
import com.example.bankmanagement.Party;
import java.util.*;

import java.io.*;

public class InitialNames {
    public static HashMap<String, Party> mapOfNames = new HashMap<>();
    static File file  = new File("C:\\Users\\Admin\\Documents\\Intellij files\\Preloaded Names1.txt");
    public static int ACCOUNT_NUMBER_INDEX = 0;
    public static List<Party> getListOfInitialParties() throws IOException {
        List<List<String>> names = getNames();
        List<Party> listOfPeople = new ArrayList<>();
        for(List<String> name: names){
            Party p = new Party(Integer.toString(++ACCOUNT_NUMBER_INDEX),name.get(0),name.get(1),0);
            mapOfNames.put(name.get(0),p);
            listOfPeople.add(p);
        }
        return listOfPeople;
    }


    public static List<List<String>> getNames() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String name;
        List<List<String>> list = new ArrayList<>();
        while((name=br.readLine())!=null){
            String[] n = name.split(" ");
            list.add(Arrays.asList(n[0],n[1]));
        }
        return list;
    }
}

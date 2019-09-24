package Hashtable;

import java.util.*;

public class hashTable_Demo {

    public static void main(String[] args) {
        /*
        //create Hashtable
        Hashtable<Integer, String> h = new Hashtable<Integer, String>();

        Hashtable<Integer, String> h1 = new Hashtable<Integer, String>();

        h.put(3, "I");
        h.put(2, "am");
        h.put(1, "Alive!!!!");

        // create a clone or shallow copy of hash table h
        h1 = (Hashtable<Integer, String>)h.clone();

            // checking clone h1
            System.out.println("values in clone: " + h1);

        // clear hash table h
        h.clear();

            // checking hash table h
            System.out.println("after clearing: " + h);

        //todo Sortere fra den højeste nummeriske værdi og ned efter.
        //todo hvis to nøgler har samme værdi, overskrive den til den sidste value med nøglen.


        // creating a hash table
        Hashtable<String, Integer> hashtable1 =
                new Hashtable<String, Integer>();

        // enter name/marks pair
        hashtable1.put("Hello", new Integer(10));
        hashtable1.put("World", new Integer(20));
        hashtable1.put("My", new Integer(30));
        hashtable1.put("Name", new Integer(40));
        hashtable1.put("Is", new Integer(50));

        // get the value mapped with key

        System.out.println(hashtable1.get("Hello"));

        //todo kan benytte String som key
        //todo numre som value.
        */

        //Creating hashtable
        Hashtable<String, String> table = new Hashtable<String, String>();

        table.put("One", "Hello");
        table.put("Two", "Right");
        table.put("Three", "There");
        table.put("Fore", "Me");
        table.put("Five", "You");
        table.put("Six", "I");

        System.out.println("Values in table " + table);

        System.out.println();

        //Kigger efter en bestemt værdi i table
        System.out.println("Kan ordet kendes: " + table.contains("There"));

        System.out.println("Kan ordet kendes: " + table.contains("Left"));

        System.out.println();

        Enumeration e = table.elements();
        System.out.println("Values in table: ");

        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

    }
}

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/* The List TopStreamingArtists is composed of a series of artist names */
class TopStreamingArtists {
    private Artist first;
    public void TopStreamingArtists(){
        first = null;
    }
    public boolean isEmpty(){
        return (first == null);
    }
    public void insert(String name)        // insert, in order
    {
        Artist newLink = new Artist(name);    // make new link
        Artist previous = null;            // start at first
        Artist current = first;
        // until end of list,
        while(current != null && name.compareToIgnoreCase(current.getName()) >= 0) { // compare the string and ignore case
            previous = current;
            current = current.next;       // go to next item
        }
        if(previous==null)               // at beginning of list
            first = newLink;              // first --> newLink
        else                             // not at beginning
            previous.next = newLink;      // old prev --> newLink
        newLink.next = current;          // newLink --> old current
    }  // end insert()
    public void displayList() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        PrintStream writer = new PrintStream(new File("D:\\ArtistsSorted-WeekOf10042020.txt"));
        System.out.println("List (first-->last) alphabetically: ");
        Artist current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            System.out.println("");
            String output = current.getName(); // get the artist name of current link
            writer.println(output);
            current = current.next;  // move to next link
        }
        sc.close();
    }

}
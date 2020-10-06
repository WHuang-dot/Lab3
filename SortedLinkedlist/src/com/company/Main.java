package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String [ ] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String path = "D:\\regional-global-daily-latest.csv"; //reading data from this file
        String line = "";
        String artists[] = new String[200];
        int currentIndex=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String[] Artist;
            while((line = br.readLine()) != null){
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // remove quotation mark and other characters
                String tmpArtist = values[2];
                tmpArtist = tmpArtist.replaceAll("\"", ""); //remove quotes from the line and find repeated artist
                for(String art : tmpArtist.split(",")){
                    boolean found = false;
                    for(int i=0;i<currentIndex;i++){
                        if(art.equalsIgnoreCase(artists[i])){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        artists[currentIndex] = art;
                        currentIndex++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        TopStreamingArtists artistNames = new TopStreamingArtists();
        List<String> list = new ArrayList<String>(); //remove null from the array using list
        for(String s : artists) {
            if(s != null && s.length() > 0) {
                list.add(s);
            }
        }
        artists = list.toArray(new String[list.size()]); //convert the list back to an array

        String name;
        for(int i = 1; i < artists.length; i++){ //insert the array to linked list, start with index 1 because index 0 is the label of the data which is 'Artist'
            name = artists[i];
            artistNames.insert(name);
        }
        artistNames.displayList();
    }
}

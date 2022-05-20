/*______________________________________________________________________________________________________
 * 
 * Write a Java program that reads text from a file and prints out the third most frequent word(s)
 * in the text. If there is more than one word they will all be printed. 
 * 
 * The text contains only alpha-numerical characters and spaces, 
 * and words are delimited by one or more spaces.
 * _____________________________________________________________________________________________________
 * 
 * 
 * Example:
 * 
 *______________________________________________________________________________________________________
 *
 *  Input: test.in
 *      
 *       test1 test2 test3 test1 test test2 test2
 *       test1 test3 test1 test test0
 *       
 *  Output:
 *      test3, test
 *______________________________________________________________________________________________________
 *
 *______________________________________________________________________________________________________ 
 */

package fme.internship;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Dinca Silviu-Cristian
 * @email silviudinca412@gmail.com
 *
 */
public class Test2 {



    public static void main(String[] args) throws IOException {
        class Pereche {
            private String nume;
            private int freq;
            Pereche(String nume, int freq){
                this.nume = nume;
                this.freq = freq;
            }

            public int getFreq() {
                return freq;
            }

            public String getNume() {
                return nume;
            }
        }
         class CustomComparator implements Comparator<Pereche> {
            @Override
            public int compare(Pereche o1, Pereche o2) {
                return o2.getFreq() - (o1.getFreq());
            }
        }


        HashMap<String, Integer> wordsFrequency = new HashMap<String, Integer>();
        String text = new String(Files.readAllBytes(Paths.get("test-internship-p2\\test.in")), StandardCharsets.UTF_8);
        String[] lines = text.split("\n");
        ArrayList<String> words = new ArrayList<String >();
        for(int i = 0; i < lines.length; i++){
            words.addAll(Arrays.asList(lines[i].split(" ")));
        }
        for(int i = 0; i < words.size(); i++) {
            if (!wordsFrequency.containsKey(words.get(i)) ) {
                wordsFrequency.put(words.get(i), 1);
            } else {
                wordsFrequency.put(words.get(i), wordsFrequency.get(words.get(i)) + 1);
            }
        }
        ArrayList<Pereche> perechi = new ArrayList<Pereche>();
        for (String name: wordsFrequency.keySet()) {
            String key = name.toString();
            int value = wordsFrequency.get(name);
            //System.out.println(key + " " + value);
            if(value != 0)
                perechi.add(new Pereche(key, value));
        }
//        for (Pereche item : perechi) {
//            System.out.println(item.getNume() + " " + item.getFreq());
//        }

        perechi.sort(new CustomComparator());
        int pozNeeded = 0;
        int index = perechi.size()-1;
        int frequencySearched;
        while(index >= 1 && pozNeeded <= 3){
            if(perechi.get(index).getFreq() != perechi.get(index-1).getFreq())
                pozNeeded++;
            index--;
        }
        // System.out.println(pozNeeded);
        frequencySearched = perechi.get(pozNeeded-1).getFreq();
        for (Pereche item : perechi) {
            if(item.getFreq() == frequencySearched)
                System.out.println(item.getNume());
        }

    }
}
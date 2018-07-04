/*
Exercise 21: (3) Using a Map<String,Integer>, follow the form of UniqueWords.java to create a program that counts
the occurrence of words in a file. Sort the results using Collections.sort( ) with a second argument of
String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort), and display the result.


Exercise 22: (5) Modify the previous exercise so that it uses a class containing a String and a count field to store
each different word, and a Set of these objects to maintain the list of words.
 */
import java.util.*;
import net.mindview.util.*;

public class Excersize21 {
    public static void main(String[] args){
        List<String> words = new ArrayList<>(
                new TextFile("word.txt", "\\W+"));
        Collections.sort(words,String.CASE_INSENSITIVE_ORDER);
        Set<String> swords = new HashSet<>(
                new TextFile("word.txt", "\\W+"));
        Map<String, Integer> cases = new HashMap<>();
        Set<Word> wordSet = new HashSet<>();
        for (String s:swords) {
            int count = 0;
            for (String st:words) {
                if (s.equals(st))
                    count++;
            }
            cases.put(s,count);
        }
        System.out.println(words);
        System.out.println(cases);
        //Excersize 22 way version 1
        Label:
        for (String s:words) {
            for (Word w : wordSet) {
                if (w.getString().equals(s)){
                    w.addCount();
                    continue Label;
                }
            }
            wordSet.add(new Word(s));
        }
        System.out.println(wordSet);
        for (Word w:wordSet) {
            System.out.println(w.getCount());
        }
    }
}

class Word2{
    private String value;
    private int count = 1;
    Word2(String st){
        value = st;
    }
    void addCount() {count++;}
    int getCount() {return count;}
    String getString(){return value;}
    boolean isIn(List<String> l){
        if (l.contains(value))
            return true;
        return false;
    }
}

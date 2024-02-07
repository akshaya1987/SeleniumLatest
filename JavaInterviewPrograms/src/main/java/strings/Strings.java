package strings;

import org.testng.annotations.Test;

public class Strings {
    String name = "Ganesha";
    String place = "newplacea";
    String sample = "aa ABC abC ABc abc aac";
    String animal = "Giraffe";

    @Test
    void manipulator() {
        System.out.println(sample.replace("aa", "p"));
        System.out.println(sample.replace(" ", ""));
        System.out.println(sample.replaceFirst("ab", "D"));
        System.out.println(sample.replaceAll("A", "a"));
        System.out.println(sample.replaceAll("ABC", "LMN"));
        System.out.println(sample.replaceAll("[a-z]", ""));
        System.out.println(place.substring(0,place.length()-1));
    }

    // removing a particular character form the string
    @Test
    void removeParticularCharacter(){
        // Here we are removing 5th character from the string "Giraffe"
        System.out.println(animal.substring(0, 5)+animal.substring(5+1));
    }
}

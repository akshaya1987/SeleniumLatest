package stepdefinitions;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char ch;
        boolean isAlphabets;
        do{
            System.out.println("Enter a Character : ");
            ch = input.next().charAt(0);
            isAlphabets = ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
            if(!isAlphabets){
                System.out.println("This is Not an alphabet");
            }else{
                switch (ch) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        System.out.println("This is a Vowel");
                        break;
                    default:
                        System.out.println("This is a Consonant");
                }
            }
        }while((!(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z')));
    }
}

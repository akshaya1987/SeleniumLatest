package notebook;

import org.testng.annotations.Test;

public class Book {

    @Test
    public void function(){
        int rows = 5;
        for (int i=1; i<=rows; i++){
            for (int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void function1(){
        int rows=5;
        for (int i=1; i<=rows; i++){
            for (int j=1; j<=rows-i+1; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

package org.main;

import java.util.List;
import static java.lang.System.out;
 
public class Main {

    //static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args){
        //log.info("Bonjour");

        if (Program.isValidSubsequence(List.of(1,2,3), List.of(2,2,3))){
            out.println("C'est une sous-sequence");
        }

    }
}

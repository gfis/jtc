/*  Concatenates 4 words on the commandline
 *  Java Training Course example file
 *  2017-11-10 , Georg Fischer
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  
 *  @author Georg Fischer <dr.georg.fischer at gmail.com>
 */
public class StringAdd {

    /**
     *  Test program
     *  @param args commandline arguments: 4 words
     */
    public static void main(String[] args) {
        String sum = args[0] + " " + args[1] + " " + args[2] + " " + args[3] + " ";
        String sum2 = sum + sum + sum + sum;
        System.out.println(sum2);
    } // main

} // StringAdd

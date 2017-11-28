package org.teherba.jtc.iban;


import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 * Java Training Course example file
 * 2017-11-28, Georg Fischer
 *

 * Copyright 2017 Winarso.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 */

/**
 * 
 * @author Winarso
 */
public class CheckIBAN {
    
    /** String of characters */
    public static String CHARACTER = "ABCDEFGHIJKLMNOPKRSTUVWXYZ";
    
    /** Associate the country code with IBAn length
     * 
     * @param iban the IBAN code to check
     * @return the length of IBAN
     */
    public static int checkCountry(String iban){
        int result = 0;
        switch(iban.substring(0,2)){
            case "DE":
                result = 22;
                break;
            case "MT":
                result = 31;
                break;
            case "BR":
                result = 29;
                break;
            case "FR":
                result = 27;
                break;
            case "PK":
                result = 24;
                break;
            case "TN":
                result = 24;
                break;
            case "EE":
                result = 20;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
    
    public static String process(String iban){
        String result = "";
        String ibanStart = "";
        String ibanEnd = "";
        iban = iban.replaceAll("\\s+", "");
        checkCountry(iban);
        
        if(iban.length() == checkCountry(iban)){
           ibanStart = iban.substring(0,4);
           ibanEnd = iban.substring(4);
           iban = ibanEnd + ibanStart;
           Pattern pat = Pattern.compile("[A-Z]");
           Matcher mat = pat.matcher(iban);
           while (mat.find()) {
            int start = mat.start();
            int end   = mat.end();
            iban = iban.replaceAll(iban.substring(start, end), String.valueOf(CHARACTER.indexOf(iban.substring(start, end))+10));
            mat = pat.matcher(iban);
           }
           BigInteger count = new BigInteger(iban);
           
           if(count.mod(BigInteger.valueOf(97)).intValue() == 1){
               result = "true";
           }else{
               result = "false";
           }
        }else{
            result = "Wrong Number";
        }
        return result;
    }
    /**
     * Test program
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) { // set default arguments
            args = new String[] { "DE44 5001 0517 5407 3249 31" };
        } // set default arguments
        String iban = args[0];
        System.out.println(process(iban));
    } // main

} // CheckIBAN
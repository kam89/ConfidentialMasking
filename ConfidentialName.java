/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confidentialmasking;
import java.util.regex.*;
/**
 *
 * @author KM
 */
public class ConfidentialName {
    public String inputPNA;
    public String maskedPNA;
    public String foundPNA;
    final String PNAInput = "(<ns0:SndPNA>|<ns0:RcvPNA>)[a-z A-Z \\W \\d]{1,140}(</ns0:SndPNA>|</ns0:RcvPNA>)";;
    final String ConfidentialName = "[a-zA-Z\\d]";
    final String PNAPrefix = "(<ns0:SndPNA>|<ns0:RcvPNA>)";
    final String PNAPostfix = "(</ns0:SndPNA>|</ns0:RcvPNA>)";
    
    public String Identify(){
        return maskedPNA = PNAtext(inputPNA);
    }
    
    public String PNAtext(String input){
        String tempname;
                
        Pattern findPNA = Pattern.compile(PNAInput);
        Matcher PNAMatch = findPNA.matcher(input);
        if (PNAMatch.find()){
            tempname = PNAMatch.group(0);
            tempname = tempname.replaceAll(PNAPrefix, "");
            tempname = tempname.replaceAll(PNAPostfix, "");
            foundPNA = tempname;
            tempname = tempname.replaceAll(ConfidentialName, "X");
            System.out.println(foundPNA);
        }else{
            tempname = input;
        }
        return tempname;
    }
}

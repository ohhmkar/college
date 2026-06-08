/**
 * A class that converts a number in roman representation to a decimal representation and vice versa
 *
 * @author Omkar Anil Gajare
 * @version 27/2/26
 */
public class RomanDecimalConverter
{
    public int decimal;
    public String roman = "";
    static char[] roman_rep = {'M','D','C','L','X','V','I'};
    static int[] dec_rep = {1000,500,100,50,10,5,1};
    int dec_val = 0;
    String roman_val = "";
    //Constructors for integer input
    RomanDecimalConverter(int n){
        decimal = n;
    }
    //Constructor for String input
    RomanDecimalConverter(String r){
        roman = r;
    }
    /*
     * Helper function to check if nextChar is either a or b
     * Param: nextChar -> char
     *        a -> char
     *        b -> char
     * Returns: -1 if true else 1
    **/
    int checkVal(char nextChar,char a,char b){
        return ((nextChar == a)||(nextChar == b))? -1 : 1;
    }
    /*
     * Function that converts decimal representation to roman representation
     * Param: decimal -> int
     * Returns: Number in roman representation 
    **/
    String convertValue(int decimal){
        String ans = "";
        int temp;
        while(decimal>0){
            for(int j=0;j<dec_rep.length;j++){
                temp = decimal/dec_rep[j];
                if(temp == 4){
                    if(dec_rep[j] == 100){
                        roman_val = roman_val.concat("CD");
                    }
                    else if(dec_rep[j] == 10){
                        roman_val = roman_val.concat("XL");
                    }
                    else if(dec_rep[j] == 1){
                        roman_val = roman_val.concat("IV");
                    }
                }
                else if(temp == 9){
                    if(dec_rep[j] == 100){
                        roman_val = roman_val.concat("CM");
                    }
                    else if(dec_rep[j] == 10){
                        roman_val = roman_val.concat("XC");
                    }
                    else if(dec_rep[j] == 1){
                        roman_val = roman_val.concat("IX");
                    }
                }
                else{    
                    for(int k=0;k<temp;k++){
                        roman_val = roman_val.concat(String.valueOf(roman_rep[j]));
                    }
                }
                decimal -= temp * dec_rep[j];
            }
        }
        return roman_val;
    }
    /*
     * Function that converts roman representation to decimal representation
     * Param: roman -> String
     * Returns: Number in decimal representation 
    **/
    int convertValue(String roman){
        int ans = 0;
        int temp;
        for(int i=0;i<roman.length()-1;i++){
            char c = roman.charAt(i);
            switch(c){
                case 'M': ans+=1000; break;
                case 'D': ans+=500; break;
                case 'C': ans+=100 * checkVal(roman.charAt(i+1), 'M', 'D'); break;
                case 'L': ans+=50; break;
                case 'X': ans+=10 * checkVal(roman.charAt(i+1), 'L', 'C'); break;
                case 'V': ans+=5; break;
                case 'I': ans+=1 * checkVal(roman.charAt(i+1), 'V', 'X'); break;
            }
        }
        char c = roman.charAt(roman.length()-1);
        switch(c){
            case 'M': ans+=1000; break;
            case 'D': ans+=500; break;
            case 'C': ans+=100; break;
            case 'L': ans+=50; break;
            case 'X': ans+=10; break;
            case 'V': ans+=5; break;
            case 'I': ans+=1; break;
        }
        dec_val = ans;
        return dec_val;
    }
}
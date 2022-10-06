package JavaAssignments;

import java.util.Scanner;

public class PasswordShrength {
	boolean isSC(char ch)
    {
        
        return (ch=='$' || ch=='@' || ch=='#' ||
                           ch=='-' || ch=='_');
    }
 
 boolean lowerC(String str) {
     for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                return true;
            }
        }
     return false;
 }
 
 boolean upperC(String str) {
     for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
     return false;
 }
 
 boolean isNumber(char ch) {
     return (ch=='1' || ch=='2' || ch=='3' ||
             ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' ||
                     ch=='9' || ch=='0');
 }
 
 
 
 int countNum(String str) {
     int count = 0,set=0;
        for (int i = 0; i < str.length(); i++) {
            if (isNumber(str.charAt(i))) {
                if(set==0) {
                    count=5;
                    set=1;
                }
                else count++;
            }
        }
                
        return count;
     
 }




int countSC(String str)
{
    int count = 0,set=0;
    for (int i = 0; i < str.length(); i++) {
        if (isSC(str.charAt(i))) {
            if(set==0) {
                count=5;
                set=1;
            }
            else count=count+2;
        }
    }
            
    return count;
}

public int checker(String str) {
    int strength=0;
    if (str.length()<8) {
        return 0;
    }
    if(lowerC(str)) {
        strength=strength+5;
    }
    if(upperC(str)) {
        strength=strength+5;
    }
    int st=countSC(str);
    int nt=countNum(str);
    
    strength=strength+st+nt;
    
    return strength;
//    if(strenght>25)
//        return "Strong";
//    else if(strenght> 20)
//        return "Moderate";
//    else
//        return "weak";
    
    
}
	
	
	
	
}
	
	


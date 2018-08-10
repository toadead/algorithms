import java.util.HashSet;
import java.util.Set;


/* 
*  Implement an algorithm to determine if a string has all unique characters. 
*/

public class UniqueCharsInString {
    
    private String str;
    
    public UniqueCharsInString(String str) {
        this.str = str;
    }
    
    // use ascii indexed boolean array
    // speed is O(n)
    public boolean isAsciiUnique() {
        boolean[] ascii = new boolean[128];     // there are 128 ASCII chars
        
        for (int i=0; i<=str.length()-1; ++i) {
            int charInt = str.charAt(i);  // ascii value of the char
            if (ascii[charInt]) {
                return false;
            }
            ascii[charInt] = true;
        }
        
        return true;
    }
    
    // use HashSet
    // speed is O(n)
    public boolean isUnicodeUnique() {
        Set<Character> hashset = new HashSet<Character>();
        
        for (char ch : str.toCharArray()) {
            if (hashset.contains(Character.valueOf(ch))) {
                return false;
            }
            hashset.add(Character.valueOf(ch));
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        String asciiStr1 = "ab245d";
        String asciiStr2 = "4eW22d";
        String unicode1 = "的";
        String unicode2 = "的的";
        
        UniqueCharsInString test1 = new UniqueCharsInString(asciiStr1);
        UniqueCharsInString test2 = new UniqueCharsInString(asciiStr2);
        UniqueCharsInString test3 = new UniqueCharsInString(unicode1);
        UniqueCharsInString test4 = new UniqueCharsInString(unicode2);
        
        System.out.println(asciiStr1 + (test1.isAsciiUnique() ? " has unique chars" : " doesn't have unique chars."));
        System.out.println(asciiStr2 + (test2.isAsciiUnique() ? " has unique chars" : " doesn't have unique chars."));
        System.out.println(unicode1 + (test3.isUnicodeUnique() ? " has unique chars" : " doesn't have unique chars."));
        System.out.println(unicode2 + (test4.isUnicodeUnique() ? " has unique chars" : " doesn't have unique chars."));
    }
}


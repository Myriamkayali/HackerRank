 
    static String happyLadybugs(String b) {
        if (hasUnique(b)) {
            return "NO";
        }
        
        if (alreadyHappy(b)) {
            return "YES";
        }
        
        if (hasSpace(b)) {
            return "YES";
        }
        
        return "NO";
   
            
    }

    public static boolean hasUnique(String s) {
          int[] ascii = new int[26];
         
        
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) != '_') {
                ascii[(int)s.charAt(i)-65]++;
            }
        }
        
        for (int i=0;i<26;i++) {
            if (ascii[i] == 1) {
                return true;
            }
        }
        
        return false;
      
    }
    
    public static boolean alreadyHappy(String s) {
        for (int i=0;i<s.length()-1;i++) {
            if (i == 0 && s.charAt(i) != s.charAt(i+1)) {
                return false;
            }
            else if (s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i-1)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean hasSpace(String s) {
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '_') {
                return true;
            }
        }
        
        return false;
    }  

Ha
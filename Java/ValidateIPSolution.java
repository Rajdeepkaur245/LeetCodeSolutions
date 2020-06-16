class ValidateIPSolution {
    public String validIPAddress(String IP) {
        if (validIPV4(IP)) {
            return "IPv4";
        }
        if (validIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    public boolean validIPV4(String IP) {
        if (IP.isEmpty() || IP.charAt(0)=='.' || IP.charAt(IP.length()-1)=='.') {
            return false;
        }
        String[] tokens = IP.split("\\.");
        if (tokens == null || tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (token.length() > 1 && token.startsWith("0")) {
                return false;
            }
            try {
                int parsedInt = Integer.parseInt(token);
                if (parsedInt<0 || parsedInt>255) return false;
                if (parsedInt==0 && token.charAt(0)!='0') return false;
            } catch(NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validIPV6(String IP) {
        if (IP.isEmpty() || IP.charAt(0)==':' || IP.charAt(IP.length()-1)==':') {
            return false;
        } 
        String[] tokens = IP.split(":");
        if (tokens == null || tokens.length != 8) {
            return false;
        }
        for (String token : tokens) {
            if (token.length()>4 || token.length()==0) {
                return false;  
            } 
            char[] chars = token.toCharArray();
            for(char c:chars) {
                boolean isDigit = c>=48 && c<=57;
                boolean isUppercaseAF = c>=65 && c<=70;
                boolean isLowerCaseAF = c>=97 && c<=102;
                if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
                    return false;
            }
        }
        return true;
    }
}
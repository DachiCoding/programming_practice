
public class Atoi {
    public static int myAtoi(String str) {
        int result = 0;
        int sign = 1;
        int start = 0;
        
        if(str == null || str.length() == 0){
            return result;
        }
        
        str = str.trim();
        
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if(start == 0 && c >= '0' && c <= '9'){
                start = 1;
            } 
            
            if (c >= '0' && c <= '9' && start == 1){
            	if(result >= (Integer.MAX_VALUE - 9)/10 ){
                    if(sign > 0){
                        return Integer.MAX_VALUE;
                    } 
                    
                    if(sign < 0){
                        if(result == (Integer.MAX_VALUE - 9)/10){
                            return Integer.MIN_VALUE + 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = result*10 + (c-'0');
            } else if(i == 0 && (c == '-' || c == '+')) {
                if(c == '-')
                    sign = -1;
            } else {
                return result*sign;
            }
        }
        return result*sign;
    }
}

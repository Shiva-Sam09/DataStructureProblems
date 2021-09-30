class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
            
            HashMap < Character, Integer >  map = new HashMap < > ();
            
            for(int i = 0, len = order.length(); i < len; ++i)
                    map.put(order.charAt(i), i);
            
            for(int i = 0; i < words.length - 1; ++i)
            {
                    
                    String curr = words[i];
                    String ahead = words[i + 1];
                    
                    int ptr1 = 0;
                    int ptr2 = 0;
                    int len1 = curr.length();
                    int len2 = ahead.length();
                    int diff = 0;
                    
                    while( ptr1 < len1 && ptr2 < len2){
                            
                             diff = map.get(curr.charAt(ptr1)) - map.get(ahead.charAt(ptr2));
                            if(diff > 0){
                                    // System.out.println("1");
                                    return false;
                            }
                            
                            if(diff < 0)
                                    break;
                            
                            ++ptr1;++ptr2;
                    }
                  
                    if( diff >= 0 && ptr1 < len1 && ptr2 >= len2){
                                    // System.out.println("2");
                                    return false;
                            }
            }
            
            return true;
    }
}

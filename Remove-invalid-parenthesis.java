// Time: O(n*n*all strings in que)
// space: O(max number of all strings in que)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
      //System.out.println(isValid(s));
      if(s == null || s.length() == 0){
        return output;
      }
      
      HashSet<String> set = new HashSet<>();
      Queue<String> que = new LinkedList<>();
      
      que.add(s);
      set.add(s);
      
      boolean found = false;
      
      while(!que.isEmpty()){
        String front = que.poll();
        
        if(isValid(front)){
          found = true;
          output.add(front);
        }
        
        if(!found){
          // need to go down deeper into the levels
          for(int i=0; i < front.length(); i++){
            if(Character.isLetter(front.charAt(i))) continue;
            
            
            String sub = front.substring(0,i) + front.substring(i+1,front.length());// [a,b) ith is removed
            if(!set.contains(sub)){
              set.add(sub);
              que.add(sub);
            }
          }
        }
      }
        
      return output;
      
    }
  
    private boolean isValid(String s){
      int count = 0;
      // if(s.length() %2 != 0){
      //   return false;
      // } 
      // This condition does not help here, because there could be extra characters
      
      for(int i=0;i<s.length();i++){
        if(count < 0)
        {
          return false;
        }        
        char ch = s.charAt(i);
        if(ch == ')'){
          count -= 1;
        }
        
        if(ch == '('){
          count += 1;
        }
      }
      if(count == 0) return true;
      else return false;
    }
  
}

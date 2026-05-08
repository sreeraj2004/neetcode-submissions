class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') stk.push(ch);
            else{
                if(!stk.isEmpty()){
                    char temp = stk.peek();
                    stk.pop();
                    if((ch == ')' && temp == '(') || (ch == '}' && temp == '{') || (ch == ']' && temp == '[')) continue;
                    else return false;
                }
                else return false;
            }
        }
        return stk.isEmpty();
    }
}

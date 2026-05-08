class Solution {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low < high){
            char left = s.charAt(low);
            char right = s.charAt(high);
            if(!Character.isLetterOrDigit(left)) low++;
            else if(!Character.isLetterOrDigit(right)) high--;
            else{
                if(Character.toLowerCase(left) != Character.toLowerCase(right)) return false;
                else{
                    low++;
                    high--;
                }
            }
        }
        return true;
    }
}

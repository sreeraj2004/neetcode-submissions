class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> amap = new HashMap<>();
        for(char ch : s.toCharArray()){
            amap.put(ch , amap.getOrDefault(ch , 0)+1);
        }
        for(char ch :t.toCharArray()){
            if(!amap.containsKey(ch) || amap.get(ch) == 0) return false;
            amap.put(ch , amap.get(ch)-1);
        }
        return true;
    }
}

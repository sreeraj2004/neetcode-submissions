class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> res = new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c-'a']++;
            }
            String temp = Arrays.toString(count);
            res.putIfAbsent(temp , new ArrayList<>());
            res.get(temp).add(s);
        }
        return new ArrayList<>(res.values());
    }
}

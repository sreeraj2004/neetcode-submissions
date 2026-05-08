class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int i : nums){
            numSet.add(i);
        }

        int len = 0;
        for(int i : numSet){
            if(!numSet.contains(i-1)){
                int curr = 1;
                while(numSet.contains(i+curr)){
                    curr++;
                }
                len = Math.max(len , curr);
            }
        }
        return len;
    }
}

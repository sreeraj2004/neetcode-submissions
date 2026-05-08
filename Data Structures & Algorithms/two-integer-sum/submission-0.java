class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> amap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(amap.containsKey(temp)){
                return new int[]{amap.get(temp),i};
            }
            amap.put(nums[i] , i);
        }
        return new int[]{-1,-1};
    }
}

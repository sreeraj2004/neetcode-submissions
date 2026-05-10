class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(curr , target , nums , 0);
        return res;
    }

    public void helper(List<Integer> curr , int target , int[] nums , int idx){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(idx >= nums.length || target < 0) return;

        curr.add(nums[idx]);
        helper(curr , target-nums[idx] , nums , idx);
        curr.remove(curr.size()-1);
        helper(curr , target , nums , idx+1);
    }
}

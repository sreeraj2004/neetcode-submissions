class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int i = bucket.length - 1; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[counter++] = num;
                    if (counter == k) return res;
                }
            }
        }

        return res;
    }
}
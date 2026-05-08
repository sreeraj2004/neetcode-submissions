class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int low = 0;
        int high = n-1;
        int total = 0;
        while(low < high){
            int w = high - low;
            int h = Math.min(heights[low] , heights[high]);
            int a = w*h;
            total = Math.max(total , a);
            if(heights[low] < heights[high]) low++;
            else high--;
        }
        return total;
    }
}

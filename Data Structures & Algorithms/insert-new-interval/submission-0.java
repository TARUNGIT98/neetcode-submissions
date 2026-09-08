class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j =0;

        // Adding intervals that do not intersect

        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // Merge overlappiung intervals

        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }
        result[j++] = newInterval;

        while(i < intervals.length) {
            result[j++] = intervals[i++];
        }
        return java.util.Arrays.copyOf(result, j);
    }
}

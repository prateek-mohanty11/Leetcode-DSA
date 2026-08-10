class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();

        int n = intervals.length;

        int start = newInterval[0];
        int end = newInterval[1];

        boolean insert = false;

        for (int i = 0; i < n; i++) {

            int s = intervals[i][0];
            int e = intervals[i][1];

            // New interval should come before current interval
            if (!insert && end < s) {
                res.add(new int[]{start, end});
                insert = true;
            }

            // Overlap with new interval
            if (!insert && end >= s && start <= e) {
                start = Math.min(start, s);
                end = Math.max(end, e);
                continue;
            }

            res.add(new int[]{s, e});
        }

        // If new interval was never inserted
        if (!insert) {
            res.add(new int[]{start, end});
        }

        return res.toArray(new int[res.size()][]);
    }
}
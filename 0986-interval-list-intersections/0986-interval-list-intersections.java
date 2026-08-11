class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {

            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);

            // Overlap exists
            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // Move the interval which ends first
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
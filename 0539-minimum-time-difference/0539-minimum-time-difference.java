class Solution {
    public int findMinDifference(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;
        int[] minutes = new int[timePoints.size()];

        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));

            minutes[i] = h * 60 + m;
        } // for

        Arrays.sort(minutes);

        for (int i = 0; i < minutes.length - 1; i++) {
            minDiff = Math.min(minDiff, minutes[i + 1] - minutes[i]);
        } // for

        return Math.min(
            minDiff,
            24*60 - minutes[minutes.length - 1] + minutes[0]
        );
    } // findMinDifference
} // Solution
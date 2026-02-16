class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        for (int i = 0; i < asteroids.length; i++) {
            if (mass < asteroids[i]) return false;

            if (mass + asteroids[i] > 100000) return true;
            mass += asteroids[i];
        } // for

        return true;
    } // asteroidDestroyed

    private int add(int a, int b) {
        return Math.min(a + b, 100001);
    } // moduloAdd
} // Solution
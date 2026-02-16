class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        Stack<Integer> holding = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            while (!holding.isEmpty() && holding.peek() <= mass) {
                mass = add(mass, holding.pop());
            } // if

            if (asteroids[i] > mass) holding.push(asteroids[i]);
            else mass = add(mass, asteroids[i]);
        } // for

        return holding.isEmpty();
    } // asteroidDestroyed

    private int add(int a, int b) {
        return Math.min(a + b, 100001);
    } // moduloAdd
} // Solution
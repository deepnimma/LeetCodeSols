class Solution {
    public int[] replaceElements(int[] arr) {
        int gElem = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = gElem;
            gElem = Math.max(gElem, tmp);
        } // for

        return arr;
    } // replaceElements
} // Solution
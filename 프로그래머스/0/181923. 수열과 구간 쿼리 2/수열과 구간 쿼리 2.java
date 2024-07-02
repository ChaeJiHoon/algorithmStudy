class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];

            answer[i] = findMin(arr, start, end, k);
        }
        return answer;
    }

    private int findMin(int[] arr, int start, int end, int k) {
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            if (arr[i] > k && arr[i] < min) {
                min = arr[i];
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
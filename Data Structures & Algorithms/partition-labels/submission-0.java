class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int N = s.length(), L = 0, R = 0;

        int[] lastPositions = new int[26];
        for(int i = 0; i < N; i++) {
            int index = s.charAt(i) - 'a';
            lastPositions[index] = Math.max(lastPositions[index], i);
        }

        while( L < N ){
            for(int i = L; i <= R; i++) {
                R = Math.max(R, lastPositions[ s.charAt(i) - 'a' ]);
            }
            result.add(R-L+1);
            L = ++R;
        }

        return result;
    }
}


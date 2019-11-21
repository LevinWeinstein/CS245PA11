public class Judge {

    public int findJudge(int N, int [][] trust){

        // whether each person N at index N - 1 trusts someone
        // if people were named instead of ordered, this could be a HashSet
        // in order to achieve O(1) performance.
        boolean trustful[] = new boolean[N];

        // index personID -> value count(otherPersonIds who trust personID)
        // if people were named instead of ordered, this could be a Hashtable
        // in order to achieve O(1) performance
        int trustCount[] = new int [N];

        for (int[] edge : trust){
            if (Math.min(edge[0], edge[1]) >= 1 && Math.max(edge[0], edge[1]) <= N) {
                trustful[edge[0] - 1] = true;
                ++trustCount[edge[1] - 1];
            }
        }

        int firstSolution = -1;
        for (int i = 0; i < N; i++){
            if (!trustful[i] && trustCount[i] >= N - 1){
                if (firstSolution != -1) return -1;
                firstSolution = i + 1;
            }
        }
        return firstSolution;
    }
}

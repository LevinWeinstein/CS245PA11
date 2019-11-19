public class Judge {

    public int findJudge(int peopleInTown, int [][] trust){

        // whether each person N at index N - 1 trusts someone
        // if people were named instead of ordered, this could be a HashSet
        // in order to achieve O(1) performance.
        boolean trustful[] = new boolean[peopleInTown];

        // index personID -> value count(otherPersonIds who trust personID)
        // if people were named instead of ordered, this could be a Hashtable
        // in order to achieve O(1) performance
        int trustCount[] = new int [peopleInTown];

        for (int[] edge : trust){
            trustful[edge[0] - 1] = true;
            ++trustCount[edge[1] - 1];
        }

        int firstSolution = -1;
        for (int i = 0; i < peopleInTown; i++){
            if (!trustful[i] && trustCount[i] == peopleInTown - 1){
                if (firstSolution != -1) return -1;
                firstSolution = i + 1;
            }
        }
        return firstSolution;
    }
}

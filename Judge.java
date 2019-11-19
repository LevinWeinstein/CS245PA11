import java.util.Hashtable;
import java.util.Map;

import java.util.HashSet;
import java.util.Set;

public class Judge {

    private int[][] adjacencyMatrix;

    private boolean trustsNoOne(int person){
        for (int i = 0; i < adjacencyMatrix.length; i++){
            if (i != person && adjacencyMatrix[person][i] != 0)
                return false;
        }
        return true;
    }

    private boolean everyoneTrusts(int person){
        for (int i = 0; i < adjacencyMatrix.length; i++){
            if (i != person && adjacencyMatrix[i][person] == 0)
                return false;
        }
        return true;
    }



    public int findJudge(int peopleInTown, int [][] trust){
        /* adjacencyMatrix = new int[peopleInTown][peopleInTown];

        for (int[] edge : trust)
            adjacencyMatrix[edge[0] - 1][edge[1] - 1] = 1;

        int firstSolution = -1;
        for (int person = 1; person <= adjacencyMatrix.length; person++){
            int index = person - 1;

            if (trustsNoOne(index) && everyoneTrusts(index)){
                if (firstSolution != -1) return -1;
                firstSolution = person;
            }

        }
        return firstSolution;

        */


        /* Set<Integer> trusters = new HashSet<>();
        Map<Integer, Integer> trusteesPerPerson = new Hashtable<>();

        for (int[] edge : trust){
            trusters.add(edge[0]);
            if (!trusteesPerPerson.containsKey(edge[1]))
                trusteesPerPerson.put(edge[1], 0);
            trusteesPerPerson.put(edge[1], trusteesPerPerson.get(edge[1]) + 1);
        }

        int firstSolution = -1;
        for (int i = 1; i <= peopleInTown; i++){
            if (!trusters.contains(i)
                    && trusteesPerPerson.containsKey(i)
                    && trusteesPerPerson.get(i) == peopleInTown - 1){
                if (firstSolution != -1)
                    return -1;
                firstSolution = i;
            }
        }
        return firstSolution; */


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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Judge {

    private int[][] adjacencyMatrix;

    public Judge(int peopleInTown, int [][] trust){
        adjacencyMatrix = new int[peopleInTown][peopleInTown];

        for (int[] edge : trust){
            adjacencyMatrix[edge[0]][edge[1]] = 1;
        }
    }

    public boolean trustsNoOne(int person){
        for (int i = 0; i < adjacencyMatrix.length; i++){
            if (i != person && adjacencyMatrix[person][i] != 0)
                return false;
        }
        return true;
    }

    public boolean everyoneTrusts(int person){
        for (int i = 0; i < adjacencyMatrix.length; i++){
            if (i != person && adjacencyMatrix[i][person] == 0)
                return false;
        }
        return true;
    }

    public int findJudge(){
        int firstSolution = -1;

        for (int i = 0; i < adjacencyMatrix.length; i++){
            if (trustsNoOne(i) && everyoneTrusts(i)){
                if (firstSolution != -1)
                    return -1;
                firstSolution = i;
            }

        }
        return firstSolution;
    }
}

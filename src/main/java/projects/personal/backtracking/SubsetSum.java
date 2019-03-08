package projects.personal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        List<Integer> weights = new ArrayList<>(Arrays.asList(1,2,5,7,10,13,14));
        int target = 15;
        backtrack(weights,new ArrayList<>(),target,0);
    }

    private static void backtrack(List<Integer> weights, List<Integer> subset, int target, int start) {
        if(subset.stream().mapToInt(Integer::intValue).sum() == target) {
            printSolution(subset);
            return;
        }

        for(int i = start; i < weights.size(); ++i) {
            if(isSafe(subset,weights.get(i),target)) {
                addToSet(subset,weights.get(i));
                backtrack(weights,subset,target,i+1);
                removeFromSet(subset,weights.get(i));
            }
        }
    }

    private static boolean isSafe(List<Integer> subset, Integer candidateWeight, int target) {
        return subset.stream().mapToInt(Integer::intValue).sum() + candidateWeight <= target;
    }

    private static void addToSet(List<Integer> subset, Integer candidateWeight) {
        subset.add(candidateWeight);
    }

    private static void removeFromSet(List<Integer> subset, Integer candidateWeight) {
        subset.remove(candidateWeight);
    }

    private static void printSolution(List<Integer> solution) {
        solution.forEach(answer-> System.out.print(answer + " "));
        System.out.println("---------------");
    }
}

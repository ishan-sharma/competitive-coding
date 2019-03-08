package projects.personal.bruteforce;

import java.util.*;

public class PowerSet {

    /*
    How the algorithm works for the powerset of {1, 2, 3}:
    Remove {1}, and execute powerset for {2, 3};
    Remove {2}, and execute powerset for {3};
    Remove {3}, and execute powerset for {};
    Powerset of {} is {{}};
    Powerset of {3} is 3 combined with {{}} = { {}, {3} };
    Powerset of {2, 3} is {2} combined with { {}, {3} } = { {}, {3}, {2}, {2, 3} };
    Powerset of {1, 2, 3} is {1} combined with { {}, {3}, {2}, {2, 3} } = { {}, {3}, {2}, {2, 3}, {1}, {3, 1}, {2, 1}, {2, 3, 1} }.
     */
    private static Set<Set<Integer>> powerSetRecursive(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();

        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }

        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));

        for (Set<Integer> set : powerSetRecursive(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    private static Set<Set<Integer>> powerSetIterative(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();

        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }

        List<Integer> list = new ArrayList<Integer>(originalSet);
        // 1 << originalSet.size(). Left shift of 1 by n = 1 * 2^n
        for(int i = 0; i < 1 << originalSet.size(); i ++) {
            Set<Integer> newSet = new HashSet<Integer>();
            for(int j = 0; j < originalSet.size(); j++) {
                if(((i>>j) & 1) == 1) {
                    newSet.add(list.get(j));
                }
            }
            sets.add(newSet);
        }
        return sets;
    }

    private static void printSet(Set<Set<Integer>> sets) {
        System.out.println("Printing Sets");
        for(Set<Integer> set : sets) {
            System.out.println("set size = " + set.size());
            set.forEach(element-> System.out.print(element + "|"));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSet(powerSetRecursive(new HashSet<>(Arrays.asList(1,2,3,4))));
        System.out.println("printing iterative");
        printSet(powerSetIterative(new HashSet<>(Arrays.asList(1,2,3,4))));
    }
}

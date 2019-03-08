package projects.personal.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class CountElementOccurence {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,3,10,10,10,14);
        countElementOccurence(list,10);
    }

    private static void countElementOccurence(List<Integer> list, int target) {
        int firstOccurence = findFirstOccurence(list,target);
        int lastOccurence = findLastOccurence(list,target);
        System.out.println("total occurence " + (lastOccurence - firstOccurence + 1));
    }

    private static int findFirstOccurence(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int result = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(target == list.get(mid)) {
                result = mid;
                high = mid -1;
            }
            else if(target > list.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurence(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int result = -1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(target == list.get(mid)) {
                result = mid;
                low = mid + 1;
            }
            else if(target > list.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}

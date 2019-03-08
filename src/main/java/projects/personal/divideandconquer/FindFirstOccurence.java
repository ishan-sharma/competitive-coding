package projects.personal.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class FindFirstOccurence {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,3,10,10,10,14);
        findFirstOccurence(list,10);
    }

    private static void findFirstOccurence(List<Integer> list, int target) {
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

        if(result!= -1) {
            System.out.println("First index is " + result);
            return;
        }

        System.out.println("couldn't find the element");
    }
}

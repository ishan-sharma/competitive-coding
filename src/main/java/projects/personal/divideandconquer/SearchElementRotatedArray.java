package projects.personal.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class SearchElementRotatedArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,9,10,11,2,5,6);
    }

    private static void locateElement(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int result = -1;

            if(list.get(mid) == target) {
                result = mid;
                break;
            }

            if(list.get(low) < list.get(mid)) {
                if(target >list.get(low) && target < list.get(mid)) {

                }
            }
            else if(list.get(mid) > list.get(high) && list.get(mid) < target) {

            }
        }
    }
}

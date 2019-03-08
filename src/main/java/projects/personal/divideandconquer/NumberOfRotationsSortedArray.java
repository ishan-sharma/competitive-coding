package projects.personal.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class NumberOfRotationsSortedArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,9,10,2,5,6);
        findRotationCount(list);
    }

    private static void findRotationCount(List<Integer> list) {
        int low = 0;
        int high = list.size() - 1;
        int result = 0;

        while (low <= high) {
            // case 1 : if the search space is already sorted, we have found the minimum element (at index left)
            if(list.get(low) <= list.get(high)) {
                result = low;
                break;
            }

            int mid = low + (high - low)/2;
            int next = (mid + 1)%list.size();
            int prev = (mid + list.size() - 1)% list.size();

            // case 2 : if mid element is less than both its next and previous neighbor, then it is the minimum element of the array
            if(list.get(mid) <= list.get(next) && list.get(mid) <= list.get(prev)) {
                result = mid;
                break;
            }
            /* case 3 : if A[mid..right] is sorted and mid is not the min element,
            then pivot element cannot be present in A[mid..right] and we can discard A[mid..right] and search in the left half */
            else if(list.get(mid) <= list.get(high)) {
                high = mid - 1;
            }
            /* case 4 : if A[left..mid] is sorted then pivot element cannot be present in it and we can discard A[left..mid] and search
            in the right half */
            else if(list.get(mid) >= list.get(low)) {
                low = mid + 1;
            }
        }

        System.out.println("Rotation Count " + result);
    }
}

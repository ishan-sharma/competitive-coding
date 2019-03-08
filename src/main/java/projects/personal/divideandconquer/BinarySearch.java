package projects.personal.divideandconquer;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
//        binarySearchRecursive(list,1,0,list.size()-1);
        binarySearchIterative(list,9);
    }

    private static void binarySearchIterative(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low)/2; //(low + high)/2; this approach can exceed maxInt value

            if(target == list.get(mid)) {
                System.out.println("Target found at index " + mid);
                return;
            }
            else if (target < list.get(mid)) {
                high = mid-1;
            }
            else {
                low = mid + 1;
            }
        }

        System.out.println("Couldn't find element");
    }

    private static void binarySearchRecursive(List<Integer> list, int target, int low, int high) {
        if(low > high) {
            System.out.println("Couldn't find target");
            return;
        }

        int mid = low + (high - low)/2;

        if(list.get(mid) == target) {
            System.out.println("Target found at index " + mid);
            return;
        }
        else if(target > list.get(mid)) {
            binarySearchRecursive(list,target,mid+1,high);
        }
        else {
            binarySearchRecursive(list,target,low,mid-1);
        }
    }
}

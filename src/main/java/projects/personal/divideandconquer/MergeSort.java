package projects.personal.divideandconquer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = {9,8,7,6,5,4,3,2,1};
        list = sort(list);
        Arrays.stream(list).forEach(System.out::println);
    }

    private static int[] sort(int[] list) {
        if(list.length <= 1) {
            return list;
        }

        int[] sublist1 = new int[list.length/2];
        int[] sublist2 = new int[list.length - list.length/2];

        for(int i = 0; i < sublist1.length; ++i) {
            sublist1[i] = list[i];
        }

        for(int i = 0; i < sublist2.length; ++i) {
            sublist2[i] = list[i + list.length/2];
        }

        return merge(sort(sublist1),sort(sublist2));
    }

    private static int[] merge(int[] sublist1, int[] sublist2) {
        int[] resultList = new int[sublist1.length + sublist2.length];
        int i = 0;
        int j = 0;
        for(int k = 0; k < resultList.length; ++k) {
            if(i >= sublist1.length)
                resultList[k] = sublist2[j++];
            else if(j >= sublist2.length)
                resultList[k] = sublist1[i++];
            else if(sublist1[i] <= sublist2[j])
                resultList[k] = sublist1[i++];
            else
                resultList[k] = sublist2[j++];

        }
        return resultList;
    }
}

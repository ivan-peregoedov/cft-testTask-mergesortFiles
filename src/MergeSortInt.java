import java.util.ArrayList;

public class MergeSortInt {
    public void merge(ArrayList<Integer> array, int lb, int mid, int rb) {
        int LeftPartLength = (mid - lb) + 1;
        int RightPartLength = (rb - mid);

        int[] lArr = new int[LeftPartLength];
        int[] rArr = new int[RightPartLength];

        for (int i = 0; i < LeftPartLength; i++) {
            lArr[i] = array.get(lb + i);
        }

        for (int j = 0; j < RightPartLength; j++) {
            rArr[j] = array.get(mid + j + 1);
        }

        int i = 0, j = 0;
        int k = lb;

        while (i < LeftPartLength && j < RightPartLength) {
            if (lArr[i] <= rArr[j]) {
                array.set(k, lArr[i]);
                i++;
            } else {
                array.set(k, rArr[j]);
                j++;
            }
            k++;
        }

        for (int remainingElements = i; remainingElements < LeftPartLength; remainingElements++, k++) {
            array.set(k, lArr[remainingElements]);
        }

        for (int remainingElements = j; remainingElements < RightPartLength; remainingElements++, k++) {
            array.set(k, rArr[remainingElements]);
        }
    }

    public void mergeSort(ArrayList<Integer> array, int lb, int rb) {
        if (lb < rb) {
            int mid = (lb + (rb - 1)) / 2;

            mergeSort(array, lb, mid);
            mergeSort(array, mid + 1, rb);
            merge(array, lb, mid, rb);

        }
    }

    public void displayArray(ArrayList<Integer> array) {
        for (int elem : array) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }


}

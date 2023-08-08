import java.util.ArrayList;

public class MergeSortString  {
    public void merge(ArrayList<String> array, int lb, int mid, int rb) {
        int LeftPartLength = (mid - lb) + 1;
        int RightPartLength = (rb - mid);

        String[] lArr = new String[LeftPartLength];
        String[] rArr = new String[RightPartLength];

        for (int i = 0; i < LeftPartLength; i++) {
            lArr[i] = array.get(lb + i);
        }

        for (int j = 0; j < RightPartLength; j++) {
            rArr[j] = array.get(mid + j + 1);
        }

        int i = 0, j = 0;
        int k = lb;

        while (i < LeftPartLength && j < RightPartLength) {
            if (lArr[i].length() <= rArr[j].length()) {
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

    public void mergeSort(ArrayList<String> array, int lb, int rb) {
        if (lb < rb) {
            int mid = (lb + (rb - 1)) / 2;

            mergeSort(array, lb, mid);
            mergeSort(array, mid + 1, rb);
            merge(array, lb, mid, rb);

        }
    }

    public void displayArray(ArrayList<String> array) {
        for (String elem : array) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");
    }
}

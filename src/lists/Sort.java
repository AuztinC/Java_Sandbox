package lists;

public class Sort {

    public static void BubbleSort(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int larger = list.get(j);
                    int smaller = list.get(j + 1);
                    list.remove(j + 1);
                    list.remove(j);
                    list.add(smaller, j);
                    list.add(larger, j + 1);
                }
            }
        }
    }

    public static void merge(List leftList, List rightList, List list) {
//        look at same index of each sub array, compare
//        at next list index, insert smaller value followed by larger.
        int leftIdx = 0;
        int rightIdx = 0;
        int mergedIdx = 0;
        while (leftIdx < leftList.size() || rightIdx < rightList.size()) {
            if (leftIdx >= leftList.size()) {
                list.remove(mergedIdx);
                list.add(rightList.get(rightIdx), mergedIdx);
                rightIdx++;
            } else if (rightIdx >= rightList.size()) {
                list.remove(mergedIdx);
                list.add(leftList.get(leftIdx), mergedIdx);
                leftIdx++;
            } else if (leftList.get(leftIdx) < rightList.get(rightIdx)) {
                list.remove(mergedIdx);
                list.add(leftList.get(leftIdx), mergedIdx);
                leftIdx++;
            } else {
                list.remove(mergedIdx);
                list.add(rightList.get(rightIdx), mergedIdx);
                rightIdx++;
            }
            mergedIdx++;
        }
    }

    public static void mergeSort(List list) {
        if (list.size() <= 1) return;

        int middle = list.size() / 2;
        List left = list.createList();
        List right = list.createList();
        for (int i = 0; i < list.size(); i++) {
            if (i < middle)
                left.add(list.get(i));
            else
                right.add(list.get(i));
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, list);
    }

    public static void quickSort(List list, int start, int end) {

        if (end <= start) return;
        int pivot = partition(list, start, end);
        quickSort(list, start, pivot - 1);
        quickSort(list, pivot + 1, end);
    }

    public static int partition(List list, int start, int end) {
        int pivot = list.get(end);
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (list.get(j) <= pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);

//                int tempi = list.get(i);
//                int tempj = list.get(j);
//                list.remove(i);
//                list.add(tempj, i);
//                list.remove(j);
//                list.add(tempi, j);
            }
        }
        i++;
        int temp = list.get(i);
        list.set(i, list.get(end));
        list.set(end, temp);

//        int tempi = list.get(i);
//        int tempj = list.get(end);
//        list.remove(i);
//        list.add(tempj, i);
//        list.remove(end);
//        list.add(tempi, end);
        return i;
    }
}

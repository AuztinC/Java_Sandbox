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

    public static void Merge(List leftList, List rightList, List list) {
//        look at same index of each sub array, compare
//        at next list index, insert smaller value followed by larger.
        int listIdx = 0;
        for (int i = 0; i < Math.max(leftList.size(), rightList.size()); i++) {
            if(leftList.get(i) < rightList.get(i)) {
                list.remove(listIdx);
                list.remove(listIdx+1);
                list.add(leftList.get(i), listIdx);
                list.add(rightList.get(i), listIdx+1);
            } else {
                list.remove(listIdx);
                list.remove(listIdx+1);
                list.add(rightList.get(i), listIdx);
                list.add(leftList.get(i), listIdx+1);
            }
            listIdx+=2;
        }
    }

    public static void MergeSort(List list) {
        if (list.size() >= 1) return;

        int middle = list.size() / 2;
        List left = list.createList();
        List right = list.createList();
        for (int i = 0; i < list.size(); i++) {
            if (i < middle)
                left.add(list.get(i));
            right.add(list.get(i));
        }
        MergeSort(left);
        MergeSort(right);
        Merge(left, right, list);
    }
}

package lists;

import org.junit.Test;

public class SortLinkedListTest extends SortTest {
    @Override
    protected List createList() {
        return new LinkedList();
    }

    @Test
    public void bubbleSortBig0ofN() {
        for (int i = 0; i < 1000; i++) {
            int rand = (int) (Math.random() * 1000);
            list.add(rand);
        }

        long start = System.nanoTime();
        Sort.BubbleSort(list);
        long after = System.nanoTime();
        System.out.println(after - start);
    }

    @Test
    public void margeSortBig0ofN() {
        for (int i = 0; i < 1000; i++) {
            int rand = (int) (Math.random() * 1000);
            list.add(rand);
        }

        long start = System.nanoTime();
        Sort.mergeSort(list);
        long after = System.nanoTime();
        System.out.println(after - start);
    }

    @Test
    public void quickSortBig0ofN() {
        for (int i = 0; i < 1000; i++) {
            int rand = (int) (Math.random() * 1000);
            list.add(rand);
        }

        long start = System.nanoTime();
        Sort.quickSort(list, 0, list.size()-1);
        long after = System.nanoTime();
        System.out.println(after - start);
    }
}

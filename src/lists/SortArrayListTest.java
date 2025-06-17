package lists;

import org.junit.Test;

public class SortArrayListTest extends SortTest {
    @Override
    protected List createList() {
        return new ArrayList();
    }

    @Test
    public void bubbleSortTimer() {
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
    public void margeSortTimer() {
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
    public void quickSortTimer() {
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

package lists;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class SortTest {

    protected List list;

    protected abstract List createList();

    @Before
    public void setup() {
        list = createList();
    }

    @Test
    public void bubbleSortTwoElements() throws Exception {
        list.add(2);
        list.add(1);
        Sort.BubbleSort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void bubbleSortThreeElementsReversed() {
        list.add(3);
        list.add(2);
        list.add(1);
        Sort.BubbleSort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void bubbleSortPreservesSortedOrder() {
        list.add(1);
        list.add(2);
        list.add(3);
        Sort.BubbleSort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void bubbleSortHandlesDuplicates() {
        list.add(2);
        list.add(1);
        list.add(2);
        Sort.BubbleSort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    public void bubbleSort100RandomElements() throws Exception {
        for (int i = 0; i < 100; i++) {
            int randomInt = (int) (Math.random() * 100);
            list.add(randomInt, 0);
        }
        Sort.BubbleSort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Ignore
    @Test
    public void mergeHandlesTwoElements() throws Exception {
        list.add(2);
        list.add(1);
        Sort.MergeSort(list);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Ignore
    @Test
    public void bubbleSort10000RandomElements() throws Exception {
        for (int i = 0; i < 10000; i++) {
            int randomInt = (int) (Math.random() * 10000);
            list.add(randomInt, 0);
        }
        Sort.BubbleSort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}

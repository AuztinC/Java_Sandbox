package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LinkedListTest extends ListTest {

    @Override
    protected List createList() {
        return new LinkedList();
    }

    @Test
    public void hasSizeOneAfterAdd() {
        list.add(10);
        assertEquals(1, list.size());
    }

    @Test
    public void retrievesAddedElement() throws Exception {
        list.add(1);
        assertEquals(1, list.get(0));
    }

    @Test
    public void throwsWhenIndexTooHigh() throws Exception{
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void getReturnsSecondAddedElement() throws Exception{
        list.add(10);
        list.add(20);
        assertEquals(20, list.get(1));
    }

    @Test
    public void retrievesCorrectElementAfterMultipleAdds() {
        list.add(5);
        list.add(15);
        list.add(25);
        assertEquals(5, list.get(0));
        assertEquals(15, list.get(1));
        assertEquals(25, list.get(2));
    }

    @Test
    public void removeDecreasesSize() throws Exception {
        list.add(1);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removeHeadGivesEmpty() throws Exception {
        list.add(1);
        list.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.get(0));
    }

    @Test
    public void headValueChangesOnRemove() throws Exception {
        list.add(1);
        list.add(2);
        list.remove(0);
        assertEquals(2, list.get(0));
    }

    @Test
    public void removeSecondElementShiftsThirdToSecond() throws Exception{
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    public void removeLastElementDecreasesSize() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        assertEquals(2, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void multipleConsecutiveRemovesShrinkListProperly() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.remove(1); // remove 20 → [10, 30, 40]
        list.remove(1); // remove 30 → [10, 40]
        list.remove(1); // remove 40 → [10]
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void addThrowsForInvalidIndex() throws Exception {
        assertThrows(IndexOutOfBoundsException.class, () ->
                list.add(100, 1));
    }

    @Test
    public void addToFrontWithEmptyListIncreasesSize() throws Exception {
        list.add(1,0);
        assertEquals(1, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    public void addToFrontShiftsRemainingRight() throws Exception {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        list.add(0, 0);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void addToMiddleOfListKeepsOrder() throws Exception{
        list.add(10);
        list.add(30);
        list.add(20, 1);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }



    @Test
    public void add1000IntegersToEnd() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void add1000IntegersToFront() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i, 0);
        }
        assertEquals(1000, list.size());
    }

    @Test
    public void add1000IntegersToMiddle() throws Exception {
        for (int i = 0; i < 1000; i++) {
            list.add(i, list.size()/2);
        }
        assertEquals(1000, list.size());
    }
}

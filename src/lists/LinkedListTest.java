package lists;

public class LinkedListTest extends ListTest {

    @Override
    protected List createList() {
        return new LinkedList();
    }
}

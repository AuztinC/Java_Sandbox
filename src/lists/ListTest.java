package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class ListTest {

    protected List list;

    protected abstract List createList();

    @Before
    public void setup() {
        list = createList();
    }

    @Test
    public void emptyListNoElements() {
        assertEquals(0, list.size());
    }

}

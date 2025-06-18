package lists;

import org.junit.Test;

public class ArrayListTest extends ListTest{

    @Override
    protected List createList() {
        return new ArrayList();
    }

//        @Test
//    public void itemLookupBig0ofN() {
//        for (int i = 0; i < 100; i++) {
//            list.add(i);
//        }
//        list.get(0);
//
//        long start = System.nanoTime();
//        list.get(0);
//        long after = System.nanoTime();
//        System.out.println(after - start);
//        long start2 = System.nanoTime();
//        list.get(99);
//        long after2 = System.nanoTime();
//        System.out.println(after2 - start2);
//    }


}

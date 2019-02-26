package struct.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class HashTest {
    public static void main(String[] args) {

    }

    private final class HashTable {
        private Info[] infoArr;
        public HashTable(int capcity) {
            this.infoArr = new Info[capcity];
        }

        LinkedList<String> lList = new LinkedList<>();
    }


    private final class Info{
        String key;
        String value;
    }
}

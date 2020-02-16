import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args){
        Hashtable<String, String> table1 = new Hashtable<String, String>();
        table1.put("city1", "COLUMBUS");
        table1.put("city2", "WORTHINGTON");
        table1.put("city3", "WASHINGTON DC");
        table1.put("city4", "BOSTON");

        System.out.println (table1);
        System.out.println(table1.get("city4"));

        //to retrieve each key and value in the table iteratively:
        for(Map.Entry m: table1.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        //Hashmaps are not thread safe. When there are multiple threads, its better to use Hashtables over Hashmaps.
        HashMap map1 = new HashMap();
        map1.put("city1","43240");
        map1.put("city2", "43297");
        map1.put("city3", "43920");
        map1.put("city4", "43829");

        System.out.println(map1);

        Hashtable<String, String> table2 = new Hashtable<String, String>();
        table2.put("city1", "43922");
        table2.put("city2", "49329");
        table2.put("city3", "49332");
        table2.put("city4", "72893");

        Hashtable<String, Hashtable<String, String>> table = new Hashtable<String, Hashtable<String, String>>();
        table.put("city values", table1);
        table.put("zip", table2);

        System.out.println(table.get("city values").get("city2"));
        System.out.println(table.get("zip").get("city2"));
    }
}

import java.util.HashMap;
import java.util.Map;

public class countproj2 {
    public static void main(String[] args) {
        String name="My name is charu srivastava";
        int count=0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < name.length(); i++){
          char ch=name.charAt(i);
            if(map.containsKey(ch)){
                count=map.get(ch);
                count++;
                map.put(ch, count);
            }
            else {
                map.put(ch, 1);}}
        for(Character ch:map.keySet()){
            if(map.get(ch) > 0) {

                System.out.println(ch + " is present " + map.get(ch) + " times");
            }}}}

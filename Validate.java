import java.util.HashMap;
public class Validate {
    HashMap<Character ,Character> map = new HashMap<Character, Character>();
    public Validate(){
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('<', '>');
    }

    public boolean Check(String string){
        Deque<Character> list = new Deque<Character>();
        for (int i = 0; i<string.length(); i++){
            char c = string.charAt(i);
            if(map.containsKey(c)){
                list.prepend(c);
            }
            else{
                if (list.length() == 0) {
                    return false;
                }
                char lastOpen = list.popFront();
                if (map.get(lastOpen) != c) {
                    return false;
                }
            }
        }
        return list.length() == 0;
    }
}

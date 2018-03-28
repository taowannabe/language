import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class TestEnum{
    public static void main(String[] args){
        
        EnumSet<Type> weekSet = EnumSet.allOf(Type.class);
        for (Type day : weekSet) {
            System.out.println(day);
        }
 
        
        EnumMap<Type, String> weekMap = new EnumMap(Type.class);
        weekMap.put(Type.Z, "mon");
        weekMap.put(Type.X, "tus");
        
        for (Iterator<Entry<Type, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Entry<Type, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }
}

enum Type{
    Z("zz"),X("xx"),C("cc");

    private String fullName;
    private Type(String fullName){
        this.fullName = fullName;
    } 
    public static Type getByName(String name){
        for(Type t : Type.values()){
            if(t.fullName!=null&&t.fullName.equals(name)){
                
                return t;
            }
        }
        return null;
    }

}
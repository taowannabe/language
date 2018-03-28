import java.lang.reflect.Method;

public class Outer{
    private  String name="tao";
    private  String age="23";

    public static class Inner extends Outer{
        private void display(){
           System.out.println("display1");
        }
        public void display2(){
            System.out.println("display2");
        }

        protected void display3(){
            System.out.println("display3");
        }
       
    }

    

    public static void main(String[] args)throws Exception{
        Class clazz =  Outer.Inner.class;
        Inner i = (Inner)clazz.newInstance();
        Method[] ms = clazz.getMethods();
        clazz.asSubclass(clazz);
        for (Method m : ms) {
            // m.setAccessible(true);
            System.out.println(m.getName());
            // System.out.println(m.isAccessible()); 
            if("display2".equals(m.getName()))
                m.invoke(i);
        }
        
    }
}
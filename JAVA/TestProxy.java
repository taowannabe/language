import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy implements Print{
    public static void main(String[] args){
        TestProxy realprint = new TestProxy();
        Print proxyprint = (Print)Proxy.newProxyInstance(realprint.getClass().getClassLoader(), realprint.getClass().getInterfaces(), new InvocationHandler(){
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("prePrinting");
                    realprint.print();
                    System.out.println("afterPrinting");
                    return null;
                }
                
        });
        proxyprint.print();
    }

    public void print(){
        System.out.println("running realprint");
    }
}
interface Print{
    public void print();
}
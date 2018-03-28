public class Tgc{

    public String name;
    public static void main(String[] args) throws Exception{
        for(int i = 0;;i++){
            Thread.currentThread().sleep(1);
            Tgc tgc = new Tgc();
            tgc.name = ""+i;
            if(i%10000==0){

                System.out.println(i);
            }
        }
    }
}
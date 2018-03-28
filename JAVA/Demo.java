
public class Demo {
    public static void main(String[] args) throws Exception{
        final Map<String,Object> hashMap = new HashMap<>();
        int count = 100;
        Thread[] ts = new Thread[count];
        for (int i = 0 ; i < count ;i++){
            Thread t = new Thread(new Runnable(){
                @Override
                public void run() {
                    hashMap.put(hashMap.size() + "",Thread.currentThread().getName());
                    
                }
            });
            ts[i] = t;
            t.start();
        }
        for (Thread t : ts) {
            t.join();
        } 
        String[] ss = new String[count];
        int index = 0;
        for (String key : hashMap.keySet()) {
            ss[index++] =  key + " : "+hashMap.get(key);
        }
        for(int i = 0 ; i < hashMap.size() ; i++){
            for(int j = i ; j < hashMap.size() ; j++){
                if(ss[i].compareTo(ss[j]) > 0){
                    String temp = ss[i];
                    ss[i] = ss[j];
                    ss[j] = temp;
                }
            }
            System.out.println(ss[i]);
        }
        
    }
}
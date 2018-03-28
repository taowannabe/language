import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class StringDemo{
    public  static void main(String[] args) throws Exception{
        long cur = new Date().getTime();
        for(long i = 0 ;i<10000000000L;i++){

        }
        System.out.println(new Date().getTime()-cur);
        
    }
}
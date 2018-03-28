import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpC{

    public static  void main(String[] args){
        String url="http://127.0.0.1/aic/serviceMgmtAction!findPagenation.action";
        String param = null;

        System.out.println(sendGet(url, param));
    }
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = param != null? url + "?" + param : url;
//            urlNameString = URLEncoder.encode(urlNameString, "UTF-8");
            URL realUrl = new URL(urlNameString);
            // 
            URLConnection connection = realUrl.openConnection();
            // 
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 
            connection.connect();
            // 
            Map<String, List<String>> map = connection.getHeaderFields();
            // 
            for (String key : map.keySet()) {
            	
            }
            // 
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
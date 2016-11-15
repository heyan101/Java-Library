package demon.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * HTTP 请求类
 * 
 * @author Demon
 */
public class HttpClient {
	
	/**
	 * 调用 GET方式获取数据
	 * @param url "http://ip:port"
	 * @param param "?param1=XXX&param2=XXX"
	 * @param charset 编码
	 * @return
	 */
	public static String doGet(String url, String param, String charset) {
		String result = ""; 
		BufferedReader in = null;
		try {
			URLConnection conn = new URL(url + param).openConnection();
			// 设置通用的请求属性 
			conn.setRequestProperty("accept", "*/*");  
			conn.setRequestProperty("connection", "Keep-Alive");  
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.connect();
			// 定义 BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += line;  
            } 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {  
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



























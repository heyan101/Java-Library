package demon.systeminfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Linux {
    /** 
     * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等. 
     */  
    public static String getOSName() {  
        return System.getProperty("os.name").toLowerCase();  
    }  
  
    /** 
     * 获取linux网卡的mac地址. 非windows的系统默认调用本方法获取. 
     * 如果有特殊系统请继续扩充新的取mac地址方法. 
     *  
     * @return mac地址 
     */  
    public static String getLinuxMACAddress() {  
        String mac = null;  
        BufferedReader bufferedReader = null;  
        Process process = null;  
        try {  
            // linux下的命令，一般取eth0作为本地主网卡  
            process = Runtime.getRuntime().exec("ifconfig eth0");  
            // 显示信息中包含有mac地址信息  
            bufferedReader = new BufferedReader(new InputStreamReader(  
                    process.getInputStream()));  
            String line = null;  
            int index = -1;  
            while ((line = bufferedReader.readLine()) != null) {  
                // 寻找标示字符串[hwaddr]  
                index = line.toLowerCase().indexOf("hwaddr");  
                if (index >= 0) {// 找到了  
                    // 取出mac地址并去除2边空格  
                    mac = line.substring(index + "hwaddr".length() + 1).trim();  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
            bufferedReader = null;  
            process = null;  
        }  
        return mac;  
    }  
 
    /**
     * 获取Linux的 CPU ID
     * @return
     */
    public static String getLinuxCPUID() {
        String cpuId = null;
        BufferedReader bufferedReader = null;  
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("dmidecode -t 4 | grep ID");
            bufferedReader = new BufferedReader(new InputStreamReader(  
                    process.getInputStream()));
            String line = null;  
            int index = -1;  
            while ((line = bufferedReader.readLine()) != null) {  
                index = line.toLowerCase().indexOf("id:");  
                if (index >= 0) {
                    cpuId = line.substring(index + "id:".length() + 1).trim();  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
            bufferedReader = null;  
            process = null;  
        } 
        
        return cpuId;
    }
    
    /**
     * 获得Linux下主板 ID
     * @return
     */
    public static String getLinuxBIOSID() {
        String biosId = null;
        BufferedReader bufferedReader = null;  
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("dmidecode | more");
            bufferedReader = new BufferedReader(new InputStreamReader(  
                    process.getInputStream()));
            String line = null;  
            int index = -1;  
            while ((line = bufferedReader.readLine()) != null) {  
                index = line.toLowerCase().indexOf("uuid:");  
                if (index >= 0) {
                    biosId = line.substring(index + "uuid:".length() + 1).trim();  
                    break;  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
            } catch (IOException e1) {  
                e1.printStackTrace();  
            }  
            bufferedReader = null;  
            process = null;  
        } 
        return biosId;
    }
    
    /** 
     * 测试用的main方法. 
     *  
     * @param argc 运行参数. 
     * @throws Exception 
     */  
    public static void main(String[] argc) throws Exception {  
        String os = getOSName();  
        System.out.println(os);  
        String mac = getLinuxMACAddress();  
        System.out.println(mac);  
    }
}

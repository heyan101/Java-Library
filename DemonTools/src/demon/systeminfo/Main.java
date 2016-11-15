package demon.systeminfo;

import demon.base64.Base64;

public class Main {

    public static void main(String[] args) {
        String uuid = null;
        
        String os = Linux.getOSName();  
        System.out.println(os);  
        if (os.equals("windows 7")) {  
            String macWindows = Windows.getWindowsMAC();
            String cpuWindows = Windows.getWindowsCPUID();
            String biosWindows = Windows.getWindowsBIOSID();

            uuid = Base64.getBase64(macWindows + cpuWindows + biosWindows);
            System.out.println(uuid);
        } else {  
            // 本地是非windows系统 一般就是linux  
            String macLinux = Linux.getLinuxMACAddress();   
            String cpuLinux = Linux.getLinuxCPUID();
            String biosLinux = Linux.getLinuxBIOSID();
            
            uuid = Base64.getBase64(macLinux + cpuLinux + biosLinux);
            System.out.println(uuid);
        }
    }
}


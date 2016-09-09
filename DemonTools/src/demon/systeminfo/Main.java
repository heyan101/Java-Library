package demon.systeminfo;


public class Main {

    public static void main(String[] args) {
        String uuid = null;
        
        String os = Linux.getOSName();  
        System.out.println(os);  
        if (os.equals("windows 7")) {  
            String macWindows = Windows.getWindowsMAC();
            String cpuWindows = Windows.getWindowsCPUID();
            String biosWindows = Windows.getWindowsBIOSID();

            uuid = MyBASE64.getBASE64(macWindows + cpuWindows + biosWindows);
            System.out.println(uuid);
        } else {  
            // 本地是非windows系统 一般就是linux  
            String macLinux = Linux.getLinuxMACAddress();   
            String cpuLinux = Linux.getLinuxCPUID();
            String biosLinux = Linux.getLinuxBIOSID();
            
            uuid = MyBASE64.getBASE64(macLinux + cpuLinux + biosLinux);
            System.out.println(uuid);
        }
        
//        File file = Main.createFile();
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream(file);
//            out.write(("UUID : " + uuid).getBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
    
//    public static File createFile() {
//        File file = null;
//        File directory = new File(".");
//        String currentPath = null;
//        try {
//            currentPath = directory.getCanonicalPath();//获取当前路径
//            file = new File(currentPath + "\\systemInfomation.txt");
//            if(!file.exists())
//                if(!file.createNewFile())
//                    throw new Exception("文件不存在，创建失败！");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return file;
//    }
}


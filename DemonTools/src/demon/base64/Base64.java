package demon.base64;

import sun.misc.BASE64Decoder;

public class Base64 {
    static String data = "3C-46-D8-93-B0-A5BFEBFBFF000306C3M80-58026601461";
    static String key = "AF6K9HN7B";
    
    /**
     *  BASE64 encode 
     * @param s
     * @return encoded value
     */
    public static String getBase64(String s) { 
        if (s == null) return null; 
        return (new sun.misc.BASE64Encoder()).encode( s.getBytes() ); 
    } 

    /**
     *  BASE64 decode
     * @param s
     * @return decoded value
     */
    public static String getFromBASE64(String s) { 
        if (s == null) return null; 
        BASE64Decoder decoder = new BASE64Decoder(); 
        try { 
            byte[] b = decoder.decodeBuffer(s); 
            return new String(b); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return null; 
    } 
    
//    public static void main(String[] args) {
//        try {
//            String s = getBASE64(data);
//            System.out.println(s);
//            System.out.println(getFromBASE64(s));
//            
//            String str = "K70K1JVGzhfAScieHthQABTeAZDcmF2Yz0RU0FyFD5yHC4PFClEMQxRBw0FFzUBGnEXGWIlAQMxFxMiWykPZBkDJhcFHQd-CAVMJxY2LQ0EJQQuDH9BDDsbOR40aRtqGlExITsiNVIKUngPSndga3diRwdUfgZDPz7A4HIAAAAA";
//            System.out.println(str.length());
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//    }
}

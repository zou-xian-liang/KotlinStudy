import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Md5Test {
    public static void main(String[] args) throws Exception {
        String str = "appId=2&cpOrderId=143920191010164741280478743&ext=143920191010164741280478743&memId=104886&orderId=198795127506&orderStatus=2&payTime=2019-10-10+04%3a47%3a42&productId=default&productName=%e5%8b%be%e7%8e%89&productPrice=1&appKey=T2N08V6V2N0NF02N4JHTZXZHJ0ZDV440";
        Map<String, String> params = new LinkedHashMap<>();

        params.put("appId", "1");
        params.put("cpOrderId", "2019082122001493340525189370");
        params.put("ext", "%e7%a9%bf%e9%80%8f");//URLencodeing
        params.put("memId", "3579");
        params.put("orderId", "198376152001");
        params.put("orderStatus", "2");
        params.put("payTime", "2019-08-24+16%3a36%3a49");//URLencodeing
        params.put("productId", "1");//URLencodeing
        params.put("productName", "%e5%85%83%e5%ae%9d");//URLencodeing
        params.put("productPrice", "1.0");//URLencodeing
        params.put("appKey", "ZL0TF24J8HP6D84THL4D2F868L64J84T");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            stringBuilder.append(s).append("=").append(params.get(s)).append("&");
        }
        String after = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(after);
        String md5 = Md5(after);
//        System.out.println(md5);
//        System.out.println(Md5(str));
        System.out.println(URLEncoder.encode("2019-08-24 16:36:49","utf-8").toLowerCase());

    }


    private static String Md5(String str) throws Exception{
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }
}

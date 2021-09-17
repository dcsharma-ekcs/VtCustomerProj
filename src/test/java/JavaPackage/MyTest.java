package JavaPackage;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class MyTest {

    public static void main(String[] args) {

    String myStr = " Billing Address\n" +
            "To Shipping Address : 0.00 km\n" +
            "To Ip Address : 11040.42 km";

        String srtBtoS = getBillingToShippingDistanceKM(myStr);
        System.out.println("BillingToShippingDistance: "+srtBtoS);
        String srtBtoIp = getBillingToIPDistanceKM(myStr);
        System.out.println("BillingToIPDistance: "+srtBtoIp);
    }


    public static String getBillingToShippingDistanceKM(String myStr){
        String srtResult = null;
        String[] srtArray = myStr.split("km");
        try {
            String str1 = srtArray[0].substring(srtArray[0].indexOf(":")+1, srtArray[0].length());
            srtResult = str1.trim();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
        return srtResult;
    }

    public static String getBillingToIPDistanceKM(String myStr){
        String srtResult = null;
        String[] srtArray = myStr.split("km");
        try {
            String str1 = srtArray[1].substring(srtArray[1].indexOf(":")+1, srtArray[1].length());
            srtResult = str1.trim();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
        }
        return srtResult;
    }

}

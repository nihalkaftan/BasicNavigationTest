package java.com.cbt.utilities;

public class StringUtility {
    public static String verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("expected result: "+expected);
            System.out.println("actual result: "+actual);
            return "PASS";
        }else{
            System.out.println("expected result: "+expected);
            System.out.println("actual result: "+actual);
            return "FAIL";
        }
    }
}

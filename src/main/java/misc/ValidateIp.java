package misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateIp{

    @Test
    public void test(){
//        Assertions.assertEquals("IPv4",validIPAddress("172.16.254.1"));
//        Assertions.assertEquals("IPv6",validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        Assertions.assertEquals("Neither",validIPAddress("200z:0db8:85a3:0:0:8A2E:0370:7334"));
//        Assertions.assertEquals("Neither",validIPAddress("256.256.256.256"));
//        Assertions.assertEquals("Neither",validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
//        Assertions.assertEquals("Neither",validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334"));
        Assertions.assertEquals("Neither",validIPAddress("1.0.1."));
        Assertions.assertEquals("IPv4",validIPAddress("192.0.0.1"));
    }

    public String validIPAddress(String ip) {
        Scanner sc = new Scanner(ip);
        String type;
        if(ip.contains(".")){
            sc.useDelimiter("\\.");
            type="IPv4";
            if(ip.split("\\.",-1).length != 4 ||
            ip.split("\\.").length!=4) return "Neither";

        }
        else {
            sc.useDelimiter(":");
            type="IPv6";
            if(ip.split(":",-1).length !=8) return "Neither";

        }
        while(sc.hasNext()){
            String s = sc.next();
            if(type.equals("IPv4")){
                try {
                    if (!(Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 256))
                        return "Neither";
                    if ( s.length() - String.valueOf(Integer.parseInt(s)).length() > 0) return "Neither";
                }
                catch (NumberFormatException e){
                    return "Neither";
                }
            }
            if(type.equals("IPv6")){
                try{
                    if(((s == null)
                            || (s.equals(""))
                            || (!s.matches("^[a-zA-Z0-9]*$"))) ) return "Neither";
                    Long.parseLong(s,16);
                    if ( s.length() > 4) return "Neither";

                }
                catch (NumberFormatException e){
                    return "Neither";
                }
            }
        }
        return type;
    }
}

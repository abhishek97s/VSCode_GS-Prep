package medium;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;

public class ApacheLog {

  /**
   * Given a log file, return IP address(es) which accesses the site most often.
   */

  public static boolean isValidIp(String num) {
    String[] parts = num.split("[.]");
    if (parts.length != 4)
      return false;
    for (String s : parts) {
      try {
        int ip = Integer.parseInt(s);
        if (ip < 0 || ip > 255)
          return false;
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }

  public static String findTopIpaddress(String[] lines) {
    //Null-n-Empty check
    if(lines==null || lines.length<1)  return "";
    
    Map<String, Integer> logCount= new HashMap<>();
    
    //Store each log and its count into logCount
    for(String log: lines){
      if(log== null || log.length()<1)  continue;
      String[] arr= log.split(" ");
      
      if(isValidIp(arr[0]))
        logCount.put(arr[0], logCount.getOrDefault(arr[0], 0)+1); 
    }
    
    //Find the maxEntry which is present in the logCount
    Optional<Entry<String, Integer>> maxEntry= logCount.entrySet().stream()
                            .max((e1, e2) -> e1.getValue()-e2.getValue());
                              
    //If maxEntry is present, return it. or return empty string.
    if(maxEntry.isPresent()){
      String result= logCount.entrySet().stream()
                      .filter(e -> e.getValue()== maxEntry.get().getValue())
                      .map(a -> a.getKey())
                      .collect(Collectors.joining(","));
    
    System.out.println(result);
    return result;
    }
    else  return "";
  } 

  public static boolean pass() {

    String lines[] = new String[] { "10.0.0.1 - log entry 1 11",
        "10.0.0.1 - log entry 2 213",
        "10.0.0.2 - log entry 133132",
    };
    String lines0[] = null;
    String lines1[] = new String[] {};

    String lines2[] = new String[] { "", null };

    String lines3[] = new String[] { "10.0.0.1 - log entry 1 11",
        "10.0.0.1 - log entry 2 213",
        "10.0.0.2 - log entry 133132",
        "10.0.0.2 - log entry 12390",
        "10.0.0.3 - log entry 12380" };
    String lines4[] = new String[] { "10.0.0.1 - log entry 1 11",
        "10.0.0.1 - log entry 2 213",
        "10.0.0.2 - log entry 133131",
        "10.0.0.2 - log entry 133132",
        "10.0.0.2 - log entry 133133",
        "10.3.22.563 -entry",
        "10.3.22.563 -entry",
        "10.3.22.563 -entry",
    };
    String lines5[] = new String[] { "10.0.0.1 - log entry 1 11",
        "10.0.0.5 - log entry 2 213",
        "10.0.0.5 - log entry 133132",
        "10.0.0.5 - log entry 12390",
        "10.0.0.1 - log entry 12380",
        "10.db.22.563 -log entry 1290",
        "abababababab",
        "abababababab",
        "abababababab",
        "abababababab",
        " - 12345778", "" };
    boolean pass = true;
    pass = pass & findTopIpaddress(lines).equals("10.0.0.1");
    pass = pass & findTopIpaddress(lines0).equals("");
    pass = pass & findTopIpaddress(lines1).equals("");
    pass = pass & findTopIpaddress(lines2).equals("");
    pass = pass & findTopIpaddress(lines3).equals("10.0.0.2,10.0.0.1");
    pass = pass & findTopIpaddress(lines4).equals("10.0.0.2");
    pass = pass & findTopIpaddress(lines5).equals("10.0.0.5");
    return pass;
  }

  public static void main(String[] args) {

    if (pass()) {
      System.out.println("Pass");
    } else {
      System.out.println("Some Fail");
    }
  }
}

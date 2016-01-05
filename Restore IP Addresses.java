public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */

    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        if (s == null) {
            return null;
        }
        ArrayList<String> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        restoreIpAddressCore(s, 0, resultList, sb, 0);
        return resultList;
    }
    
    private void restoreIpAddressCore(String s, int index, List<String> resultList, StringBuilder sb, int count) {
        if (index > s.length() || count > 4) {
            return ;
        }
        if (index == s.length() && count == 4) {
            
            String result = sb.toString();
            resultList.add(result.substring(0, result.length() - 1));
        }
        
        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            String rawIp = trimString(subString);
            if (rawIp == null || rawIp.length() > 3 || (rawIp.length() == 3 && rawIp.compareTo("255") > 0)) {
                break;
            }
            sb.append(rawIp);
            sb.append('.');
            // System.out.println(sb);
            restoreIpAddressCore(s, i + 1, resultList, sb, count + 1);
            sb.setLength(sb.length() - rawIp.length() - 1);
        }
    }

    private String trimString(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') {
            return null;
        }
        else {
            return str;
        }
    }
}

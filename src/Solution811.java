import java.util.*;

public class Solution811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] part = str.split(" ");
            int count = Integer.parseInt(part[0]);
            String[] domains = part[1].split("\\.");
            int length = part[1].length(), index = 0;
            while (index >= 0) {
                String domain = part[1].substring(index == 0 ? index : index + 1, length);
                map.put(domain, map.getOrDefault(domain, 0) + count);
                index++;
                index = part[1].indexOf('.', index);
            }
        }
        List<String> ans = new ArrayList<>(map.size());
        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            builder.append(map.get(key));
            builder.append(' ');
            builder.append(key);
            ans.add(builder.toString());
            builder.setLength(0);
        }
        return ans;
    }

}

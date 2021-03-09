import java.util.*;

public class Solutiion1598 {

    public int minOperationsStack(String[] logs) {
        Stack<String> sta = new Stack<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("./")) {
                continue;
            } else if (logs[i].equals(("../"))) {
                if (!sta.isEmpty()) sta.pop();
            } else {
                sta.push(logs[i]);
            }
        }
        return sta.size();
    }

    public int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("./")) {
                continue;
            } else if (logs[i].equals(("../"))) {
                if (count > 0) count--;
            } else {
                count++;
            }
        }
        return count;
    }



}

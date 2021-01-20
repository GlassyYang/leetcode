import java.util.*;

public class OfferSolution05 {

    public String replaceSpace(String s) {
        if (s == null) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

}

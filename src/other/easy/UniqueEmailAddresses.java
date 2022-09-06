package other.easy;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '+') {
                    sb.append(email.substring(email.indexOf("@", i), email.length()));
                    break;
                } else if (c == '@') {
                    sb.append(email.substring(i, email.length()));
                    break;
                } else if (c == '.')
                    continue;
                else
                    sb.append(c);
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}
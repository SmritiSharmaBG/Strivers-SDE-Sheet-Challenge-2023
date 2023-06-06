import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>();
     //   boolean[] vis = new boolean[s.length()];
     //   rec1(ans, s, "", vis, s.length());
      rec2(ans, s, s.length(), 0);
        return ans;
    }

    // EFFICIENT APPROACH

    private static void rec2(List<String> ans, String s, int n, int index) {
        if (index >= n) {
            ans.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            s = swap(s, i, index);
            rec2(ans, s, n, index + 1);
            s = swap(s, i, index);
        }
    }

    private static String swap(String s, int i, int index) {
        char c1 = s.charAt(index);
        char c2 = s.charAt(i);

        String str = "";
        for (int j = 0; j < s.length(); j ++) {
            if (j == index) str = str + c2;
            else if (j == i) str = str + c1;
            else str = str + s.charAt(j);
        }
        return str;
    }

  // USES EXRTA SPACE FOR BOOLEAN VIS ARRAY
    private static void rec1(List<String> ans, String s, String str, boolean[] vis, int n) {
        if (str.length() >= n) {
            ans.add(str);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            // the char has not been taken up yet
            if (!vis[i]) {
                char ch = s.charAt(i);
                vis[i] = true;
                rec1(ans, s, str + ch, vis, n);
                vis[i] = false;
            }
        }
    }
}

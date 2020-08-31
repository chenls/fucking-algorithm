
public class MinDistance {

    public static int min(int a, int b, int c) {
        int t = a < b ? a : b;
        return t < c ? t : c;
    }

    static class Node {
        int val;
        int choice;
    }

    public static void dump(Node[][] dp, int i, int j) {
        int choice = dp[i][j].choice;
        String x = "";
        switch (choice) {
            case 0:
                i--;
                j--;
                x = "啥都不做";
                break;
            case 1:
                j--;
                x = "插入";
                break;
            case 2:
                i--;
                x = "删除";
                break;
            case 3:
                i--;
                j--;
                x = "替换";
                break;
        }
        System.err.println("minDistance choice = " + x);
        if (i <= 0 && j <= 0) {
            return;
        } else {
            dump(dp, i, j);
        }
        return;
    }

    public static int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        Node[][] dp = new Node[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = new Node();
                dp[i][j].choice = -1;
            }
        }
        // base case
        for (int i = 1; i <= m; i++) { // 删除
            dp[i][0].val = i;
            dp[i][0].choice = 2;
        }
        for (int j = 1; j <= n; j++) { // 插入
            dp[0][j].val = j;
            dp[0][j].choice = 1;
        }

        // 自底向上求解
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j].val = dp[i - 1][j - 1].val;
                    dp[i][j].choice = 0;
                } else {
                    // 0 代表啥都不做
                    // 1 代表插入
                    // 2 代表删除
                    // 3 代表替换
                    dp[i][j].val = min(dp[i - 1][j].val + 1, dp[i][j - 1].val + 1, dp[i - 1][j - 1].val + 1);

                    if (dp[i][j].val == dp[i - 1][j].val + 1)
                        dp[i][j].choice = 2;
                    else if (dp[i][j].val == dp[i][j - 1].val + 1)
                        dp[i][j].choice = 1;
                    else if (dp[i][j].val == dp[i - 1][j - 1].val + 1)
                        dp[i][j].choice = 3;
                }

        // 储存着整个 s1 和 s2 的最小编辑距离
        dump(dp, m, n);
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                System.err.println("p[" + i + "][n].choice = " + dp[i][j].choice);
        return dp[m][n].val;
    }

    public static void main(String args[]) {
        String s1 = "rad";
        String s2 = "apple";
        int res = minDistance(s1, s2);
        System.err.println("minDistance res = " + res);
    }
}

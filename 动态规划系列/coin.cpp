#include <vector>
#include <cstdio>

using namespace std;

int coinChange(vector<int>& coins, int amount) {
    // 数组大小为 amount + 1，初始值也为 amount + 1
    vector<int> dp(amount + 1, amount + 1);
    // base case
    dp[0] = 0;
    for (int i = 0; i < dp.size(); i++) {
        // 内层 for 在求所有子问题 + 1 的最小值
        for (int coin : coins) {
            // 子问题无解，跳过
            if (i - coin < 0) continue;
            dp[i] = min(dp[i], 1 + dp[i - coin]);
        }
    }
    return (dp[amount] == amount + 1) ? -1 : dp[amount];
}


int main(int argc, char const *argv[])
{
    vector<int> coins(3, 0);
    coins[0] = 2;
    coins[1] = 4;
    coins[2] = 5;

    int ret = coinChange(coins, 11);
    printf("coinChange(11) = %d\n", ret);
    return 0;
}

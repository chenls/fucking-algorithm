#include <vector>
#include <cstdio>

using namespace std;

int helper(vector<int> &memo, int n)
{
    // base case
    if (n == 1 || n == 2)
        return 1;
    // 已经计算过
    if (memo[n] != 0)
        return memo[n];
    memo[n] = helper(memo, n - 1) +
              helper(memo, n - 2);
    return memo[n];
}

int fib(int N)
{
    if (N < 1)
        return 0;
    // 备忘录全初始化为 0
    vector<int> memo(N + 1, 0);
    // 初始化最简情况
    return helper(memo, N);
}

int fib2(int N)
{
    vector<int> dp(N + 1, 0);
    // base case
    dp[1] = dp[2] = 1;
    for (int i = 3; i <= N; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
    return dp[N];
}

int fib3(int N)
{
    int a = 1;
    int b = 1;
    for (int i = 3; i <= N; i++)
    {
        int sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}

int main(int argc, char const *argv[])
{
    int ret = fib3(20);
    printf("fib(20) = %d\n", ret);
    return 0;
}

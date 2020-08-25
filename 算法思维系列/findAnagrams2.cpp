#include <string>
#include <iostream>
#include <climits>
#include <unordered_map>

using namespace std;

int minWindow(string s)
{
    int right = 0;
    int max_value = 0;
    unordered_map<char, int> window;

    int match = 0;

    while (right < s.size())
    {
        char c1 = s[right];
        window[c1]++;
        if (window[c1] > 1)
            match++;

        right++;

        if (match > 1)
        {
            window.clear();
            window[c1]++;
            match = 0;
            max_value = max(max_value, (int)(window.size() - 1));
        }
        else
        {
            max_value = max(max_value, (int)(window.size()));
        }
    }
    return max_value;
}

int main(int argc, char const *argv[])
{
    string s = "wqre";
    int ret = minWindow(s);
    std::cout << ret << "\n";
    return 0;
}

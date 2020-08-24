#include <string>
#include <iostream>
#include <climits>
#include <unordered_map>
#include <vector>

using namespace std;

vector<int> minWindow(string s, string t)
{
    vector<int> res;
    int left = 0, right = 0;


    unordered_map<char, int> window;
    unordered_map<char, int> needs;
    for (char c : t)
        needs[c]++;

    int match = 0;

    while (right < s.size())
    {
        char c1 = s[right];
        if (needs.count(c1))
        {
            window[c1]++;
            if (window[c1] == needs[c1])
                match++;
        }
        
        right++;

        while (match == needs.size())
        {
            // 如果 window 的大小合适
            // 就把起始索引 left 加入结果
            if (right - left == t.size()) {
                res.push_back(left);
            }

            char c2 = s[left];
            if (needs.count(c2))
            {
                window[c2]--;
                if (window[c2] < needs[c2])
                    match--;
            }
            left++;
        }
    }
    return res;
}

int main(int argc, char const *argv[])
{
    string s = "abacscaabc";
    string t = "abc";
    vector<int> arrays = minWindow(s, t);
    for (auto &arr : arrays)
    {
        std::cout << arr;
        std::cout << "\n";
    }
    return 0;
}


public class TowNumSum { 

    public static class Res{
        int left;
        int right;
    }

    public static Res binarySearch(int nums[], int target)
    {
        Res res = new Res();
        for(int i = 0; i < nums.length; i++){
            int left = 0;
            int right = nums.length - 1; 

            while (left <= right)
            {
                int mid = left + (right - left) / 2;
                if (nums[mid] + nums[i] < target)
                    // 搜索区间变为 [mid+1, right]
                    left = mid + 1; 
                else if (nums[mid] + nums[i] > target)
                    // 搜索区间变为 [left, mid-1]
                    right = mid - 1; 
                else if (nums[mid] + nums[i] == target)
                {
                    if(mid == i){
                        break;
                    }
                    // 收缩右侧边界
                    res.left = i + 1;
                    res.right = mid + 1;
                    return res;
                }
            }
        }
        res.left = -1;
        res.right = -1;
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            }
        }
        return new int[]{-1, -1};
    }

    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // swap(nums[left], nums[right])
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }

    public static void main(String args[]) { 
        int nums[] ={1, 3, 7, 9, 14};
        int t = 12;
        Res res= binarySearch(nums, t);
        System.err.println("res left = " + res.left + ", right = " + res.right);

        int ret[] = twoSum(nums, t);
        System.err.println("ret left = " + ret[0] + ", right = " + ret[1]);

        reverse(nums);
        for(int i = 0; i < nums.length; i++) {
            System.err.println("reverse nums["+ i + "] = " + nums[i]);
        }
    } 
}
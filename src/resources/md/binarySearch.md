# 二分查找

## 二分查找的解题思路

1. 确定数组的左边界和右边界，初始化left=0，right=n-1。

## 例题

### 1、有序数组中的单一元素

- leetcode: https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/

- 题解：

``` java 

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums){
        /**
         * 方法一：没有使用二分法，直接遍历整个数组
         * */
//        int n = nums.length;
//        for(int i = 0;i < n;i++){
//            if(nums[i] == nums[i+1]){
//                i++;
//                continue;
//            }
//            return nums[i];
//        }
//        return nums[n-1];
        /**
         * 方法二：使用二分法（有点牵强，但是时间复杂度低）
         * */
        int first = 0;
        int last = nums.length -1;
        while(first < last){
            //int mid = (first+last)/2;
            int mid = first+(last-first)/2;
            if(mid%2==1){
                //这里保证mid、first、last都是偶数
                mid--;
            }
            //如果nums[mid] == nums[mid+1]则这个单数在后半部分；否则在前半部分
            if(nums[mid] == nums[mid+1]){
                first = mid + 2;
            }else{
                last = mid;
            }
        }
        return nums[first];
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        SingleElementInASortedArray s =new SingleElementInASortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int result = s.singleNonDuplicate(nums);
        System.out.println(result);
    }
}

```

### 2、寻找旋转排序数组中的最小值

- leetcode: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/

- 题解：

``` java

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length -1;
        while(first < last){
            int mid = first+(last-first)/2;
            if(nums[mid] <= nums[last]){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return nums[first];
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        FindMinimumInRotatedSortedArray nums = new FindMinimumInRotatedSortedArray();
        int result1 = nums.findMin(nums1);
        int result2 = nums.findMin(nums2);
        System.out.println(result1);
        System.out.println(result2);
    }
}

```

### 3、寻找比目标字母大的最小字母

- leetcode: https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/

- 题解：

``` java

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            //int mid = (last + first)/2;
            int mid = first + (last - first) / 2;
            if (letters[mid] <= target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        if (first < n) {
            //说明可以在letters[]中找到
            return letters[first];
        } else {
            //没找到就返回letters[]第一个元素
            return letters[0];
        }

    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'i';
        FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
        char result = f.nextGreatestLetter(letters, target);
        System.out.println(result);
    }
}

``` 

### 4、第一个错误版本

- leetcode: https://leetcode-cn.com/problems/first-bad-version/description/

- 题解：

``` java

public class FirstBadVersion{

    public int firstBadVersion(int n){
        int first = 1;
        int last = n;
        while(first < n){
            /**
             * 不要写(first+last)/2
             * 注意：二分的边界
             * */
            int mid = first+(last-first)/2;
            if(isBadVersion(mid)){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return first;
    }

    private boolean isBadVersion(int i) {
        return false;
    }

    public static void main(String[] args){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int result = firstBadVersion.firstBadVersion(5);
        System.out.println(result);
    }
}

``` 

### 5、旋转数组的最小数字

- 剑指 Offer 11. 旋转数组的最小数字

- 题解：

``` java

public class MinArray {
    /**
     * 数组由递增数组旋转一次得到,找出最小值
     *
     * @param numbers 旋转的初始数组
     * @return 最小值
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (numbers[high] < numbers[mid]) {
                low = mid + 1;
            } else if (numbers[high] > numbers[mid]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}

``` 

### 6、有序数组中的单一元素

- leetcode: https://leetcode-cn.com/problems/single-element-in-a-sorted-array/

- 题解：

``` java

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums){
        /**
         * 方法一：没有使用二分法，直接遍历整个数组
         * */
//        int n = nums.length;
//        for(int i = 0;i < n;i++){
//            if(nums[i] == nums[i+1]){
//                i++;
//                continue;
//            }
//            return nums[i];
//        }
//        return nums[n-1];
        /**
         * 方法二：使用二分法（有点牵强，但是时间复杂度低）
         * */
        int first = 0;
        int last = nums.length -1;
        while(first < last){
            //int mid = (first+last)/2;
            int mid = first+(last-first)/2;
            if(mid%2==1){
                //这里保证mid、first、last都是偶数
                mid--;
            }
            //如果nums[mid] == nums[mid+1]则这个单数在后半部分；否则在前半部分
            if(nums[mid] == nums[mid+1]){
                first = mid + 2;
            }else{
                last = mid;
            }
        }
        return nums[first];
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        SingleElementInASortedArray s =new SingleElementInASortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int result = s.singleNonDuplicate(nums);
        System.out.println(result);
    }
}

``` 

### 7、X的平方根

- leetcode: https://leetcode-cn.com/problems/sqrtx/

- 题解：

``` java

public class SqrtX {
    public int mySqrt(int x){
        if(x <= 1){
            return x;
        }
        int first = 1;
        int last = x;
        while(first <= last){
            int mid = first+(last-first)/2;
            int sqrt = x/mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt < mid){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
        return last;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        SqrtX sqrtX = new SqrtX();
        int result = sqrtX.mySqrt(x);
        System.out.println(result);
    }
}

```
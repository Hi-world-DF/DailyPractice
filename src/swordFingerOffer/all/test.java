package src.swordFingerOffer.all;

import src.leetCode.everyday.ListNode;
import src.swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Sword pointing at offer
 *
 * @author Defen Wang
 * @version 1.0, 2023/9/5 14:06
 * @since 1.0.0
 */
public class test {
    /**
     * O(1)时间删除链表节点
     *
     * @param head       头节点
     * @param deListNode 待删除节点
     */
    public void deleteNode(ListNode head, ListNode deListNode) {
        // 校验参数
        if (head == null || deListNode == null) {
            return;
        }
        // 只有一个节点
        if (head == deListNode) {
            head = null;
            return;
        }
        // 如果是尾节点的话, 遍历到倒数第二个节点，令它的next为空
        if (deListNode.next == null) {
            ListNode tem = head;
            while (tem.next.next != null) {
                tem = tem.next;
            }
            tem.next = null;
        } else {
            // 中间的某个节点
            deListNode.val = deListNode.next.val;
            deListNode.next = deListNode.next.next;
        }
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
     * <实现方式1>
     *
     * @param array 数组
     */
    public void reOrderArray1(int[] array) {
        // 校验参数
        if (null == array || 0 == array.length) {
            return;
        }
        // 两个数组，分奇数偶数
        final ArrayList<Integer> even = new ArrayList<>();
        final ArrayList<Integer> odd = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        odd.addAll(even);
        array = odd.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 第二种实现方式：和前的一个数进行交换
     * <实现方式2>
     *
     * @param array 输入数组
     */
    public void reOrderArray(int[] array) {
        if (null == array || 0 == array.length) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            if (array[i] % 2 != 0) {
                while (j >= 0) {
                    if (array[j] % 2 != 0) {
                        break;
                    }
                    if (array[j] % 2 == 0) {
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 15.输入一个链表，输出该链表中倒数第k个结点。
     *
     * @param head 链表head
     * @param k    第k个结点
     * @return 链表节点
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode other = head;
        ListNode index = head;
        for (int i = 1; i <= k; i++) {
            if (index.next == null) {
                return null;
            }
            index = index.next;
        }
        while (index.next != null) {
            other = other.next;
            index = index.next;
        }
        return other;
    }

    /**
     * 16.输入一个链表，反转链表后，输出链表的所有元素。
     */
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode tem = null;
        while (null != head) {
            ListNode index = head.next;
            head.next = tem;
            tem = head;
            head = index;
        }
        return tem;
    }

    /**
     * 17.输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode tem = null;
        if (list1.val <= list2.val) {
            tem = list1;
            tem.next = Merge(list1.next, list2);
        } else {
            tem = list2;
            tem.next = Merge(list1, list2.next);
        }
        return tem;
    }

    // 18 判断子树
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                // 比较左右子树是否一致
                result = isEqualTree(root1, root2);
            }
            // 不相同就从左右子树去看是不是包含root子树
            if (!result) {
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    // 19.返回二叉树镜像
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        // 借助栈来记录root
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    // 20.输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        int start = 0;
        while (matrix[0].length > start * 2 && matrix.length > start * 2) {
            printOneCircle(matrix, start, list);
            start++;
        }
        return list;
    }

    private void printOneCircle(int[][] matrix, int start, ArrayList<Integer> list) {
        // 列
        int endX = matrix[0].length - 1 - start;
        // 行
        int endY = matrix.length - 1 - start;
        // 从左往右
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        // 从上往下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        // 从右往左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }
        // 从下往上
        if (start < endX && start < endY - 1) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[i][start]);
            }
        }
    }

    public void MirrorDG(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        MirrorDG(root.left);
        MirrorDG(root.right);
    }

    private boolean isEqualTree(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        if (a.value == b.value) {
            return isEqualTree(a.left, b.left) && isEqualTree(a.right, b.right);
        }
        return false;
    }

    // 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
    public Stack<Integer> stack1 = new Stack<>();
    public Stack<Integer> stack2 = new Stack<>();

    // 一个栈用来存最小值，一个正常入栈
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else {
            if (stack2.peek() > node) {
                stack2.push(node);
            }
        }
    }

    public void pop() {
        final Integer pop = stack1.pop();
        if (Objects.equals(pop, stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    // 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入
    // 栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出
    // 序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (null == pushA || null == popA || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushA.length) {
            stack.push(pushA[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
            pushIndex++;
        }
        return stack.isEmpty();
    }

    // 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final TreeNode poll = queue.poll();
            list.add(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return list;
    }

    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
    // 假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || sequence.length == 1) {
            return false;
        }
        int rStart = 0;
        int length = sequence.length;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] < sequence[length - 1]) {
                rStart++;
            }
        }
        if (rStart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, rStart, length - 1));
        } else {
            for (int i = rStart; i < length - 1; i++) {
                if (sequence[i] <= sequence[length - 1]) {
                    return false;
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, rStart, length - 1));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rStart));
        }
        return true;
    }

    // 25.输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结
    // 点开始往下一直到叶结点所经过的结点形成一条路径。
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        findPaths(root, target, result, currentPath);
        return result;
    }

    private void findPaths(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath) {
        if (null == root) {
            return;
        }
        currentPath.add(root.value);
        target -= root.value;
        if (null == root.left && null == root.right && target == 0) {
            result.add(currentPath);
        } else {
            findPaths(root.left, target, result, currentPath);
            findPaths(root.right, target, result, currentPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    // 26, 27 有点难理解

    // 28.输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所
    // 能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    // 思路：将当前位置的字符和前一个字符位置交换，递归。
    public ArrayList<String> permutation(String str) {
        final ArrayList<String> list = new ArrayList<>();
        if (null == str || str.length() == 0) {
            return list;
        }
        final char[] chars = str.toCharArray();
        int index = 0;
        final TreeSet<String> strings = new TreeSet<>();
        this.permutation(strings, index, chars);
        return list;
    }

    private void permutation(TreeSet<String> strings, int index, char[] chars) {
        if (null == chars || chars.length == 0) {
            return;
        }
        if (index < 0 || index > chars.length - 1) {
            return;
        }
        if (index == chars.length - 1) {
            strings.add(String.valueOf(chars));
        }
        for (int i = index; i < chars.length; i++) {
            // 交换位置
            this.swap(chars, index, i);
            this.permutation(strings, index + 1, chars);
            // 回退
            this.swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 0;
        Integer candidate = null;

        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        count = 0;
        for (int num : array) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > array.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No more than half num.");
        }
    }

    // 输入n个整数，找出其中最小的K个数
    public int[] GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0 || input.length == 0) {
            return new int[0];
        }
        if (input.length <= k) {
            return input;
        }
        // 建立一个k大小的大堆，若下一个数大于或等于堆顶的数，则不往堆添加，否则就弹出堆顶，添加新的数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int num : input) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        int[] smallest = new int[k];
        for (int i = 0; i < k; i++) {
            smallest[i] = maxHeap.poll();
        }
        return smallest;
    }

    // 31.求连续子数组（包含负数）的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        int maxSum = array[0];
        int currentSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (currentSum < 0) {
                currentSum = array[i];
            } else {
                currentSum += array[i];
            }
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    // 32.从1到整数n中1出现的次数
    public long CountOne2(long n) {
        int count = 0;
        if (n < 10) {
            return count;
        }
        for (int i = 0; i < n; i++) {
            final String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public long CountOne3(long n) {
        long count = 0; // 1的个数
        long i = 1; // 当前位
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i; // 低位
            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if (current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;
            //前移一位
            i = i * 10;
        }
        return count;
    }

    // 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
    public String PrintMinNumber(int[] num) {
        if (null == num || num.length == 0) {
            return "";
        }
        final int length = num.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = String.valueOf(num[i]);
        }
        Arrays.sort(strings, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    // 丑数是只包含因子2、3和5的数，求从小到大的第N个丑数。
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int mut2 = 0;
        int mut3 = 0;
        int mut5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(arr[mut2] * 2, Math.min(arr[mut3] * 3, arr[mut5] * 5));
            if (min == arr[mut2] * 2) {
                mut2++;
            }
            if (min == arr[mut3] * 3) {
                mut3++;
            }
            if (min == arr[mut5] * 5) {
                mut5++;
            }
            arr[i] = min;
        }
        return arr[index - 1];
    }

    // 35.在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
    public int FirstNotRepeatingChar(String str) {
        if (null == str || str.length() == 0) {
            return -1;
        }
        final int length = str.length();
        HashMap<Character, Integer> map = new HashMap<>(length);
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public class Solution {
        int cnt = 0; // 全局变量记录逆序对的数量
        int[] tmp;   // 用于合并的临时数组

        public int InversePairs(int[] array) {
            tmp = new int[array.length];
            mergeSort(array, 0, array.length - 1);
            return cnt;
        }

        private void mergeSort(int[] arr, int l, int h) {
            if (h - l < 1) {
                return;
            }
            int m = l + (h - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, h);
            merge(arr, l, m, h);
        }

        private void merge(int[] arr, int l, int m, int h) {
            int i = l, j = m + 1, k = l;
            while (i <= m || j <= h) {
                if (i > m) {
                    tmp[k] = arr[j++];
                } else if (j > h) {
                    tmp[k] = arr[i++];
                } else if (arr[i] <= arr[j]) {
                    tmp[k] = arr[i++];
                } else {
                    tmp[k] = arr[j++];
                    this.cnt = (this.cnt + (m - i + 1)) % 1000000007;
                }
                k++;
            }
            for (k = l; k <= h; k++) {
                arr[k] = tmp[k];
            }
        }
    }

    // 输入两个链表，找出它们的第一个公共结点。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : pHead2;
            p2 = p2 != null ? p2.next : pHead1;
        }
        return p1;
    }

    public int GetNumberOfK(int[] array, int k) {
        if (null == array || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            if (array[0] == k) {
                return 1;
            } else {
                return 0;
            }
        }
        int result = 0;
        int mid = array.length / 2;
        if (k < array[mid]) {
            result += GetNumberOfK(Arrays.copyOfRange(array, 0, mid), k);
        } else if (k > array[mid]) {
            result += GetNumberOfK(Arrays.copyOfRange(array, mid, array.length - 1), k);
        } else {
            for (int i = mid + 1; i < array.length; i++) {
                if (array[i] == k) {
                    result++;
                } else {
                    break;
                }
            }
            for (int i = mid; i >= 0; i--) {
                if (array[i] == k) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
    // 最长路径的长度为树的深度。

    public int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeDepth(root.right), getTreeDepth(root.left));
    }

    // 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        return Math.abs(left - right) <= 1;
    }

    // 40.一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (null == array) {
            return;
        }
        int allOp = 0;
        // 这里allOp为所有数字异或操作的结果，结果为两个只出现一次的数字的异或
        for (int num : array) {
            allOp ^= num;
        }
        // 找到两个数字第一个不一致的位数
        int index = 0;
        while ((allOp & 1) == 0) {
            allOp >>= 1;
            index++;
        }
        int n1 = 0;
        int n2 = 0;
        for (int num : array) {
            if ((num >> index ^ 1) == 1) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }

    // 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        while (start < end) {
            // 等差求和
            int cur = (start + end) * (end - start + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
                start++;
            } else if (cur < sum) {
                end++;
            } else {
                start++;
            }
        }
        return result;
    }

    // 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的
    // 和等于S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        final ArrayList<Integer> result = new ArrayList<>();
        if (null == array || array.length == 0) {
            return result;
        }
        int pre = 0;
        int last = array.length - 1;
        while (pre < last) {
            int curSum = array[pre] + array[last];
            if (curSum == sum) {
                // 实际上乘积最小肯定是最外面两个数
//                if (result.isEmpty()) {
//                    result.add(array[pre]);
//                    result.add(array[last]);
//                    pre++;
//                    last--;
//                } else {
//                    if (result.get(0) * result.get(1) > array[pre] * array[last]) {
//                        result.set(0, array[pre]);
//                        result.set(1, array[last]);
//                        pre++;
//                        last--;
//                    }
//                }
                result.add(array[pre]);
                result.add(array[last]);
                return result;
            } else if (curSum < sum) {
                pre++;
            } else {
                last--;
            }
        }
        return result;
    }

    //Invert String, but words
    public String ReverseSentence(String str) {
        if (null == str || str.length() == 0 || str.trim().length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        final String revert = this.revert(str);
        final String[] split = revert.split(" ");
        for (String s : split) {
            sb.append(this.revert(s)).append(" ");
        }
        return String.valueOf(sb).substring(0, sb.length() - 1);
    }

    private String revert(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }

    // For a given character sequence S, please rotate it left by K bits to output the sequence
    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() == 0) {
            return str;
        }
        int k = n % str.length();
        String pre = str.substring(0, k);
        String last = str.substring(k, str.length());
        final String s = this.revert(pre) + this.revert(last);
        return this.revert(s);
    }

    public static double[][] calculateProbability(int n, int s) {
        if (s > 6 * n || s < n) {
            throw new IllegalArgumentException("点数之和必须在[" + n + "," + (6 * n) + "]之间");
        }

        double[][] result = new double[n + 1][s - n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= s; j++) {
                if (i == j) {
                    result[i][j - i] = 1.0;
                } else {
                    for (int k = 1; k <= 6; k++) {
                        if (j - k >= i - 1) {
                            result[i][j - i] += 1.0 / 6.0 * result[i - 1][j - k];
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void printProbability(double[][] result) {
        for (int i = 1; i <= result.length - 1; i++) {
            for (int j = 1; j <= result[i].length - 1; j++) {
                System.out.print(String.format("%.2f ", result[i][j]));
            }
            System.out.println();
        }
    }

    /**
     * 44.扑克牌是否为顺子，其中大小王为0，可以做癞子
     */
    public boolean isContinuous(int[] numbers) {
        if (null == numbers || numbers.length == 0) {
            return false;
        }
        int wang = 0;
        int diff = 0;
        // 先排序
        Arrays.sort(numbers);
        // 遍历
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                wang++;
                continue;
            }
            // 两个数相同，肯定不是顺子
            if (numbers[i + 1] == numbers[i]) {
                return false;
            } else {
                diff += numbers[i + 1] - numbers[i] - 1;
            }
        }
        return diff <= wang;
    }

    // 圆圈中最后剩下的数字
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            cur = (cur + m - 1) % list.size();
            list.remove(cur);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    // 求1+2+3+...+n
    // 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B:C）
    public int Sum_Solution(int n) {
        int sum = n;
        boolean result = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    // 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            // 计算个位
            int temp = num1 ^ num2;
            // 计算进位（1+1）
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    // 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法
    // 的数值则返回0
    public int StrToInt(String str) {
        if (null == str || str.length() == 0) {
            return 0;
        }
        final char[] chars = str.toCharArray();
        int mark = 0;
        int result = 0;
        if (chars[0] == '-') {
            mark = 1;
        }
        for (int i = mark; i < chars.length; i++) {
            if (chars[i] == '+') {
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
            result = result * 10 + chars[i] - '0';
        }
        return mark == 1 ? -result : result;
    }

    // 在一个长度为n的数组里的所有数字都在0到n-1的范围内，找出数组中任意一个重复的数字
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (null == numbers || length <= 1) {
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == i) {
                continue;
            }
            // 说明已经存在了
            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            // 不重复的数字把它放到对应位置去
            int temp = numbers[i];
            numbers[i] = numbers[numbers[i]];
            numbers[numbers[i]] = temp;
        }
        return false;
    }

    // 52.给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
    // 其中B中的元素B[i]=A[0]A[1]...A[i-1]A[i+1]...A[n-1]。
    // 可以使用除法：所有的乘积 / 当前a[i]
    // 不可以使用除法：利用两个数组，一个计算前面的乘积 * 一个计算后面的乘积
    public int[] multiply(int[] A) {
        final int n = A.length;
        int[] B = new int[n];
        int[] pre = new int[n];
        int[] last = new int[n];
        pre[0] = 1;
        last[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * A[i - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            last[j] = last[j + 1] * A[j + 1];
        }
        for (int i = 0; i < n; i++) {
            B[i] = pre[i] * last[i];
        }
        return B;
    }

    // 54.请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
    //这个函数使用的正则表达式是"[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?"。这个表达式表示一个合法的数值可能的组成部分：
    //"\\d*"匹配零个或多个数字
    //"\\."匹配小数点
    //"\\d+"匹配一个或多个数字
    //"e"或"E"表示科学记数法，比如2E3。（注意这里需要前面有数字，不能单独出现）
    //"\\d+"匹配科学记数法后的数字（必须有）
    //[+-]?表示可能的正负号
    public boolean isNumeric(String str) {
        // 正则表达式表示：可能存在的正负号，紧接着是零或多个数字，可能有小数点，小数点后面是零或多个数字，
        // 可能有'e'或'E'，'e'或'E'后可能有正负号，然后是一个或多个数字
        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    // 55.请实现一个函数用来找出字符流中第一个只出现一次的字符。
    char[] chars = new char[256];
    StringBuilder sb = new StringBuilder();

    public void Insert(char ch) {
        sb.append(ch);
        chars[ch]++;
    }

    public char FirstAppearingOnce() {
        char[] str = sb.toString().toCharArray();
        for (char c : str) {
            if (chars[c] == 1) {
                return c;
            }
        }
        return '#';
    }

    // 56.一个链表中包含环，请找出该链表的环的入口结点。
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;  // No cycle exists
        }
        // Step 1: Determine if there is a cycle in the list
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;  // Reached the end of the list, so no cycle exists
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // Step 2: Locate the start of the cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 57.在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指
    //针。
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0); // 创建一个新的头节点
        dummy.next = head; // 连接链表到新的头节点
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) { // 找到相同的节点
                cur = cur.next;
                while (cur.next != null && cur.val == cur.next.val) { // 跳过相同的节点
                    cur = cur.next;
                }
                // 将pre节点的next指向cur的next，即删除了与cur值相同的节点
                pre.next = cur.next;
                cur = cur.next; // pre不变，cur向后移动
            } else { // 非重复节点，两个指针同时向后移动
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next; // 返回去除重复元素后的链表头
    }

    // 58.给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅
    //包含左右子结点，同时包含指向父结点的指针。

    /**
     * 59.请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * <P>检测对称的函数</P>
     *
     * @param root 根节点
     * @return 是否对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return null == root || checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        // 如果左右子树的根节点都为null，是对称的
        if (root1 == null && root2 == null) {
            return true;
        }
        // 如果左右子树只有一个为null，或者左右子树的值不相同，说明不对称
        if (root1 == null || root2 == null || root1.value != root2.value) {
            return false;
        }

        // 接下来递归计算对应对称位置的子树是否对称
        return checkSymmetric(root1.left, root2.right) && checkSymmetric(root1.right, root2.left);
    }

    /**
     * 60.之字形打印二叉树。
     * <p>即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，依此类推</p>
     *
     * @param root 二叉树根节点
     * @return 列表
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        // 使用队列来进行广度优先搜索
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        // 每一层的节点的方向
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            // 用来存储每一层的节点值
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                // 根据方向存储节点值
                if (isOrderLeft) {
                    levelList.offerLast(curNode.value);
                } else {
                    levelList.offerFirst(curNode.value);
                }
                // 把下一层的节点放入队列中
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            results.add(new ArrayList<Integer>(levelList));
            // 切换方向
            isOrderLeft = !isOrderLeft;
        }

        return results;
    }

    /**
     * 61.从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * @param root 跟节点
     * @return list
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            List<Integer> cur = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                final TreeNode curNode = queue.poll();
                cur.add(curNode.value);
                if (null != curNode.left) {
                    queue.add(curNode.left);
                }
                if (null != curNode.right) {
                    queue.add(curNode.right);
                }
            }
            res.add(cur);
        }
        return res;
    }

    // 62.请实现两个函数，分别用来序列化和反序列化二叉树
    // 使用特殊字符，如 "#" 代表 null，"," 作为分隔符
    private static final String NULL_SIGN = "#";
    private static final String SPLIT_SIGN = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        this.serializeTree(root, sb);
        return sb.toString();
    }

    private void serializeTree(TreeNode node, StringBuilder sb) {
        if (null == node) {
            sb.append(NULL_SIGN).append(SPLIT_SIGN);
        } else {
            sb.append(node.value).append(SPLIT_SIGN);
            this.serializeTree(node.left, sb);
            this.serializeTree(node.right, sb);
        }
    }

    // 反序列化函数
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SPLIT_SIGN);
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeTree(queue);
    }

    private TreeNode deserializeTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals(NULL_SIGN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = this.deserializeTree(queue);
            node.right = this.deserializeTree(queue);
            return node;
        }
    }

    private int res = 0;
    private int count = 0;

    /**
     * 63.给定一颗二叉搜索树，请找出其中的第k大的结点
     *
     * @param root 根节点
     * @param k 第k大的
     * @return 第k大的节点
     */
    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode node, int k) {
        if(null == node || count >= k) {
            return;
        }
        inOrder(node.right, k);
        count++;
        if (count == k) {
            res = node.value;
        }
        inOrder(node.left, k);
    }

    // 64.如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位
    //于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

    // 65.给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值

    // 66.请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中
    //的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵
    //中的某一个格子，则该路径不能再进入该格子。

    // 67.地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方
    //向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。

}




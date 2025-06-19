package io.zchiye.leetcode.exercise.top150.stack;

import io.zchiye.utils.TestCaseUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Lc224Calculate {


    static class Solution {

        public int calculateDeepSeek(String s) {
            if (s == null || s.isEmpty()) return 0;

            Stack<Integer> nums = new Stack<>();
            Stack<Character> ops = new Stack<>();
            int num = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == ' ') continue;

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else {
                    // 遇到操作符，先把前面的数字压栈
                    nums.push(num);
                    num = 0;

                    // 处理当前操作符
                    while (!ops.isEmpty() && hasPrecedence(ops.peek(), c)) {
                        nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                    }

                    if (c == ')') {
                        // 处理括号内的所有操作
                        while (ops.peek() != '(') {
                            nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                        }
                        ops.pop(); // 弹出左括号
                    } else {
                        ops.push(c);
                    }
                }
            }

            // 处理最后一个数字
            nums.push(num);

            // 处理剩余的操作
            while (!ops.isEmpty()) {
                nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
            }

            return nums.pop();
        }

        // 判断op1是否比op2优先级高或相等
        private boolean hasPrecedence(char op1, char op2) {
            if (op1 == '(' || op2 == '(') return false;
            if (op2 == ')') return true;
            return (op1 == '*' || op1 == '/') || (op2 == '+' || op2 == '-');
        }

        // 应用操作符
        private int applyOp(char op, int b, int a) {
            switch (op) {
                case '+': return a + b;
                case '-': return a - b;
                case '*': return a * b;
                case '/': return a / b;
            }
            return 0;
        }


        public int calculate(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            Map<Character, Integer> OP_PRIORITY = new HashMap<>();
            OP_PRIORITY.put('+', 1);
            OP_PRIORITY.put('-', 1);
            OP_PRIORITY.put('*', 2);
            OP_PRIORITY.put('/', 2);
            OP_PRIORITY.put('%', 2);
            OP_PRIORITY.put('(', 0);
            OP_PRIORITY.put(')', 0);

            char[] cs = s.toCharArray();
            Stack<Character> ops = new Stack<>();
            Stack<Integer> nums = new Stack<>();

            int i = 0;
            boolean hasNum = false;
            while (i < cs.length) {
                char c = cs[i];
                if (c == ' ') {
                    i++;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    int num = 0;
                    while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
                        num = num * 10 + cs[i] - '0';
                        i++;
                    }
                    nums.push(num);
                    hasNum = true;
                    continue;
                } else if (c == '(') {
                    ops.push('(');
                    i++;
                    hasNum = false;
                    continue;
                } else if (c == ')') {
                    i++;
                    while (!ops.empty() && ops.peek() != '(') {
                        nums.push(calOpResult(nums, ops.pop()));
                    }
                    ops.pop();
                    hasNum = true;
                    continue;
                } else if (OP_PRIORITY.get(c) == null) {
                    i++;
                    continue;
                }

                i++;
                int pri = OP_PRIORITY.get(c);
                Character lastOp = ops.empty() ? null : ops.peek();
                int lastPri = lastOp == null ? 0 : OP_PRIORITY.get(lastOp);
                if (pri > lastPri || lastOp == null || lastOp == '(') {
                    ops.push(c);
                    if (!hasNum && c == '-') {
                        nums.push(0);
                    }
                } else {
                    while (!ops.empty()) {
                        lastOp = ops.empty() ? null : ops.peek();
                        lastPri = lastOp == null ? 0 : OP_PRIORITY.get(lastOp);
                        if (pri > lastPri) {
                            break;
                        }
                        nums.push(calOpResult(nums, lastOp));
                        ops.pop();
                    }
                    ops.push(c);
                }
            }

            while (!ops.empty()) {
                nums.push(calOpResult(nums, ops.pop()));
            }
            return nums.pop();
        }

        private int calOpResult(Stack<Integer> nums, char op) {
            Integer num2 = nums.empty() ? null : nums.pop();
            Integer num1 = nums.empty() ? null : nums.pop();
            int a1;
            int a2;
            switch (op) {
                case '+':
                    a2 = num2 == null ? 0 : num2;
                    a1 = num1 == null ? 0 : num1;
                    return a1 + a2;
                case '-':
                    a2 = num2 == null ? 0 : num2;
                    a1 = num1 == null ? 0 : num1;
                    return a1 - a2;
                case '*':
                    a2 = num2 == null ? 1 : num2;
                    a1 = num1 == null ? 1 : num1;
                    return a1 * a2;
                case '/':
                    a2 = num2 == null ? 1 : num2;
                    a1 = num1 == null ? 1 : num1;
                    return a1 / a2;
                case '%':
                    a2 = num2 == null ? 1 : num2;
                    a1 = num1 == null ? 1 : num1;
                    return a1 % a2;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase("1*2-3/4+5*6-7*8+9/10", solution::calculate, -24);
        TestCaseUtils.testCase("1-(-2)", solution::calculate, 3);
        TestCaseUtils.testCase("(2+6*3+5-(3*14/7+2)*5)+3", solution::calculate, -12);
        TestCaseUtils.testCase("1+ 2* 2 / 2- 1 + 1", solution::calculate, 3);
        TestCaseUtils.testCase("11 + 1", solution::calculate, 12);
        TestCaseUtils.testCase(" 6-4 / 2 ", solution::calculate, 4);
    }
}

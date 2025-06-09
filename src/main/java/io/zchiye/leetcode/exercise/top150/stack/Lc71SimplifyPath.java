package io.zchiye.leetcode.exercise.top150.stack;

import io.zchiye.utils.TestCaseUtils;

public class Lc71SimplifyPath {

    static class Solution {
        public String simplifyPath(String path) {
            if (path == null || path.isEmpty()) {
                return path;
            }
            String[] parts = path.split("/");
            if (parts.length == 1) {
                return path;
            } else if (parts.length == 0) {
                return "/";
            }

            Stack stack = new Stack(parts.length);
            for (String part : parts) {
                if (part.isEmpty()) {
                    continue;
                }
                switch (part) {
                    case ".":
                    case "/":
                        break;
                    case "..":
                        stack.pop();
                        break;
                    default:
                        stack.push(part);
                        break;
                }
            }

            if (stack.isEmpty()) {
                return "/";
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size; i++) {
                sb.append("/").append(stack.values[i]);
            }
            return sb.toString();
        }

        class Stack {
            String[] values;
            int size;

            Stack(int num) {
                values = new String[num];
            }

            void push(String s) {
                values[size++] = s;
            }

            String pop() {
                if (size <= 0) {
                    return null;
                }
                return values[--size];
            }

            String peek() {
                return values[size - 1];
            }

            boolean isEmpty() {
                return size <= 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase("/home/", solution::simplifyPath, "/home");
        TestCaseUtils.testCase("/home//foo/", solution::simplifyPath, "/home/foo");
        TestCaseUtils.testCase("/home/user/Documents/../Pictures", solution::simplifyPath, "/home/user/Pictures");
        TestCaseUtils.testCase("/../", solution::simplifyPath, "/");
        TestCaseUtils.testCase("/.../a/../b/c/../d/./", solution::simplifyPath, "/.../b/d");
        TestCaseUtils.testCase("///", solution::simplifyPath, "/");
    }

}

package code.math;

import input.InputUtils;

import java.util.Arrays;

public class NumberOfWaysToDivideNSumInKSizeGroupsIncreementally {

    class SolutionRecursive {
        int recurse(int prev, int sum, int pos, int len) {
            if (pos == len) {
                if (sum == 0) return 1;
                else return 0;
            }
            if (sum == 0) return 0;
            var result = 0;
            for (var i = prev; i <= sum; i++) {
                result += recurse(i, sum - i, pos + 1, len);
            }
            return result;
        }

        int solve(int n, int k) {
            return recurse(1, n, 0, k);
        }
    }

    static class SolutionDP {
        int len;
        int sum;
        Integer[][][] dp;
        SolutionDP(int N, int K) {
            this.len = K;
            this.sum = N;
            this.dp = new Integer[K][N][N];
        }

        int recurse(int prevValue, int remainingSum, int pos) {
            if (pos == len) {
                if (remainingSum == 0) return 1;
                else return 0;
            }
            if (remainingSum == 0) return 0;
            if (dp[pos][prevValue - 1][remainingSum - 1] != null) {
                return dp[pos][prevValue - 1][remainingSum - 1];
            }
            var result = 0;
            for (var i = prevValue; i <= remainingSum; i++) {
                result += recurse(i, remainingSum - i, pos + 1);
            }
            return dp[pos][prevValue - 1][remainingSum - 1] = result;
        }

        int solve() {
            return recurse(1, sum, 0);
        }
    }

    public static void main(String[] args) {
        var object = new NumberOfWaysToDivideNSumInKSizeGroupsIncreementally();
        while (1 == 1) {
            var N = InputUtils.nextInt();
            var K = InputUtils.nextInt();
//            System.out.println(
//                    object.new SolutionRecursive().solve(N, K)
//            );
            System.out.println(
                    new NumberOfWaysToDivideNSumInKSizeGroupsIncreementally.SolutionDP(N, K).solve()
            );
        }
    }

}

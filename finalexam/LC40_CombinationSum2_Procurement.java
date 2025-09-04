
import java.util.*;

class SolutionII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 同層跳過重複
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            // II 版每個數只能用一次 → 下一層傳 i+1
            backtrack(nums, remain - nums[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SolutionII sol = new SolutionII();
        List<List<Integer>> ans = sol.combinationSum2(nums, target);
        for (List<Integer> list : ans) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}


import java.util.*;

class SolutionI {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            path.add(nums[i]);
            // I 版可重複使用 → 下一層仍傳 i
            backtrack(nums, remain - nums[i], i, path, res);
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

        SolutionI sol = new SolutionI();
        List<List<Integer>> ans = sol.combinationSum(nums, target);
        for (List<Integer> list : ans) {
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

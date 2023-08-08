import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1,2,2), sums = new ArrayList<>();
        Collections.sort(ls);
        subsetSum(0, ls.size(), ls, sums, new ArrayList<>());
        Collections.sort(sums);
        System.out.println(sums);
    }
    public static void subsetSum(int ind, int n, List<Integer> nums, List<Integer> sums, List<Integer> dp) {
        sums.add(dp.stream().mapToInt(Integer::valueOf).sum());
        if(ind == n) {
            return;
        }
        for(int i=ind; i<n; i++) {
            if(i != ind && nums.get(i)==nums.get(i - 1)) continue;
            dp.add(nums.get(i));
            subsetSum(i + 1, n, nums, sums, dp);
            dp.remove(dp.size() - 1);
        }
    }
}

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(5,2,1);
        List<Integer> sums = new ArrayList<>();
        subsetSums(0, ls, new boolean[ls.size()], ls.size(), sums, new ArrayList<>());
        Collections.sort(sums);
        System.out.println(sums);
    }
    public static void subsetSums(int ind, List<Integer> nums, boolean[] takeNotTake, int n, List<Integer> sums, List<Integer> dp) {
        int sum = 0;
        for(int num: dp) {
            sum+=num;
        }
        sums.add(sum);
        if(ind == n) {
            return;
        }

        for(int i=ind; i<n; i++) {
            if(takeNotTake[i]) {continue;}
                else {
                takeNotTake[i]= true;
                dp.add(nums.get(i));
                subsetSums(i + 1, nums, takeNotTake, n, sums, dp);
                takeNotTake[i]= false;
                dp.remove(dp.size() - 1);
            }
        }
    }
}

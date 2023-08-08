import java.util.Arrays;
import java.util.Comparator;

public class MinRailwayPlatform {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1, j=0;
        int count=1, ans = 1;
        while(i<arr.length && j < arr.length) {
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}

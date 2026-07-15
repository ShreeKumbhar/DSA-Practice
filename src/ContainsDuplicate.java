import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean BruteForce(int[] nums){

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean better(int[] nums){

        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static boolean optimal(int[] nums){

        HashSet<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {

        int[] nums={1,2,3,1};
        boolean ans=optimal(nums);
        System.out.println(ans);

    }

}

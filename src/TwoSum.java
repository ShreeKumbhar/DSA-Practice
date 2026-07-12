import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] bruteForce(int[] nums,int target){

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] better(int[] nums,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i< nums.length;i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static int[] optimise(int[] nums,int target){

        int n=nums.length;
        int[][] arr=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        int left=0,right=n-1;

        while(left < right){
            int sum=arr[left][0]+arr[right][0];
            if(sum==target){
                return new int[]{arr[left][1],arr[right][1]};
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int[] nums={-6, 7, 1, -7, 6, 2};
        int target=3;
        int[] ans=optimise(nums,target);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }
}
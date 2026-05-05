class Solution {
    public int[] tmp;
    public int count = 0;

    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }
    public void mergeSort(int[] nums, int s, int e){
        if (s >= e) return;

        int m = s + (e - s) / 2;

        mergeSort(nums, s, m);
        mergeSort(nums, m + 1, e);

        couuntParis(nums, s, m, e);

        merge(nums, s, m, e);

    }

    public void merge(int[] nums, int s, int m, int e){
        for(int i = s; i <= e; i++){
            tmp[i] = nums[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        while(index1 <= m && index2 <= e){
            if(tmp[index1] > tmp[index2]){
                nums[k++] = tmp[index2++];
            }else{
                nums[k++] = tmp[index1++];
            }
        }
        while(index1 <= m){
            nums[k++] = tmp[index1++];
        }
        while(index2 <= e){
            nums[k++] = tmp[index2++];
        }
    }

    public void couuntParis(int[] nums, int s, int m, int e){
        int j = m + 1;

        for(int i = s; i <= m; i++){
            while (j <= e && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (m + 1));
        }
    }
}
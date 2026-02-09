class Solution {
    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        while (i < n) {
            if (nums[i] == 0)
                break;
            else
                i++;
        }

       

       j=i;

        while (j < n && nums[j] == 0)
            j++;

        System.out.println(j);
        if (j >= n )
            return;
        while (i < n && j < n) {
            if (nums[i] == 0 && nums[j] != 0)
                swap(i, j, nums);
            while (i < n && nums[i] != 0)
                i++;

            while (j < n && nums[j] == 0)
                j++;
        }

    }
}
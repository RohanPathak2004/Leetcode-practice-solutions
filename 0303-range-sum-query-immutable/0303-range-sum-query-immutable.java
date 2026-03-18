class NumArray {
    int[] tree;
    int n;

    public int buildTree(int i, int l, int r, int[] tree, int[] arr) {
        if (l == r)
            return tree[i] = arr[l];
        int mid = (l + r) / 2;
        int left = buildTree(i * 2 + 1, l, mid, tree, arr);
        int right = buildTree(i * 2 + 2, mid + 1, r, tree, arr);
        return tree[i] = left + right;
    }

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];
        int totalSum = buildTree(0, 0, n - 1, tree, nums);
        // System.out.println(totalSum);
    }

    public int query(int i, int l, int r, int L, int R) {
        if (r < L || l > R)
            return 0;

        if (l >= L && r <= R)
            return tree[i];

        int mid = (l + r) / 2;
        return query(2 * i + 1, l, mid, L, R) +
                query(2 * i + 2, mid + 1, r, L, R);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
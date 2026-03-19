class NumArray {
    int[] tree;
    // int[] nums;
    int n;
    public void buildTree(int i,int l,int r,int[] tree,int[] arr){
        if(l==r){
            tree[i] = arr[l];
            return;
        }
        int mid = (l+r)/2;
        buildTree(2*i+1,l,mid,tree,arr);
        buildTree(2*i+2,mid+1,r,tree,arr);
        tree[i] = tree[2*i+1]+tree[2*i+2];
    }
    public int query(int i,int l,int r,int L,int R){
        if(l>R||r<L) return 0;
        if(l>=L&&r<=R) return tree[i];
        int mid = (l+r)/2;
        return query(2*i+1,l,mid,L,R)+query(2*i+2,mid+1,r,L,R);
    }
    public void updateTree(int i,int l,int r,int idx,int val){
        int mid = (l+r)/2;
        if(l==r){
            tree[i] = val;
            return;
        }
        if(idx>=l&&idx<=mid){
            updateTree(2*i+1,l,mid,idx,val);
        }else if(idx>=mid+1&&idx<=r){
            updateTree(2*i+2,mid+1,r,idx,val);
        }
        tree[i] = tree[2*i+1]+tree[2*i+2];
        // System.out.println(tree[i]);

    }
    public NumArray(int[] nums) {
        n = nums.length;
        // this.nums = nums;
        tree = new int[4*n];
        buildTree(0,0,n-1,tree,nums);
        // System.out.println(tree[0]);
    }
    
    public void update(int index, int val) {
        // nums[index] = val;
        updateTree(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return  query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
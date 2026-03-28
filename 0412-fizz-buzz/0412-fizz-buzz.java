class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        String fiz = "Fizz";
        String buz = "Buzz";
        String fiz_buz = fiz+buz;
        for(int i = 1; i<=n ; i++){
            if(i%3==0&&i%5==0){
                ans.add(fiz_buz);
            }else if(i%3==0) ans.add(fiz);
            else if(i%5==0) ans.add(buz);
            else ans.add(i+"");
        }

        return ans;
    }
}
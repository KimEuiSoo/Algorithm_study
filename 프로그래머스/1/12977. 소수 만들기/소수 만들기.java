class Solution {
    int[] nums;
    public int solution(int[] num) {
        int answer = -1;
        
        nums = num;
        
        answer=dfs(0, 0, 0);

        return answer;
    }
    
    public int dfs(int sum,int index, int depth){
        if(depth==3) return isPrime(sum) ? 1 : 0;
        
        int count=0;
        for(int i=index; i<nums.length; i++){
            count += dfs(sum + nums[i], i+1, depth + 1);
        }
        
        return count;
    }
    
    public boolean isPrime(int num){
        boolean isPrime = true;    
        
        if(num==2) return true;
        if (num <= 1 || num % 2 == 0) return false;
        
        for (int i = 3; i * i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        return isPrime;
    }
}
// 7 points

class Solution {
    static int[] dp = new int[32001];
    public int solution(int N, int number) {
        
        
        
        for(int i=1;i<=32000;i++){
            dp[i] = 10;
        }
        
        dp[1] = 2;
        dp[N] = 1;
        if(N*11<=32000) dp[N*11] = 2;
        if(N*111<=32000) dp[N*111] = 3;
        if(N*1111<=32000) dp[N*1111] = 4;
        if(N*11111<=32000) dp[N*11111] = 5;
     
        for(int i=2;i<=8;i++){
            for(int j=1;j<=32000;j++){
                if(dp[j]==i-1){
                    if(j+N<=32000&&dp[j+N]==10) dp[j+N] = i;
                    if(j-N>0&&dp[j-N]==10) dp[j-N] = i;
                    if(j*N<=32000&&dp[j*N]==10) dp[j*N] = i;
                    if(j/N>0&&dp[j/N]==10) dp[j/N] = i;
                }
            }
        }
        
        for(int i=1;i<32000;i++){
            for(int j=i;i+j<=32000;j++){
                
                dp[i+j] = Math.min(dp[i+j], dp[i]+dp[j]);
            }
        }
        
        for(int i=32000;i>1;i--){
            for(int j=1;i-j>0;j++){
                
                dp[i-j] = Math.min(dp[i-j], dp[i]+dp[j]);
            }
        }
        
        for(int i=1;i<=16000;i++){
            for(int j=2;i*j<=32000;j++){
                dp[i*j] = Math.min(dp[i*j], dp[i]+dp[j]);
            }
        }
        
        for(int i=32000;i>1;i--){
            for(int j=2;i/j>0;j++){
                
                dp[i/j] = Math.min(dp[i/j], dp[i]+dp[j]);
            }
        }
        
        if(dp[number]>8) dp[number] = -1; 
        return dp[number];
      
    }
    
}

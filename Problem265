class Problem265 {
    public int minCostII(int[][] costs) {
        if(costs.length == 0) return 0;
        int row = costs.length;
        int col = costs[0].length;
        
        int[][] res =  new int[row][col];
        
        for(int i = 0; i < col; i++){
            res[0][i] = costs[0][i];
        }

        
        for(int j = 1; j < row; j++){
            int min = Integer.MAX_VALUE;
            int secMin = Integer.MAX_VALUE;
            int pos = 0;
            for(int m = 0; m < col; m++){
                if(res[j - 1][m] < min){
                    secMin = min;
                    min = res[j - 1][m];
                    pos = m;
                } else if(res[j - 1][m] < secMin ){
                    secMin = res[j - 1][m];
                }
            }
            
            for(int k = 0; k < col; k++){
                if(k == pos) {
                    res[j][k] = secMin + costs[j][k];
                } else {
                    res[j][k] = min + costs[j][k];
                }
            }
            
        }
        int min = Integer.MAX_VALUE;
        for(int q = 0; q < col; q++){
            if(res[row - 1][q] < min){
                min = res[row - 1][q];
            }
        }
        return min;   
    }
}

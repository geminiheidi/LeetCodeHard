class Problem224 {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ') continue;
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }
            else if(ch == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;  
                sign = 1; // pay attention
                
            }
            else if(ch == ')'){
                result += sign * num;
                result  *= stack.pop();
                result += stack.pop();
                num = 0; // pay attention
            }
        }
        result += sign * num;
        return result;
        
    }
}

import java.util.Stack; 
  
class InfixToPostfix 
{ 
   //Method returns the precedence of the an operator 
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    } 
       
    
    static String infixToPostfix(String exp) 
    { 
       
        String result = new String(""); 
          
     
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
            
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
           
            else if (c == '(') 
                stack.push(c); 
              
           
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression";                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
                    result += stack.pop(); 
                stack.push(c); 
            } 
       
        } 
       
       
        while (!stack.isEmpty()) 
            result += stack.pop(); 
       
        return result; 
    } 
    
  
    public static void main(String[] args)  
    { 
        String exp = "3+1*(6^4-9)^(2+4*7)-9"; 
        System.out.println(infixToPostfix(exp)); 
    } 
} 
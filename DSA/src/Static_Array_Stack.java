public class Static_Array_Stack {
    Character[] data;
    int top;
    Static_Array_Stack(int size){
        data = new Character[size];
        top=-1;
    }
    public static void main(String[] args) {
        Static_Array_Stack a = new Static_Array_Stack(4);
        System.out.println(a.isValid("[}()"));

    }   

    public void push(Character a){
        data[++top] = a;
    }
    public Character pop(){
        return data[top--];
    }
    public Character peek(){
        return data[top];
    }
    private boolean isEmpty() {
        return top ==-1;
    }
    public boolean isValid(String s){
        Static_Array_Stack a = new Static_Array_Stack(s.length());
        for (char c : s.toCharArray()){
            if (c=='('||c=='['||c=='{'){
                a.push(c);
            }else {
                if ((c == ')' && a.peek() == '(') || (c == ']' && a.peek() == '[') || (c == '}' && a.peek() == '{')){
                    a.pop();
                }else {
                    return false;
                }
            }
        }
        return isEmpty();
    }
}

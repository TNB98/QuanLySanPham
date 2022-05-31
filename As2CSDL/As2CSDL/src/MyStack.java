public class MyStack {
    int maxSize;
    Product[] stack;
    int top ;
    public void MyStack(int max){
        maxSize = max;
        stack = new Product[maxSize];
        top=-1;
    }
    public void push(Product x){
        stack[++top]=x;
    }
    public Product  pop(){
        return stack[top--];
    }
    public Product peck(){
        return stack[top];
    }
    public void display() {
    while (top > -1)   {
        System.out.println(peck());
        top--;
    }
    }
}

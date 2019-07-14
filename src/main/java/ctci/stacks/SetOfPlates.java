package ctci.stacks;

public class SetOfPlates {

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks();
        stacks.threshold = 2;
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        stacks.push(8);
        System.out.println(stacks.pop().data);
        System.out.println(stacks.pop(3).data);
    }
}

class SetOfStacks {
    StackClass stack1 ;
    StackClass stack2;
    StackClass stack3;
    int threshold;
    int size = 0;
    public SetOfStacks(){
        stack1 = new StackClass();
        stack2 = new StackClass();
        stack3 = new StackClass();
    }

    void push(int n){
        StackNode node = new StackNode(n);
        if(stack1.size == threshold){
            if (stack2.size == threshold){
                if(stack3.size == threshold) ;//all stacks full
                stack3.push(node);
            }
            else stack2.push(node);
        }
        else stack1.push(node);
        size ++;
    }
    StackNode pop(){
        size --;

        if(size+1 > 3*threshold) return null;//error;
        else if (size+1 > 2*threshold) return stack3.pop();
        else if(size+1 > threshold) return stack2.pop();
        else return stack1.pop();
    }

    StackNode pop(int index){
        if(index > 3* threshold) return null;
        if(index> 2*threshold){
            return getStackNode(index,3);
        }
        else if (index > threshold) return getStackNode(index,2);
        else  return getStackNode(index,1);
    }

    private StackNode getStackNode(int index, int stackno) {
        int n = threshold - index % threshold;
        int i = 0;
        StackNode ans = null;
        StackNode prev = null;
        StackClass stack = null;
        switch (stackno){
            case 1: stack = stack1;break;
            case 2: stack = stack2;break;
            case 3: stack = stack3;break;
        }
        while(i<n){
            ans = stack.peek();
            prev = ans;

            if(ans.next!=null)
            ans = ans.next;
            i--;
        }
        prev.next = ans.next;
        return ans;
    }
// do left shift
}

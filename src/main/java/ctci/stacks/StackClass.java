package ctci.stacks;

class StackClass{


    StackNode top;
    int size;

    StackNode pop(){
        StackNode t = top;
        top = top.next;
        size --;
        return t;
    }
    void push(StackNode n){
        size++;
        n.next = top;
        top = n;
    }

    public StackNode peek() {
        return top;
    }
}

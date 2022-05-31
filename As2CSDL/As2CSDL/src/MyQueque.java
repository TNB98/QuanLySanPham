public class MyQueque {
    Node head,tail;
    public void myqueque(){
        head = tail = null;
    }
    public boolean isEmpty() {
        return(head==null);
    }

    Object front() throws Exception {
        if(isEmpty()) throw new Exception();
        return(head.info);
    }

    public Product dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        Product x = head.info;
        head=head.next;
        if(head==null) tail=null;
        return(x);
    }
    public void enqueue(Product x) {
        if (isEmpty())
            head = tail = new Node(x);
        else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
    public void  display() {
        int i = 0;
        Node p = new Node();
        p = head;
        while (p != null) {
            i += 1;
            System.out.println(i + " " + p.info);
            p = p.next;
        }
    }


    }

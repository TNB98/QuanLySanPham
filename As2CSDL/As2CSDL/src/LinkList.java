public class LinkList {
    Node head;
    Node tail;
    LinkList(){
        head = null ;
    }
    public void addHead(Product x){
        Node p = new Node(x);
        p.next = head;
        head = p;
    }
    public void addTail(Product x){
        Node p = new Node(x);
        if(head == null){
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
    public  void addMany(Product a[]){
        Node p = new Node();
        p = head;
        for (int  i = 0 ; i < a.length ; i++){
            p.info = a[i];
            p = p.next;
        }
    }


    public void  display(){
        int i = 0 ;
        Node p = new Node();
        p = head;
        while (p!=null){
            i+=1;
            System.out.println(i + " " + p.info);
            p = p.next;
        }
    }

    void deleteNode(Product key)
    {

        Node temp = head, prev = null;


        if (temp != null && temp.info == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.info != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null)
            return;

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    public int length(){
        int i = 0;
        Node p = new Node();
        p = head;
        while (p!=null){
            i+=1;
            p = p.next;
        }
        return i ;
    }

    public void  them(){
        int i = 0 ;
        Product[] a = new Product[length()];
        FileUtil fileUtil = new FileUtil();
        Node p = new Node();
        p = head;
        while (p!=null){
            a[i] = p.info;
            i+=1;
            p = p.next;
        }
        fileUtil.addObjectArray(a);
    }

    public void delete(){
        head = null;
        tail  = null;
    }
}

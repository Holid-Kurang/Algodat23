package algodat;

class myQuickLinkedList<type> {
    public static class Nodes<type>{
        type Isi;
        boolean pivotflag=false;
        Nodes<type> next,prev;
        Nodes(type input){
            this.Isi = input;
        }
    }
    Nodes<type> head, tail;
    public void addtotail(type input){
        if(head==null){
            head = new Nodes<>(input);
            tail = head;
        }
        else{
            Nodes<type> temp = tail;
            temp.next = new Nodes<type>(input);
            temp.next.prev = temp;
            tail = temp.next;
        }
    }
    public void QuickSortAct(Nodes<Integer> awal,Nodes<Integer> atas){
        int pivot = atas.Isi,save;
        Nodes<Integer> curr=awal,currToend = awal;
        boolean first = true;
        
        while(curr!=atas){
            if(curr.Isi<=pivot){
                if(first){
                    first = false;
                }else{
                    currToend = currToend.next;
                }
                save = curr.Isi;
                curr.Isi = currToend.Isi;
                currToend.Isi = save;
            }
            curr = curr.next;
        }
        save = curr.Isi;
        curr.Isi = currToend.next.Isi;
        currToend.next.Isi = save;
        
        Nodes<Integer> savepivot = currToend.next;
        savepivot.pivotflag = true;
        
        curr = savepivot.next;
        currToend = savepivot.next;
        while(currToend.next!=null){
            if(currToend.next.pivotflag)break;        
            currToend = currToend.next;
        }
        if(curr!=currToend)QuickSortAct(curr, currToend);
        
        curr = savepivot.prev;
        currToend = savepivot.prev;
        while(currToend.prev!=null){
            if(currToend.prev.pivotflag)break;
            currToend = currToend.prev;
        }
        if(curr!=currToend)QuickSortAct(currToend, curr);
    }
    public void print(){
        Nodes<type> curr =head;
        while(curr!=null){
            System.out.print(curr.Isi);
            if(curr.next!=null)System.out.print(" => ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class TempatTesting{

	public static void main(String[] args) {
        myQuickLinkedList<Integer> Qc = new myQuickLinkedList<Integer>();
        Qc.addtotail(6);
        Qc.addtotail(8);
        Qc.addtotail(5);
        Qc.addtotail(9);
        Qc.addtotail(5);
        Qc.addtotail(10);
        Qc.addtotail(7);
        Qc.print();
        Qc.QuickSortAct(Qc.head, Qc.tail);
        Qc.print();
    }

}


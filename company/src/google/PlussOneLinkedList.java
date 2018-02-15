package google;

public class PlussOneLinkedList {
	ListNode* plusOne(ListNode* head) {
        if(head == nullptr){
            ListNode *p = new ListNode(1);
            return p;
        }
        ListNode *p = head;
        ListNode *p2 = nullptr;
        while(p != nullptr){
            if(p->val < 9)
                p2 = p;
            p = p->next;
        }
        if(p2 == nullptr){
            ListNode *h = new ListNode(1);
            h->next = head;
            p2 = head;
            head = h;
            
        }else{
            p2->val++;
            p2 = p2->next;
        }
        while(p2 != nullptr){
            p2->val = 0;
            p2 = p2->next;
        }
        return head;
    }

}

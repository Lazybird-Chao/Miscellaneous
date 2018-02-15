package google;

public class LinkedListRandomNode {
	ListNode *head;
    Solution(ListNode* head) {
        this->head = head;
        srand(time(NULL));
    }
    
    /** Returns a random node's value. */
    int getRandom() {
        int count = 1;
        ListNode *choose = head;
        ListNode *p = head->next;
        
        while(p!= nullptr){
            count++;
            int prob = random()%count + 1;
            //cout<<prob<<" "<<count<<endl;
            if(prob == 1)
                choose = p;
            p = p->next;
        }
        //cout<<endl;
        return choose->val;
    }

}

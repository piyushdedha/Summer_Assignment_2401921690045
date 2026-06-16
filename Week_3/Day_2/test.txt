1. Merge Two Sorted Lists :-

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode dummy;
    struct ListNode *tail = &dummy;
    dummy.next=NULL;
    while (list1!=NULL && list2!=NULL) {
        if (list1->val<=list2->val) {
            tail->next=list1;
            list1=list1->next;
        } else{
            tail->next=list2;
            list2=list2->next;
        }
        tail=tail->next;
    }
    if(list1!=NULL){
        tail->next=list1;
    } else{
        tail->next=list2;
    }
    return dummy.next;
}


2. Remove Nth Node From End of List :-


struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode dummy;
    dummy.next = head;
    struct ListNode *fast = &dummy;
    struct ListNode *slow = &dummy;
    for (int i=0;i<=n;i++){
        fast=fast->next;
    }
    while(fast!=NULL){
        fast=fast->next;
        slow=slow->next;
    }
    slow->next=slow->next->next;
    return dummy.next;
}


3. Palindrome Linked List :-

bool isPalindrome(struct ListNode* head) {
    struct ListNode *slow = head;
    struct ListNode *fast = head;
    while(fast!=NULL && fast->next!=NULL) {
        slow=slow->next;
        fast=fast->next->next;
    }
    struct ListNode *prev = NULL;
    struct ListNode *curr = slow;
    struct ListNode *nextNode;
    while(curr!=NULL){
        nextNode=curr->next;
        curr->next=prev;
        prev=curr;
        curr=nextNode;
    }
    struct ListNode *left = head;
    struct ListNode *right = prev;
    while (right!=NULL){
        if (left->val!=right->val) {
            return false;
        }
        left=left->next;
        right=right->next;
    }
    return true;
}

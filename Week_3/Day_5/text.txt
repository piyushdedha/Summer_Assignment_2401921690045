1. Implement Queue using Stacks :-

typedef struct {
    int stack1[100];
    int stack2[100];
    int top1;
    int top2;
} MyQueue;

MyQueue* myQueueCreate() {
    MyQueue* q =(MyQueue*)malloc(sizeof(MyQueue));
    q->top1=-1;
    q->top2=-1;
    return q;
}
void myQueuePush(MyQueue* obj,int x) {
    obj->stack1[++obj->top1]=x;
}
int myQueuePop(MyQueue* obj) {
    if(obj->top2==-1) {
        while(obj->top1!=-1) {
            obj->stack2[++obj->top2]=obj->stack1[obj->top1--];
        }
    }
    return obj->stack2[obj->top2--];
}
int myQueuePeek(MyQueue* obj) {
    if (obj->top2 == -1) {
        while (obj->top1 != -1) {
            obj->stack2[++obj->top2] = obj->stack1[obj->top1--];
        }
    }
    return obj->stack2[obj->top2];
}
bool myQueueEmpty(MyQueue* obj) {
    return (obj->top1 == -1 && obj->top2 == -1);
}
void myQueueFree(MyQueue* obj) {
    free(obj);
}

2. Number of Recent Calls :-

typedef struct {
    int q[10000];
    int front;
    int rear;
} RecentCounter;

RecentCounter* recentCounterCreate() {
    RecentCounter* obj = (RecentCounter*)malloc(sizeof(RecentCounter));
    obj->front=0;
    obj->rear=-1;
    return obj;
}
int recentCounterPing(RecentCounter* obj, int t) {
    obj->q[++obj->rear]=t;
    while (obj->q[obj->front]<t-3000) {
        obj->front++;
    }
    return obj->rear-obj->front+1;
}
void recentCounterFree(RecentCounter* obj) {
    free(obj);
}


3. Sliding Window Maximum :-

int* maxSlidingWindow(int* nums, int numsSize, int k, int* returnSize) {
    *returnSize = numsSize - k + 1;

    int* result = (int*)malloc((*returnSize) * sizeof(int));
    int deque[100000];
    int front=0,rear=-1;
    int idx=0;
    for(int i=0;i<numsSize;i++) {
        while(front<=rear && deque[front]<=i-k) {
            front++;
        }
        while(front<=rear && nums[deque[rear]]<=nums[i]) {
            rear--;
        }
        deque[++rear]=i;
        if(i>=k-1){
            result[idx++] = nums[deque[front]];
        }
    }
    return result;
}

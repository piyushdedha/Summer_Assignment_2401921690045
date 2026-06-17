1. Valid Parentheses :-

bool isValid(char* s) {
    char stack[10000];
    int top=-1;
    for (int i=0;s[i];i++) {
        if(s[i]=='('|| s[i]=='{'||s[i]=='[')
            stack[++top] = s[i];
        else{
            if(top==-1) return false;
            char c=stack[top--];
            if((s[i] ==')' && c!='(')||
                (s[i] == '}' && c != '{') ||
                (s[i] == ']' && c != '['))
                return false;
        }
    }
    return top==-1;
}

2. Min Stack :-

typedef struct {
    int arr[30000];
    int minArr[30000];
    int top;
} MinStack;
MinStack* minStackCreate() {
    MinStack* s = (MinStack*)malloc(sizeof(MinStack));
    s->top = -1;
    return s;
}
void minStackPush(MinStack* s, int val) {
    s->top++;
    s->arr[s->top] = val;
    if (s->top == 0)
        s->minArr[s->top] = val;
    else if (val < s->minArr[s->top - 1])
        s->minArr[s->top] = val;
    else
        s->minArr[s->top] = s->minArr[s->top - 1];
}
void minStackPop(MinStack* s) {
    s->top--;
}
int minStackTop(MinStack* s) {
    return s->arr[s->top];
}
int minStackGetMin(MinStack* s) {
    return s->minArr[s->top];
}
void minStackFree(MinStack* s) {
    free(s);
}


3. Next Greater Element I :-

int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    *returnSize=nums1Size;
    int* result = (int*)malloc(nums1Size * sizeof(int));
    for (int i=0;i<nums1Size;i++) {
        result[i]=-1;
        int found=0;
        for (int j=0;j<nums2Size;j++) {
            if (nums2[j]==nums1[i]) {
                found=1;
                continue;
            }
            if(found && nums2[j]>nums1[i]) {
                result[i]=nums2[j];
                break;
            }
        }
    }
    return result;
}

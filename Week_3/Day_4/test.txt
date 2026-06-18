1. Daily Temperatures :-

int* dailyTemperatures(int* temperatures, int temperaturesSize, int* returnSize) {
    *returnSize = temperaturesSize;
    int* result = (int*)malloc(temperaturesSize * sizeof(int));
    for (int i=0; i<temperaturesSize;i++) {
        result[i]=0;
        for (int j=i+1;j<temperaturesSize;j++) {
            if (temperatures[j]>temperatures[i]) {
                result[i]=j-i;
                break;
            }
        }
    }
    return result;
}


2. Evaluate Reverse Polish Notation :-

int* dailyTemperatures(int* temperatures, int temperaturesSize, int* returnSize) {
    *returnSize = temperaturesSize;

    int* result = (int*)calloc(temperaturesSize, sizeof(int));
    int* stack = (int*)malloc(temperaturesSize * sizeof(int));
    int top=-1;
    for (int i=0;i<temperaturesSize;i++){
        while (top>=0 && temperatures[i]>temperatures[stack[top]]) {
            int prevDay=stack[top--];
            result[prevDay]=i-prevDay;
        }
        stack[++top]=i;
    }
    free(stack);
    return result;
}


3. Largest Rectangle in Histogram :-

int largestRectangleArea(int* heights, int heightsSize) {
    int* stack = (int*)malloc(sizeof(int) * (heightsSize + 1));
    int top = -1;
    int maxArea = 0;

    for(int i=0;i<=heightsSize;i++) {
        int currHeight=(i==heightsSize)?0:heights[i];
        while (top>=0 && currHeight<heights[stack[top]]) {
            int h=heights[stack[top--]];
            int width;
            if(top==-1)
                width=i;
            else
                width=i-stack[top]-1;
            int area=h*width;
            if (area>maxArea)
                maxArea = area;
        }
        stack[++top] = i;
    }
    free(stack);
    return maxArea;
}

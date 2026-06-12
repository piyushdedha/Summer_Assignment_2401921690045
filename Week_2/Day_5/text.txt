1. Group Anagrams :-

int compareChars(const void *a, const void *b) {
    return (*(char *)a -*(char*)b);
}
char*** groupAnagrams(char** strs, int strsSize, int* returnSize, int** returnColumnSizes) {
    char ***result = malloc(strsSize * sizeof(char **));
    *returnColumnSizes = malloc(strsSize * sizeof(int));
    char **sortedWords = malloc(strsSize * sizeof(char *));
    int groupCount=0;
    for (int i = 0; i < strsSize; i++) {
        sortedWords[i] = strdup(strs[i]);
        qsort(sortedWords[i], strlen(sortedWords[i]), sizeof(char), compareChars);
    }
    int *groupIndex = malloc(strsSize * sizeof(int));
    for(int i=0;i<strsSize;i++){
        groupIndex[i]=-1;
        for (int j=0;j<i;j++) {
            if (strcmp(sortedWords[i], sortedWords[j]) == 0) {
                groupIndex[i]=groupIndex[j];
                break;
            }
        }
        if(groupIndex[i] == -1){
            groupIndex[i] = groupCount;
            result[groupCount] = malloc(strsSize * sizeof(char *));
            (*returnColumnSizes)[groupCount] = 0;
            groupCount++;
        }
        int currentGroup = groupIndex[i];
        int pos = (*returnColumnSizes)[currentGroup];
        result[currentGroup][pos] = strs[i];
        (*returnColumnSizes)[currentGroup]++;
    }
    *returnSize=groupCount;
    for (int i=0;i<strsSize;i++) {
        free(sortedWords[i]);
    }
    free(sortedWords);
    free(groupIndex);
    return result;
}

2. String Compression :-

int compress(char* chars, int charsSize) {
    int write=0;
    int i=0;
    while(i<charsSize){
        char current=chars[i];
        int count=0;
        while(i<charsSize&&chars[i]==current) {
            count++;
            i++;
        }
        chars[write++]=current;
        if(count>1){
            char num[12];
            sprintf(num,"%d",count);
            for (int j=0;num[j]!='\0';j++) {
                chars[write++]=num[j];
            }
        }
    }
    return write;
}


3. Longest Palindromic Substring :-

char* longestPalindrome(char* s) {
    int n=strlen(s);
    if (n<2) {
        return s;
    }
    int start=0;
    int maxLen=1;
    for (int i=0;i<n;i++) {
        int left=i;
        int right=i;
        while (left>=0 && right<n&&s[left]==s[right]) {
            if (right-left+1>maxLen) {
                maxLen=right-left+1;
                start=left;
            }
            left--;
            right++;
        }
        left=i;
        right=i+1;
        while(left>=0&&right<n&&s[left]==s[right]) {
            if (right-left+1>maxLen) {
                maxLen=right-left+1;
                start=left;
            }
            left--;
            right++;
        }
    }
    char *answer=(char *)malloc((maxLen+1)*sizeof(char));
    strncpy(answer,s+start, maxLen);
    answer[maxLen]='\0';
    return answer;
}

1. Longest Substring Without Repeating Characters :-


int lengthOfLongestSubstring(char* s) {
    int count[128]={0};
    int start=0;
    int longest=0;
    int end=0;
    for(end=0;s[end]!='\0';end++){
         count[s[end]]++;
        while (count[s[end]]>1) {
            count[s[start]]--;
            start++;
        }
        int len=end-start+1;
        if (len>longest){
            longest=len;
        }
    }
    return longest;
}


2. Permutation in String :-

   
bool checkInclusion(char* s1, char* s2) {
    int len1=strlen(s1);
    int len2=strlen(s2);
    if (len1>len2) {
        return false;
    }
    int count1[26]={0};
    int count2[26]={0};
    for (int i=0;i<len1;i++) {
        count1[s1[i]-'a']++;
        count2[s2[i]-'a']++;
    }
    for (int start=0;start<=len2-len1;start++) {
        int match=1;
        for (int i=0;i<26;i++){
            if (count1[i]!=count2[i]) {
                match=0;
                break;
            }
        }
        if(match){
            return true;
        }
        if(start+len1<len2) {
            count2[s2[start]-'a']--;
            count2[s2[start+len1]-'a']++;
        }
    }
    return false;
}


3. Find All Anagrams in a String :-


int* findAnagrams(char* s, char* p, int* returnSize) {
    int n = strlen(s);
    int m = strlen(p);
    int *ans = malloc(sizeof(int) * n);
    *returnSize = 0;
    if (m>n) {
        return ans;
    }
    int a[26]={0};
    int b[26]={0};
    for (int i=0;i<m;i++) {
        a[p[i]-'a']++;
        b[s[i]-'a']++;
    }
    for (int i=0;i<=n-m;i++) {
        int ok=1;
        for (int j=0;j<26;j++) {
            if (a[j]!=b[j]) {
                ok=0;
                break;
            }
        }
        if(ok){
            ans[(*returnSize)++] = i;
        }
        if(i+m<n) {
            b[s[i]-'a']--;
            b[s[i+m]-'a']++;
        }
    }
    return ans;
}

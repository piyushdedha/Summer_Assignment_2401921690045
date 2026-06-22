1. Maximum Depth of Binary Tree :-

int maxDepth(struct TreeNode* root) {
    if(root==NULL){
        return 0;
    }
    int leftDepth=maxDepth(root->left);
    int rightDepth=maxDepth(root->right);
    if(leftDepth>rightDepth){
        return leftDepth+1;
    }
    return rightDepth+1;
}

2. Invert Binary Tree :-

struct TreeNode* invertTree(struct TreeNode* root) {
    if(root==NULL){
        return NULL;
    }
    struct TreeNode*temp = root->left;
    root->left=root->right;
    root->right=temp;
    invertTree(root->left);
    invertTree(root->right);
    return root;
}

3. Same Tree :-

bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
    if (p==NULL&&q==NULL){
        return true;
    }
    if(p==NULL||q==NULL){
        return false;
    }
    if(p->val!=q->val){
        return false;
    }
    return isSameTree(p->left, q->left) &&
           isSameTree(p->right, q->right);
}

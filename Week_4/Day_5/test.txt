1. Symmetric Tree :-

bool check(struct TreeNode* left, struct TreeNode* right) {
    if(left==NULL && right==NULL)
        return true;
    if(left==NULL || right==NULL)
        return false;
    if(left->val!=right->val)
        return false;
    return check(left->left, right->right) &&
           check(left->right, right->left);
}
bool isSymmetric(struct TreeNode* root) {
    if(root==NULL)
        return true;
    return check(root->left, root->right);
}

2. Construct Binary Tree from Preorder and Inorder Traversal :-

struct TreeNode* create(int* preorder, int preStart, int preEnd,
                        int* inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd)
        return NULL;
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = preorder[preStart];
    root->left = NULL;
    root->right = NULL;
    int index = inStart;
    while (inorder[index] != root->val)
        index++;
    int leftSize = index - inStart;

    root->left = create(preorder, preStart + 1, preStart + leftSize,
                        inorder, inStart, index - 1);

    root->right = create(preorder, preStart + leftSize + 1, preEnd,
                         inorder, index + 1, inEnd);

    return root;
}
struct TreeNode* buildTree(int* preorder, int preorderSize, int* inorder, int inorderSize) {
    return create(preorder, 0, preorderSize - 1,
                  inorder, 0, inorderSize - 1);
}

3. Serialize and Deserialize Binary Tree :-

class Codec:
    def serialize(self, root):
        ans = []
        def dfs(node):
            if not node:
                ans.append("#")
                return
            ans.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return ",".join(ans)
    def deserialize(self, data):
        values=data.split(",")
        idx=[0]
        def dfs():
            if values[idx[0]] == "#":
                idx[0]+=1
                return None
            node=TreeNode(int(values[idx[0]]))
            idx[0]+=1
            node.left=dfs()
            node.right=dfs()
            return node
        return dfs()

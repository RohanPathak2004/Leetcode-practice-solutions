/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* buildBst(ListNode* head) {
        if(head == nullptr) return nullptr;
        if(head->next == nullptr) return new TreeNode(head->val);
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* s = head;
        ListNode* f = head;
        ListNode* t = dummy;
        while(f!=nullptr&&f->next!=nullptr){
            s = s->next;
            t = t->next;
            f = f->next->next;
        }
        t->next = nullptr;
        dummy->next = nullptr;
        ListNode* rightList = s->next;
        ListNode* leftList = head;
        TreeNode* root = new TreeNode(s->val);
        TreeNode* left = buildBst(leftList);
        TreeNode* right = buildBst(rightList);
        s == NULL;
        f == NULL;
        t == NULL;
        dummy == NULL;
        root->left = left;
        root->right = right;
        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        return buildBst(head);
    }
};
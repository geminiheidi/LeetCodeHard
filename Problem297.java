/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Problem297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            String res = "[]";
            return res;
            
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String res = "[";
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            
            if(cur != null){
                res = res + cur.val + ",";
                
                queue.offer(cur.left);
                queue.offer(cur.right);   
            } else {
                res = res + "null,";
            }   
        }
        int valid = res.length() - 1;
        for(int i = res.length() - 1; i >= 0; i--){
            if(Character.isDigit(res.charAt(i))){
                valid = i;
                break;
            }
        }
        
        res = res.substring(0, valid + 1) + "]";
        
        return res;
        
        
        
       
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String sub = data.substring(1, data.length() - 1);
        //System.out.println(sub);
        if(sub.length() == 0) return null;
        
        
        String[] strArray = sub.split(","); 
        
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArray[0]));
        queue.offer(root);
        TreeNode cur = root;
        int index = 1;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(index < strArray.length){
                if(!strArray[index].equals("null") ){
                    cur.left = new TreeNode(Integer.parseInt(strArray[index])); 
                    queue.offer(cur.left);  
                } else {
                    cur.left = null;
                }
                index++;    
            }
            if(index < strArray.length){
                if(!strArray[index].equals("null") ){
                    cur.right = new TreeNode(Integer.parseInt(strArray[index])); 
                    queue.offer(cur.right);  
                } else {
                    cur.right = null;
                }
                index++;
            }   
        }
        return root;    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

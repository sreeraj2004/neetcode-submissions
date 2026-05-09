public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    // Helper for serialization (Preorder DFS)
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N").append(","); // Use 'N' to mark nulls
        } else {
            sb.append(node.val).append(","); // Append value and a comma delimiter
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the string by commas and put it into a Queue
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    // Helper for deserialization
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        
        // If we hit our null marker, return null
        if (val.equals("N")) {
            return null;
        }
        
        // Create the node
        TreeNode node = new TreeNode(Integer.parseInt(val));
        
        // Recursively build the left and right subtrees
        // Because it's a queue, it perfectly matches the Preorder order we saved it in
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        
        return node;
    }
}
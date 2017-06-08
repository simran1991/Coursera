import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	private TreeNode root;
	static int noOfNodes=0;
	private TreeNode temp;
	
	public void insertNode(int data){
		temp=new TreeNode(data);
		
		if(root==null){
			root=temp;
			noOfNodes++;
		}else{
			insertHelper(temp,root);
		}
	}
	
	public int getNode(int key){
		if(root!=null && root.getData()==key){
			return 0;
		}else{
			temp=root;
			while(temp!=null){
				
				if(key==temp.getData()){
					return 0;
				}else if(key<temp.getData()){
					temp=temp.getLeft();
				}else{
					temp=temp.getRight();
				}
			}
			return -1;
		}
	}
	private int getNodeHelper(int key,TreeNode node) {
		
		while(node.getLeft()!=null ){
			if(node.getLeft().getData()==key){
				return node.getLeft().getData();
			}else{
				getNodeHelper(key, node.getLeft()); 
			}
		}
		
		while(node.getRight()!=null){
			if(node.getRight().getData()==key){
				return node.getRight().getData();
			}else{
				getNodeHelper(key, node.getRight());
			}
		}
		return -1;
	}
	

	private void insertHelper(TreeNode temp2,TreeNode rootNode) {
		// TODO Auto-generated method stub
		if(temp2.getData()<rootNode.getData()){
			if(rootNode.getLeft()==null){
				rootNode.setLeft(temp2);
				noOfNodes++;
			}else{
				insertHelper(temp2, rootNode.getLeft());
			}
			
		}else{
			if(rootNode.getRight()==null){
				rootNode.setRight(temp2);
				noOfNodes++;
			}else{
				insertHelper(temp2, rootNode.getRight());
			}
		}
	}
	
	public void levelOrderQueue(TreeNode root){
 		Queue<TreeNode> q = new LinkedList<>();
 		int levelNodes =0; 
		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
 				TreeNode n = (TreeNode)q.remove();
				System.out.print(" " + n.getData());
				if(n.getLeft()!=null) q.add(n.getLeft());
				if(n.getRight()!=null) q.add(n.getRight());
				levelNodes--;
			}
			System.out.println("\n------");
		}
	}
	/**
     * Print a tree
     * 
     * @param root
     *            tree root node
     */
    public static void print(TreeNode root)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = Integer.toString(n.getData()) ;
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

	public static void main(String[] args) {
		BinaryTree btr=new BinaryTree();
		btr.insertNode(5);
		btr.insertNode(11);
		btr.insertNode(3);
		btr.insertNode(2);
		btr.insertNode(9);
		btr.insertNode(20);
		btr.insertNode(21);
		btr.insertNode(1);
		btr.insertNode(4);
		btr.insertNode(48);
		btr.insertNode(38);
		btr.insertNode(28);
		btr.insertNode(18);
		btr.insertNode(8);
		btr.insertNode(19);
		btr.insertNode(29);
		
		btr.print(btr.root);
		System.out.println(btr.getNode(21));
	}

}

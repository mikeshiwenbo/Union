
public class Final {
	/*
	 *		  0               0          
	 *       /             / / \ \     
	 *      1             1  2  3 4     
	 *     /                          
	 *    2                        
	 *   /            
	 *  3             
	 * /
	 *4 
	 *理论上这个算法更优，实际操作时可能会比路径压缩慢
	 */
	private int[] id;
	private int count;
	public Final(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		
	}
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int find(int p){
		if(p!=id[p]){
			id[p]=find(id[p]); } //使用递归函数找到最后根节点，并把根节点一次赋予每一个子节点，形成高度为2的树
		return id[p];}
	public void union(int p,int q){
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot==qRoot){
			return;
		}
		id[pRoot]=qRoot;
		count--;
		
	}
}

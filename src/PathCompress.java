
public class PathCompress {
	/**
	 * 	此算法为路径压缩算法，算法过程如下：
	 *        0             0          0
	 *       /             /          / \
	 *      1             1          1   2
	 *     /             /              / \
	 *    2             2              3   4
	 *   /             / \
	 *  3             3   4
	 * /
	 *4 
	 *这是初始的树；                     步骤一                                      步骤二
	 */
	private int[] id;
	private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数
	private int count;
	public PathCompress(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		rank=new int[N];
		for(int i=0;i<N;i++){
			rank[i]=i;
		}
		
	}
	public int count(){
		return count;
	}
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	public int find(int p){
		while(p!=id[p]){ 
			id[p]=id[id[p]]; //将p指向父亲的父亲
			p=id[p];
		}
		return id[p];
	}
	public void union(int p,int q){
		int i=find(p);
		int j=find(q);
		if(i==j){
			return;
		}
		if(rank[i]<rank[j]){
			id[i]=j;  //此时不需要维护，因为i的层数小于j的层数，至少小于1，加上i的层数后，不会使j的层数改变
		}else if(rank[i]>rank[j]){
			id[j]=i;
		}else{
			id[i]=j;  //此时i指向了j，因此使j的层数加一
			rank[j]+=1;
		}
		count--;
	}
}

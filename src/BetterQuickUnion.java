
public class BetterQuickUnion {
//	此算法为到目前为止效率最高的归类算法，它基于QuickFind算法，灵活的将两个类中小类转换为较大的类
	//此算法引入rank数组
	private int[] id;
	private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数
	private int count;
	public BetterQuickUnion(int N){
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
		while(p!=id[p]) p=id[p];
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


public class QuickFind {
//	此算法为改善的归类算法，基于数组下标在最初应和其内容一致，若不一致，则找出其最“根本”的值，并最“根本”的那个值赋予id[p]
	private int[] id;
	private int count;
	public QuickFind(int N){
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
		while(p!=id[p]) p=id[p]; //找出最根本的根节点
		return p;
	}
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


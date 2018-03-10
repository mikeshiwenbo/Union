
public class QuickUnion {
//	此算法为到目前为止效率最高的归类算法，它基于QuickFind算法，灵活的将两个类中小类转换为较大的类
	private int[] id;
	private int[] sz;
	private int count;
	public QuickUnion(int N){
		count=N;
		id=new int[N];
		for(int i=0;i<N;i++){
			id[i]=i;
		}
		sz=new int[N];
		for(int i=0;i<N;i++){
			sz[i]=i;
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
		if(sz[i]<sz[j]){
			id[i]=j;
			sz[j]+=sz[i];
		}else{
			id[j]=i;
			sz[i]+=sz[j];
		}
		count--;
	}
}

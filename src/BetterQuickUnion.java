
public class BetterQuickUnion {
//	���㷨Ϊ��ĿǰΪֹЧ����ߵĹ����㷨��������QuickFind�㷨�����Ľ���������С��ת��Ϊ�ϴ����
	//���㷨����rank����
	private int[] id;
	private int[] rank; //rank[i]��ʾ��iΪ���ļ�������ʾ�����Ĳ���
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
			id[i]=j;  //��ʱ����Ҫά������Ϊi�Ĳ���С��j�Ĳ���������С��1������i�Ĳ����󣬲���ʹj�Ĳ����ı�
		}else if(rank[i]>rank[j]){
			id[j]=i;
		}else{
			id[i]=j;  //��ʱiָ����j�����ʹj�Ĳ�����һ
			rank[j]+=1;
		}
		count--;
	}
}
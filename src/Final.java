
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
	 *����������㷨���ţ�ʵ�ʲ���ʱ���ܻ��·��ѹ����
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
			id[p]=find(id[p]); } //ʹ�õݹ麯���ҵ������ڵ㣬���Ѹ��ڵ�һ�θ���ÿһ���ӽڵ㣬�γɸ߶�Ϊ2����
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

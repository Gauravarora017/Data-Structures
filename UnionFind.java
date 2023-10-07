public class MyUnionFind {
    private int size;
    private int numset;
    private int[] sz;
    private int[] id;

    public MyUnionFind() throws Exception {
        this(10);
    }

    public MyUnionFind(int size) throws Exception {
        if(size<=0)
            throw new Exception("IndexOutOfBoundsException");
        this.size = size;
        numset = size;
        sz = new int[size];
        id = new int[size];

        for(int i=0;i<size;i++){
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int getSize(){
        return size;
    }

    public int getComp(){
        return numset;
    }

    public void insert(int index, int p){
        sz[index] = p;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int CompSize(int p) {
        return sz[find(p)];
    }

    public int find(int p) {

        int temp = p;
        while (temp != id[temp])
            temp = id[temp];

        while (p != temp) {
            int next = id[p];
            id[p] = temp;
            p = next;
        }
        return temp;
    }

    public void unify(int p, int q) {

        int root1 = find(p);
        int root2 = find(q);

        if (root1 == root2)
            return;
        else{
            if (sz[root1] < sz[root2]) {
                sz[root2] += sz[root1];
                id[root1] = root2;
            }
            else {
                sz[root1] += sz[root2];
                id[root2] = root1;
            }
            numset--;
        }
    }

    public void printUnion(){
        for(int i=0;i<size;i++)
            System.out.print(sz[i] + " ");
    }
}

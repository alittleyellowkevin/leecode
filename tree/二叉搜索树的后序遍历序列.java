package tree;

public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return judge(sequence,0,sequence.length-1);
    }

    public boolean judge(int[] a,int start,int end){
        if(start >= end){
            return true;
        }
        int i = start;
        while(a[i] < a[end]){
            ++i;
        }
        for(int j=i;j<end;j++){
            if(a[j] < a[end]){
                return false;
            }
        }
        return judge(a,start,i-1) && judge(a,i,end-1);
    }
}

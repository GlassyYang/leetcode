public class Solution564 {

    public String nearestPalindromic(String n) {
        Long nInt = Long.parseLong(n);
        if(nInt==11)
            return 9+"";
        else if(nInt<=10)
            return Math.abs(nInt-1)+"";

        //如果位数为偶数则为0，否则为1
        int mid = n.length()%2;
        //为最中间数的索引，索引是从0开始的
        int m = n.length()/2;
        String strPre=null;
        //获取前面一半
        if(mid==1)
            strPre = n.substring(0,m+1);
        else
            strPre = n.substring(0,m);

        //如果自身是回文数
        if(new StringBuffer(n).reverse().toString().equals(n)){

            Long middle = Long.parseLong(n.charAt(m)+"");
            if(middle==0||middle==9){
                if(isTenMultiple(Long.parseLong(n)+1+"")){
                    return Long.parseLong(n)+2+"";
                }else if(isTenMultiple(Long.parseLong(n)-1+"")){
                    return Long.parseLong(n)-2+"";
                }
                Long temp1 = Long.parseLong(Result(mid,Long.parseLong(strPre)+1+""));
                Long temp2 = Long.parseLong(Result(mid,Long.parseLong(strPre)-1+""));
                if(temp1-nInt<nInt-temp2)
                    return temp1+"";
                else
                    return temp2+"";

            }else{
                strPre = Long.parseLong(strPre)-1+"";
                return Result(mid,strPre);
            }
        }else if(isTenMultiple(n)){//如果是 99,999,9999这种数
            return nInt-1+"";
        }else{//否则进行去中间数+1，-1，和中间数不变三个进行比较
            Long temp1 = Long.parseLong(Result(mid,Long.parseLong(strPre)+1+""));
            Long temp2 = Long.parseLong(Result(mid,Long.parseLong(strPre)-1+""));
            Long temp3 = Long.parseLong(Result(mid,Long.parseLong(strPre)+""));
            if(temp1-nInt<nInt-temp2 && temp1-nInt<Math.abs(temp3-nInt))
                return temp1+"";
            else if(nInt-temp2<temp1-nInt && nInt-temp2<=Math.abs(temp3-nInt))
                return temp2+"";
            else
                return temp3+"";
        }

    }
    //根据奇数或者偶数位与前缀返回回文数
    public String Result(int mid,String strPre){
        String strSuf = new StringBuffer(strPre).reverse().toString();
        //如果位数是奇数
        if(mid==1)
            return strPre+strSuf.substring(1);
        else
            return strPre+strSuf;
    }
    public boolean isTenMultiple(String n){
        return (n.charAt(0)=='1' && Long.parseLong(n.substring(1))==0);
    }

}

public class Solution38 {

    private StringBuilder getNext(StringBuilder res){
        StringBuilder s=new StringBuilder();
        int start=0,n=res.length();
        for(int i=1;i<n;i++)
            if(res.charAt(i)!=res.charAt(start)){
                s.append(i-start).append(res.charAt(start));
                start=i;
            }
        return s.append(res.length()-start).append(res.charAt(start));
    }

    public String countAndSay(int n) {
        StringBuilder res=new StringBuilder();
        res.append(1);
        for(int i=1;i<n;i++)res=getNext(res);
        return res.toString();
    }

}

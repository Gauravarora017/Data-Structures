package com.company.string;

public class kmp_construction_lps {
    static int longPropPreSuff(String str, int n){
        System.out.println(n-1);
        for(int len=n-1;len>0;len--){
            System.out.println(len);
            boolean flag=true;
            for(int i=0;i<len;i++)
                if(str.charAt(i)!=str.charAt(n-len+i))
                    flag=false;

            if(flag==true)
                return len;
        }
        return 0;
    }

    static void naive_fillLPS(String str, int lps[]){
        for(int i=0;i<str.length();i++){
            lps[i]=longPropPreSuff(str,i+1);
        }
    }
    static void efficient_fillLPS(String str, int lps[]){
        int n=str.length(),len=0;
        lps[0]=0;
        int i=1;
        while(i<n){
            if(str.charAt(i)==str.charAt(len))
            {len++;lps[i]=len;i++;}
            else
            {if(len==0){lps[i]=0;i++;}
            else{len=lps[len-1];}
            }
        }
    }

    public static void main(String args[])
    {   String txt = "aaacabad";int[] lps=new int[txt.length()];
        efficient_fillLPS(txt,lps);
        for(int i=0;i<txt.length();i++){
            System.out.print(lps[i]+" ");
        }
    }
}

package com.example.stackandqueue;
import java.util.Stack;
public class _10NearestSmallerElement {
    public int[] prevSmaller(int[] A) {

        int[] ans=new int[A.length];
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<A.length;i++)
        {
            if(st.isEmpty())
            {
                ans[i]=-1;
            }
            else if(st.size()>0 && st.peek()<A[i])
            {
                ans[i]=st.peek();
            }
            else if(st.size()>0 && st.peek()>=A[i])
            {
                while(st.size()>0 && st.peek()>=A[i])
                    st.pop();

                if(st.size()==0)
                    ans[i]=-1;
                else
                    ans[i]=st.peek();
            }

            st.push(A[i]);
        }

        return ans;
    }
}

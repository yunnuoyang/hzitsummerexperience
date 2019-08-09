package com.b.linknode;

import org.junit.Test;

public class SingleList<T> {
    private SNode head;

    public void   add(T t){
        SNode<T> curNode=new SNode<T>(t);
        if(head==null){
            head=curNode;
        }else {
        SNode<T> temp=head;//临时存储节点
        while(temp.next!=null){
            temp=temp.next;//将最后一个节点迭代出来
        }
            temp.next=curNode;
        }

    }
    @Test
    public void test(){
        SingleList<String> list=new SingleList();
        list.add("234");
        list.add("abc");
        list.add("kls");
        System.out.println(list);
    }






    private class SNode<T>{
        SNode next;
        T value;

        public SNode(T value) {
            this.value = value;
        }
    }
}

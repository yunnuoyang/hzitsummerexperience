package com.b.linknode;

import org.junit.Test;

import java.util.LinkedList;

public class LinkList {
    private Node node;//当前元素
    Node first=null;//上一个节点
    Node last;//下一个节点
    int index=0;


    public LinkList() {

    }



    /**
     *双链表添加操作
     * @param element
     */
    public void add(Object element){
        Node node=new Node(element);
        //当添加第一个元素的时候
        if(first==null){
            first=node;
            last=node;
            index++;
        }
        else {
            //当前节点是最后一个节点
            //当前节点的前一个节点时原来最后的一个节点
            node.previous=last;
            //当前节点变成了最后一个节点，其的下一个节点为空
            node.next=null;
            //原来的节点变为了倒数第二个节点，他的下一个节点是当前节点
            last.next=node;
            //当前节点是最后一个节点
            last=node;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Node first = this.first;
        while(first!=null){
            Object value = first.value;
            sb.append(","+value);
            first=first.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkList linkList=new LinkList();
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);
        System.out.println(linkList);
        System.out.println("====");
    }
}
class Node{
    Node previous;
    Node next;

    Object value;
    public Node(Object value) {
        this.value = value;
    }

}



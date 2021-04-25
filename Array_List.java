package com.company;

import java.util.ArrayList;

public class Array_List {

    class MyNode {
        int data;
        MyNode next;

        MyNode(int data) {
            this.data = data;
            next = null;
        }
    }

    public static class MyArrayList<T> {
        private MyNode<T> head;
        private MyNode<T> tail;
        private int size;

        public MyArrayList() {
        }

        public void add(int newItem){
            MyNode newNode = new MyNode(newItem);
            if (head == null) {
                head = tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public T get(int index) {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        private static class MyNode<E> {
            E data;
            MyNode<E> next;

            MyNode(E data) {
                this.data = data;
            }
        }

        public int find(T keyItem){
            MyNode<T> current = head;
            int index = 0;
            while(current != null){
                if(current.data == keyItem){
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        public void print(){
            MyNode<T> current = head;
            while(current != null){
                System.out.print(current.data);
                System.out.print(" ");
                current = current.next;
            }
            System.out.println("");
        }
        public void add_new(T newItem, int index){
            if(index>size-1){
                return;
            }
            MyNode newNode = new MyNode(newItem);
            if(index==size-1){
                tail.next = newNode;
            }
            MyNode<T> current = head;
            for(int i = 0; i<index-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
        public void remove(int index){
            if(index>size-1){
                return;
            }
            MyNode<T> current = head;
            if(index==0){
                head = current.next;
                return;
            }

            for(int i = 0; i<index-1; i++){
                current = current.next;
            }
            current.next = current.next.next;
            current.next.next = null;
            size--;
        }

        private MyNode reverseRecurse(MyNode prevNode){
            if(prevNode==null||prevNode.next==null){
                return prevNode;
            }
            MyNode nextNode = prevNode.next;
            MyNode newHead = reverseRecurse(nextNode);
            nextNode.next = prevNode;
            prevNode.next = null;
            return newHead;
        }

        public void reverse(){
            MyNode<T> current = head;
            //tail = head;
            //tail.next = null;
            head = reverseRecurse(head);
        }
    }
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(10);
        arr.add(12);
        arr.add(22);
        arr.add(35);
        arr.add(55);
        arr.add(82);
        arr.add_new(100,2);//add method
        arr.remove(4);//remove method
        System.out.print("ArrayList : ");
        arr.print();
        arr.reverse();
        System.out.print("ArrayList reversed: ");
        arr.print();
        int k = arr.find(100);
        System.out.println("k (find method) = " + k);
    }
}
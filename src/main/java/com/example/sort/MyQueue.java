package com.example.sort;

import java.util.Stack;

/**
 * @author sk
 * @time 2021/4/22
 * @desc say
 **/
public class MyQueue<T> {

    private final Stack<T> in = new Stack<>();
    private final Stack<T> out = new Stack<>();

    public void add(T t) {
        in.add(t);
    }

    public T pop() {
        if (out.size() == 0 && in.size() == 0) {
            return null;
        } else if (out.size() == 0) {
            int size = in.size();
            for (int i = 0; i < size; i++) {
                out.add(in.pop());
            }
        }
        return out.pop();
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("1");
        myQueue.add("3");
        myQueue.add("4");
        String ss = myQueue.pop();
        System.out.println(ss);
        myQueue.add("6");
        ss = myQueue.pop();
        System.out.println(ss);
        myQueue.add("8");
        for (int i = 0; i < 10; i++) {
            ss = myQueue.pop();
            System.out.println(ss);
        }
    }

}

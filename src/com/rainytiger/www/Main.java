package com.rainytiger.www;

import com.rainytiger.www.AddTwoNumbers.*;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        l4.next = l5;
        l5.next = l6;
        l6.next = null;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode ret = addTwoNumbers.addTwoNumbers(l1, l4);
        while (ret != null) {
            System.out.print(ret.val);
            ret = ret.next;
        }
    }

}

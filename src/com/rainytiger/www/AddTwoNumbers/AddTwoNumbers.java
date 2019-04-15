package com.rainytiger.www.AddTwoNumbers;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode L = new ListNode(l1.val + l2.val);
        l1 = l1.next;
        l2 = l2.next;
        boolean flag = L.val > 9;
        if (flag) L.val -= 10;
        ListNode l = L;
        while (l1 != null && l2 != null) {
            l.next = new ListNode(l1.val + l2.val);
            l = l.next;
            if (flag) {
                flag = false;
                l.val += 1;
            }
            if (l.val > 9) {
                flag = true;
                l.val -= 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) l1 = l2;
        while (l1 != null) {
            l.next = new ListNode(l1.val);
            l = l.next;
            if (flag) {
                l.val += 1;
                flag = false;
            }
            if (l.val == 10) {
                flag = true;
                l.val = 0;
            }
            l1 = l1.next;
        }
        if (flag) l.next = new ListNode(1);
        return L;
    }
}

package day3;

/**
 * day 3 home work leetcode 21
 *
 * @author changdp
 * @create 2020-03-07 22:00
 **/
class Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
     public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next =  new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next = new ListNode(4);
        ListNode ll = Solution.mergeTwoLists(l1,l2);
        while (ll.next != null){
            System.out.print(ll.val + "->");
            ll = ll.next;
        }
     }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

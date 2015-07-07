package me.yutao.ninechapter.nine1_bs;

/*
 Created by yutao on 7/6/15.

 Copy Books
 http://codevs.cn/problem/3168/

 现在要把M本有顺序的书分给K个人复制（抄写），每一个人的抄写速度都一样，一本书不允许给两个（或以上）的人抄写，
 分给每一个人的书，必须是连续的，比 如不能把第一、第三、第四本数给同一个人抄写。现在请你设计一种方案，
 使得复制时间最短。复制时间为抄写页数最多的人用去的时间。

 input：

 第一行两个整数M、K；（K<=10000 M<=1000000  满足 k<=m）

 第二行M个整数，第i个整数表示第i本书的页数。

 Output：

 第一行两个整数M、K；（K<=10000 M<=1000000  满足 k<=m）

 第二行M个整数，第i个整数表示第i本书的页数。

 共K行，每行两个正整数，第i行表示第i个人抄写的书的起始编号和终止编号。
 K行的起始编号应该从小到大排列，如果有多解，则尽可能让前面的人少抄写

 Sample input：

 9 3

 1 2 3 4 5 6 7 8 9

 Sample output：

 1 5

 6 7

 8 9
*/
public class CopyBooks {
    public static void main(String[] args) {
//        int[] books = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int people = 3;
        int[] books = new int[] {384, 887, 778, 916, 794, 336, 387, 493, 650, 422, 363, 28};
        int people = 10;
        CopyBooks copyBooks = new CopyBooks();
        int[] result = copyBooks.copyBooks(books, people);
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                System.out.println();
            } else {
                System.out.print("  ");
            }
            System.out.print(result[i] + 1);
        }

    }

    public int[] copyBooks(int[] books, int people) {
        int[] result = new int[people * 2];

        if (books == null || books.length == 0) {
            return result;
        }

        int total = 0;
        for (int i = 0; i < books.length; i++) {
            total += books[i];
        }

        int start = total / people;
        int end = total;
        int speed = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            speed = trySpeed(books, people, mid, result);
            if (speed == mid) {
                end = mid;
            } else if (speed < mid) {
                end = mid;
            } else {
                start = mid;
            }
        }

        speed = trySpeed(books, people, start, result);
        if (speed == start) {
            return result;
        }

        speed = trySpeed(books, people, end, result);
        if (speed == end) {
            return result;
        }

        return new int[0];
    }

    private int trySpeed(int[] books, int people, int speed, int[] result) {
        int max = Integer.MIN_VALUE;
        int right = books.length - 1;
        int left;

        for (int i = people - 1; i >= 0; i--) {
            int sum = 0;
            for (left = right; left >= 0; left--) {
                sum += books[left];
                if (i != 0 && left > 0 && sum + books[left - 1] > speed) {
                    break;
                }

                // everyone need at least one book
                if (left <= i) {
                    break;
                }
            }
            result[2 * i + 1] = right;
            if (left <= 0) {
                left = 0;
            }
            result[2 * i] = left;
            max = Math.max(max, sum);
            right = left - 1;
            if (left <= 0) {
                break;
            }
        }

        return max;
    }
}

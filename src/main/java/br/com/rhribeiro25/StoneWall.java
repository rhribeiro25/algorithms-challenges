package br.com.rhribeiro25;

import java.util.Stack;

public class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blockCount = 0;

        for (int height : H) {
            // Pop from stack as long as the current height is less than the top of the stack
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            // If the stack is empty or the current height is different from the top, push it to stack
            if (stack.isEmpty() || stack.peek() != height) {
                stack.push(height);
                blockCount++;
            }
        }

        return blockCount;
    }
    public static void main(String[] args) {
        StoneWall solution = new StoneWall();
        System.out.println(solution.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));  // Should return 7
        System.out.println(solution.solution(new int[]{5, 5, 5, 5}));               // Should return 1
        System.out.println(solution.solution(new int[]{1, 2, 3, 4, 5}));           // Should return 5
        System.out.println(solution.solution(new int[]{5, 4, 3, 2, 1}));           // Should return 5
    }
}

/*
You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

class Solution { public int solution(int[] H); }

that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.



Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
 */

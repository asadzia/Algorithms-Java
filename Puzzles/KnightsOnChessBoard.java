/*
Given any source point, (C, D) and destination point, (E, F) on a chess board, we need to find whether Knight can move to the destination or not.

Knight's movements on a chess board

The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point.

If knight can not move from the source point to the destination point, then return -1.

Note: A knight cannot go out of the board.



Input Format:

The first argument of input contains an integer A.
The second argument of input contains an integer B.
    => The chessboard is of size A x B.
The third argument of input contains an integer C.
The fourth argument of input contains an integer D.
    => The Knight is initially at position (C, D).
The fifth argument of input contains an integer E.
The sixth argument of input contains an integer F.
    => The Knight wants to reach position (E, F).
Output Format:

If it is possible to reach the destination point, return the minimum number of moves.
Else return -1.
Constraints:

1 <= A, B <= 500
Example

Input 1:
    A = 8
    B = 8
    C = 1
    D = 1
    E = 8
    F = 8
    
Output 1:
    6

Explanation 1:
    The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
    The minimum number of moves required for this is 6.
*/


public class Solution {
    
    static class node {
        int x;
        int y;
        int moves;
        
        node(int a, int b, int c) {
            x = a;
            y = b;
            moves = c;
        }
    }
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        
        boolean[][] visited = new boolean[A][B];
        
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                visited[i][j] = false;
            }
        }
        
        Queue<node> queue = new LinkedList<>();
        
        node n = new node(C - 1, D - 1, 0);
        queue.add(n);
        
        while (!queue.isEmpty()) {
            
            node val = queue.poll();
            
            if (val.x == E - 1 && val.y == F - 1) {
                
                return val.moves;
            }
            
            visited[val.x][val.y] = true;
            
            // make all the possible knight moves
            // also note, given data is 1-based - not 0-based. convert this
            
            if (val.x - 2 >= 0 && val.y - 1 >= 0 &&
            visited[val.x - 2][val.y - 1] == false) {
                
                visited[val.x - 2][val.y - 1] = true;
                queue.add(new node(val.x - 2, val.y - 1, val.moves + 1));
            }
            
            if (val.x - 1 >= 0 && val.y - 2 >= 0 &&
            visited[val.x - 1][val.y - 2] == false) {
                
                visited[val.x - 1][val.y - 2] = true;
                queue.add(new node(val.x - 1, val.y - 2, val.moves + 1));
            }
            
            
            if (val.x - 2 >= 0 && val.y + 1 <= B - 1 &&
            visited[val.x - 2][val.y + 1] == false) {
                
                visited[val.x - 2][val.y + 1] = true;
                queue.add(new node(val.x - 2, val.y + 1, val.moves + 1));
            }
            
            if (val.x - 1 >= 0 && val.y + 2 <= B - 1 &&
            visited[val.x - 1][val.y + 2] == false) {
                
                visited[val.x - 1][val.y + 2] = true;
                queue.add(new node(val.x - 1, val.y + 2, val.moves + 1));
            }
            
            if (val.x + 2 <= A - 1 && val.y - 1 >= 0 &&
            visited[val.x + 2][val.y - 1] == false) {
                
                visited[val.x + 2][val.y - 1] = true;
                queue.add(new node(val.x + 2, val.y - 1, val.moves + 1));
            }
            
            if (val.x + 1 <= A - 1 && val.y - 2 >= 0 &&
            visited[val.x + 1][val.y - 2] == false) {
                
                visited[val.x + 1][val.y - 2] = true;
                queue.add(new node(val.x + 1, val.y - 2, val.moves + 1));
            }
            
            if (val.x + 2 <= A - 1 && val.y + 1 <= B - 1 &&
            visited[val.x + 2][val.y + 1] == false) {
                
                visited[val.x + 2][val.y + 1] = true;
                queue.add(new node(val.x + 2, val.y + 1, val.moves + 1));
            }
            
            if (val.x + 1 <= A - 1 && val.y + 2 <= B - 1 &&
            visited[val.x + 1][val.y + 2] == false) {
                
                visited[val.x + 1][val.y + 2] = true;
                queue.add(new node(val.x + 1, val.y + 2, val.moves + 1));
            }
        }
        
        return -1;
    }
}

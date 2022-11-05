package projava;

import java.util.ArrayDeque;

public class TraverseDeep {
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 2, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        traverse(map, 1, 1);
        char[] ch = {'.', '*', 'G', '●'};
        for (int[] row : map) {
            for (int cell : row) {
                System.out.print(ch[cell]);
            }
            System.out.println();
        }
    }

    // 明示的にスタックを利用した深さ優先探索
    static boolean traverse(int[][] map, int curX, int curY) {
        record Position(int x, int y) {}

        // 先頭や末尾への追加削除の性能が良いデータ構造
        var stack = new ArrayDeque<Position>();
        stack.push(new Position(curX, curY));
        for (Position p; (p = stack.pollFirst()) != null ;) {
            switch (map[p.y()][p.x()]) {
                case 0: break; // 通路なので続きの処理
                case 2: return true; // ゴールなので終了
                default: continue; // 通れないので他のマスの処理
            }
            map[p.y()][p.x()] = 3;
            stack.push(new Position(p.x() + 1, p.y()));
            stack.push(new Position(p.x() - 1 , p.y()));
            stack.push(new Position(p.x(), p.y() + 1));
            stack.push(new Position(p.x(), p.y() - 1));
        }
        return false;
    }

    // 再帰を利用した深さ優先探索
    // static boolean traverse(int[][] map, int curX, int curY) {
    //     switch (map[curY][curX]) {
    //         case 0: break; // 迷路なので続き
    //         case 2: return true; // ゴール
    //         default: return false; // 通れない
    //     }
    //     map[curY][curX] = 3; // 通った印
    //     if (traverse(map, curX + 1, curY) ||
    //         traverse(map, curX - 1, curY) ||
    //         traverse(map, curX, curY + 1) ||
    //         traverse(map, curX, curY - 1)) {
    //         return true;
    //     }
    //     map[curY][curX] = 0; // ゴールに到達できなかったので印を戻す
    //     return false;
    // }
}

public class TestQueen {

    private static final int QUEEN_NUM = 8;

    private static final int[][] Checkerboard = new int[QUEEN_NUM][QUEEN_NUM];

    private static int COUNT = 0;

    public static final void show() {
        System.out.println("第" + (++COUNT) + "种摆法");
        for (int i = 0; i < QUEEN_NUM; i++) {
            for (int j = 0; j < QUEEN_NUM; j++) {
                System.out.print(Checkerboard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static final boolean check(int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (Checkerboard[i][col] == 1)
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < QUEEN_NUM; i--, j++) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        return true;
    }

    public static final void play(int row) {
        for (int i = 0; i < QUEEN_NUM; i++) {
            if (check(row, i)) {
                Checkerboard[row][i] = 1;

                if (row == QUEEN_NUM - 1) {
                    show();
                } else {
                    play(row + 1);
                }

                Checkerboard[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        play(0);
    }
}

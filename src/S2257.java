
public class S2257 {

    enum Type {
        UNOCCUPIED,
        GUARD,
        WALL,
        OCCUPIED
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int res = m * n - walls.length - guards.length;

        int[][] fields = new int[m][n];

        initFields(fields, walls, Type.WALL);
        initFields(fields, guards, Type.GUARD);

        for (int[] guard : guards) {
            int y = guard[0];
            int x = guard[1];
            int xMax = n - 1, xMin = 0, yMax = m - 1, yMin = 0;

            // to right
            for (int r = x + 1; r <= xMax; r++) {
                int field = fields[y][r];
                if (field == Type.UNOCCUPIED.ordinal()) {
                    res--;
                    System.out.println(r + 1 + " " + (y + 1));
                    fields[y][r] = Type.OCCUPIED.ordinal();
                }
                else if (field == Type.WALL.ordinal() || field == Type.GUARD.ordinal()) {
                    break;
                }
            }

            //to left
            for (int l = x - 1; l >= xMin; l--) {
                int field = fields[y][l];
                if (field == Type.UNOCCUPIED.ordinal()) {
                    res--;
                    System.out.println(l + 1 + " " + (y + 1));
                    fields[y][l] = Type.OCCUPIED.ordinal();
                }
                else if (field == Type.WALL.ordinal() || field == Type.GUARD.ordinal()) {
                    break;
                }
            }

            // to up
            for (int u = y - 1; u >= yMin; u--) {
                int field = fields[u][x];
                if (field == Type.UNOCCUPIED.ordinal()) {
                    res--;
                    System.out.println(x + 1 + " " + (u + 1));
                    fields[u][x] = Type.OCCUPIED.ordinal();
                }
                else if (field == Type.WALL.ordinal() || field == Type.GUARD.ordinal()) {
                    break;
                }
            }

            // to down
            for (int d = y + 1; d <= yMax; d++) {
                int field = fields[d][x];
                if (field == Type.UNOCCUPIED.ordinal()) {
                    res--;
                    System.out.println(x + 1 + " " + (d + 1));
                    fields[d][x] = Type.OCCUPIED.ordinal();
                }
                else if (field == Type.WALL.ordinal() || field == Type.GUARD.ordinal()) {
                    break;
                }
            }
        }

        return res;
    }


    private void initFields(int[][] fields, int[][] entity, Type type) {
        for (int[] cords : entity) {
            fields[cords[0]][cords[1]] = type.ordinal();
        }
    }
}

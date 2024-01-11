public class Position {
    int _x;
    int _y;

    public Position(int row, int col) {
        this._y = col;
        this._x = row;
    }

    @Override
    public String toString() {
        return "(" + this._x + this._y + ")";
    }
}

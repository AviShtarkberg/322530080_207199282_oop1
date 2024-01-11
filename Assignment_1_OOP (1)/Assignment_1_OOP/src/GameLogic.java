import java.util.*;

public class GameLogic implements PlayableLogic {
    private ArrayList<ConcretePiece> _piecesPlayer1 = new ArrayList<>();
    private ArrayList<ConcretePiece> _piecesPlayer2 = new ArrayList<>();
    public final ConcretePiece[][] _map;
    private boolean _isPlayer2Turn;
    private final ConcretePlayer _player1;
    private final ConcretePlayer _player2;
    private boolean _isGameFinished;
    private boolean _wasEaten = false;
    private Stack<Map.Entry<Position, ConcretePiece>> _stackForUndo = new Stack<>();
    private Stack<ConcretePiece> _stackForEatenUndo = new Stack<>();


    public GameLogic() {
        this._isPlayer2Turn = true;
        this._player1 = new ConcretePlayer(1);
        this._player2 = new ConcretePlayer(2);
        this._map = new ConcretePiece[11][11];
        Pawn pawn1_player2 = new Pawn(new Position(3, 0), 1, _player2, "♟");
        _map[3][0] = pawn1_player2;
        _piecesPlayer2.add(pawn1_player2);
        Pawn pawn2_player2 = new Pawn(new Position(4, 0), 2, _player2, "♟");
        _piecesPlayer2.add(pawn2_player2);
        _map[4][0] = pawn2_player2;
        Pawn pawn3_player2 = new Pawn(new Position(5, 0), 3, _player2, "♟");
        _piecesPlayer2.add(pawn3_player2);
        _map[5][0] = pawn3_player2;
        Pawn pawn4_player2 = new Pawn(new Position(6, 0), 4, _player2, "♟");
        _piecesPlayer2.add(pawn4_player2);
        _map[6][0] = pawn4_player2;
        Pawn pawn5_player2 = new Pawn(new Position(7, 0), 5, _player2, "♟");
        _map[7][0] = pawn5_player2;
        _piecesPlayer2.add(pawn5_player2);
        Pawn pawn6_player2 = new Pawn(new Position(1, 5), 6, _player2, "♟");
        _map[5][1] = pawn6_player2;
        _piecesPlayer2.add(pawn5_player2);
        Pawn pawn7_player2 = new Pawn(new Position(0, 3), 7, _player2, "♟");
        _map[0][3] = pawn7_player2;
        _piecesPlayer2.add(pawn7_player2);
        Pawn pawn8_player2 = new Pawn(new Position(10, 3), 8, _player2, "♟");
        _map[10][3] = pawn8_player2;
        _piecesPlayer2.add(pawn8_player2);
        Pawn pawn9_player2 = new Pawn(new Position(0, 4), 9, _player2, "♟");
        _map[0][4] = pawn9_player2;
        _piecesPlayer2.add(pawn9_player2);
        Pawn pawn10_player2 = new Pawn(new Position(10, 4), 10, _player2, "♟");
        _map[10][4] = pawn10_player2;
        _piecesPlayer2.add(pawn10_player2);
        Pawn pawn11_player2 = new Pawn(new Position(0, 5), 11, _player2, "♟");
        _map[0][5] = pawn11_player2;
        _piecesPlayer2.add(pawn11_player2);
        Pawn pawn12_player2 = new Pawn(new Position(1, 5), 12, _player2, "♟");
        _map[1][5] = pawn12_player2;
        _piecesPlayer2.add(pawn12_player2);
        Pawn pawn13_player2 = new Pawn(new Position(9, 5), 13, _player2, "♟");
        _map[9][5] = pawn13_player2;
        _piecesPlayer2.add(pawn13_player2);
        Pawn pawn14_player2 = new Pawn(new Position(10, 5), 14, _player2, "♟");
        _map[10][5] = pawn14_player2;
        _piecesPlayer2.add(pawn14_player2);
        Pawn pawn15_player2 = new Pawn(new Position(0, 6), 15, _player2, "♟");
        _map[0][6] = pawn15_player2;
        _piecesPlayer2.add(pawn15_player2);
        Pawn pawn16_player2 = new Pawn(new Position(10, 6), 16, _player2, "♟");
        _map[10][6] = pawn16_player2;
        _piecesPlayer2.add(pawn16_player2);
        Pawn pawn17_player2 = new Pawn(new Position(0, 7), 17, _player2, "♟");
        _map[0][7] = pawn17_player2;
        _piecesPlayer2.add(pawn17_player2);
        Pawn pawn18_player2 = new Pawn(new Position(10, 7), 18, _player2, "♟");
        _map[10][7] = pawn18_player2;
        _piecesPlayer2.add(pawn18_player2);
        Pawn pawn19_player2 = new Pawn(new Position(5, 9), 19, _player2, "♟");
        _map[5][9] = pawn19_player2;
        _piecesPlayer2.add(pawn19_player2);
        Pawn pawn20_player2 = new Pawn(new Position(3, 10), 20, _player2, "♟");
        _map[3][10] = pawn20_player2;
        _piecesPlayer2.add(pawn20_player2);
        Pawn pawn21_player2 = new Pawn(new Position(4, 10), 21, _player2, "♟");
        _map[4][10] = pawn21_player2;
        _piecesPlayer2.add(pawn21_player2);
        Pawn pawn22_player2 = new Pawn(new Position(5, 10), 22, _player2, "♟");
        _map[5][10] = pawn22_player2;
        _piecesPlayer2.add(pawn22_player2);
        Pawn pawn23_player2 = new Pawn(new Position(6, 10), 23, _player2, "♟");
        _map[6][10] = pawn22_player2;
        _piecesPlayer2.add(pawn23_player2);
        Pawn pawn24_player2 = new Pawn(new Position(7, 10), 24, _player2, "♟");
        _map[7][10] = pawn24_player2;
        _piecesPlayer2.add(pawn24_player2);
        King king_player1 = new King(new Position(5, 5), 7, _player1, "♔");
        _map[5][5] = king_player1;
        _piecesPlayer1.add(king_player1);
        Pawn pawn1_player1 = new Pawn(new Position(5, 3), 1, _player1, "♙");
        _map[5][3] = pawn1_player1;
        _piecesPlayer1.add(pawn1_player1);
        Pawn pawn2_player1 = new Pawn(new Position(4, 4), 2, _player1, "♙");
        _map[4][4] = pawn2_player1;
        _piecesPlayer1.add(pawn2_player1);
        Pawn pawn3_player1 = new Pawn(new Position(5, 4), 3, _player1, "♙");
        _map[5][4] = pawn3_player1;
        _piecesPlayer1.add(pawn3_player1);
        Pawn pawn4_player1 = new Pawn(new Position(6, 2), 4, _player1, "♙");
        _map[6][4] = pawn4_player1;
        _piecesPlayer1.add(pawn4_player1);
        Pawn pawn5_player1 = new Pawn(new Position(3, 5), 5, _player1, "♙");
        _map[3][5] = pawn5_player1;
        _piecesPlayer1.add(pawn5_player1);
        Pawn pawn6_player1 = new Pawn(new Position(4, 5), 6, _player1, "♙");
        _map[4][5] = pawn6_player1;
        _piecesPlayer1.add(pawn6_player1);
        Pawn pawn8_player1 = new Pawn(new Position(6, 5), 8, _player1, "♙");
        _map[6][5] = pawn8_player1;
        _piecesPlayer1.add(pawn8_player1);
        Pawn pawn9_player1 = new Pawn(new Position(7, 5), 9, _player1, "♙");
        _map[7][5] = pawn9_player1;
        _piecesPlayer1.add(pawn9_player1);
        Pawn pawn10_player1 = new Pawn(new Position(4, 6), 10, _player1, "♙");
        _map[4][6] = pawn10_player1;
        _piecesPlayer1.add(pawn10_player1);
        Pawn pawn11_player1 = new Pawn(new Position(5, 6), 11, _player1, "♙");
        _map[5][6] = pawn11_player1;
        _piecesPlayer1.add(pawn11_player1);
        Pawn pawn12_player1 = new Pawn(new Position(6, 6), 12, _player1, "♙");
        _map[6][6] = pawn12_player1;
        _piecesPlayer1.add(pawn12_player1);
        Pawn pawn13_player1 = new Pawn(new Position(5, 7), 13, _player1, "♙");
        _map[5][7] = pawn13_player1;
        _piecesPlayer1.add(pawn13_player1);
    }

    private boolean isEmpty(Position p) {
        return _map[p._x][p._y] == null;
    }

    private boolean isDiagonal(Position a, Position b) {
        return a._x != b._x && a._y != b._y;
    }

    private boolean isLeftValid(Position a, Position b) {
        for (int i = a._x - 1; i >= b._x; i--) {
            if (_map[i][a._y] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightValid(Position a, Position b) {
        for (int i = a._x + 1; i <= b._x; i++) {
            if (_map[i][a._y] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isUpValid(Position a, Position b) {
        for (int i = a._y - 1; i >= b._y; i--) {
            if (_map[a._x][i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownValid(Position a, Position b) {
        for (int i = a._y + 1; i <= b._y; i++) {
            if (_map[a._x][i] != null) {
                return false;
            }
        }
        return true;
    }

    private int direction(Position a, Position b) {
        int ans = 0;
        //  b is on the right of a:
        if (b._x > a._x) {
            ans = 1;
        }//  b is on the left of a:
        if (b._x < a._x) {
            ans = 2;
        }//  b is upper than a:
        if (b._y < a._y) {
            ans = 3;
        }//  b is downer than a:
        if (b._y > a._y) {
            ans = 4;
        }
        return ans;
    }

    private boolean isValidTurn(Position p) {
        if (getPieceAtPosition(p).getType().equals("♙") || getPieceAtPosition(p).getType().equals("♔")) {
            if (_isPlayer2Turn) {
                return false;
            }
        }
        if (getPieceAtPosition(p).getType().equals("♟") && !_isPlayer2Turn) {
            return false;
        }
        return true;
    }

    private boolean corners(Position a, Position b) {
        if (b._x == 0 && b._y == 0 || b._x == 10 && b._y == 0 || b._x == 0 && b._y == 10 || b._x == 10 && b._y == 10) {
            if (_map[a._x][a._y].getType().equals("♟") || _map[a._x][a._y].getType().equals("♙")) {
                return false;
            }
        }
        return true;
    }

    private void eatPawn(Position a, Position b) {
        if ((_map[a._x][a._y].getType().equals("♟") || _map[a._x][a._y].getType().equals("♙"))) {
            //check that we are inside the "inner" matrix that is _map from 2 to 8 in x and y.
            if (b._x < 9 && b._x > 1 && b._y < 9 && b._y > 1) {
                // ♟♙♟ - from the right side "inner" matrix.
                if (_map[b._x + 1][b._y] != null && !_map[b._x + 1][b._y].getType().equals(_map[a._x][a._y].getType())) {
                    if (_map[b._x + 2][b._y] != null && _map[b._x + 2][b._y].getType().equals(_map[a._x][a._y].getType())) {
                        if (!_map[b._x + 1][b._y].getType().equals("♔")) {
                            _stackForEatenUndo.push(_map[b._x + 1][b._y]);
                            _wasEaten = true;
                            _map[b._x + 1][b._y] = null;
                        }
                    }
                }
                // ♟♙♟ - from the left side "inner" matrix.
                if (_map[b._x - 1][b._y] != null && !_map[b._x - 1][b._y].getType().equals(_map[a._x][a._y].getType())) {
                    if (_map[b._x - 2][b._y] != null && _map[b._x - 2][b._y].getType().equals(_map[a._x][a._y].getType())) {
                        if (!_map[b._x - 1][b._y].getType().equals("♔")) {
                            _stackForEatenUndo.push(_map[b._x - 1][b._y]);
                            _wasEaten = true;
                            _map[b._x - 1][b._y] = null;
                        }
                    }
                }
                //♟ - from the down side "inner" matrix.
                //♙
                //♟
                if (_map[b._x][b._y + 1] != null && !_map[b._x][b._y + 1].getType().equals(_map[a._x][a._y].getType())) {
                    if (_map[b._x][b._y + 2] != null && _map[b._x][b._y + 2].getType().equals(_map[a._x][a._y].getType())) {
                        if (!_map[b._x][b._y + 1].getType().equals("♔")) {
                            _stackForEatenUndo.push(_map[b._x][b._y + 1]);
                            _wasEaten = true;
                            _map[b._x][b._y + 1] = null;
                        }
                    }
                }
                //♟ - from the up side "inner" matrix.
                //♙
                //♟
                if (_map[b._x][b._y - 1] != null && (!_map[b._x][b._y - 1].getType().equals(_map[a._x][a._y].getType()))) {
                    if (_map[b._x][b._y - 2] != null && _map[b._x][b._y - 2].getType().equals(_map[a._x][a._y].getType())) {
                        if (!_map[b._x][b._y - 1].getType().equals("♔")) {
                            _stackForEatenUndo.push(_map[b._x][b._y - 1]);
                            _wasEaten = true;
                            _map[b._x][b._y - 1] = null;
                        }
                    }
                }
            }
            //this if statements will make the pawn be eaten inside the outer matrix. ("♟♙♟" situation in the outer )
            //up:
            if (b._x != 9 && b._x != 10 && b._x != 0 && b._x != 1 && b._y < 2 && _map[b._x + 2][b._y] != null && _map[b._x + 1][b._y] != null && !_map[b._x + 2][b._y].getType().equals(_map[b._x + 1][b._y].getType())) {
                if (!_map[b._x + 1][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x + 1][b._y]);
                    _wasEaten = true;
                    _map[b._x + 1][b._y] = null;
                }
            }
            if (b._x != 9 && b._x != 10 && b._x != 0 && b._x != 1 && b._y < 2 && _map[b._x - 2][b._y] != null && _map[b._x - 1][b._y] != null && !_map[b._x - 2][b._y].getType().equals(_map[b._x - 1][b._y].getType())) {
                if (!_map[b._x - 1][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x - 1][b._y]);
                    _wasEaten = true;
                    _map[b._x - 1][b._y] = null;
                }
            }
            //down:
            if (b._x != 9 && b._x != 10 && b._x != 0 && b._x != 1 && b._y > 8 && _map[b._x + 2][b._y] != null && _map[b._x + 1][b._y] != null && !_map[b._x + 2][b._y].getType().equals(_map[b._x + 1][b._y].getType())) {
                if (!_map[b._x + 1][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x + 1][b._y]);
                    _wasEaten = true;
                    _map[b._x + 1][b._y] = null;
                }
            }
            if (b._x != 9 && b._x != 10 && b._x != 0 && b._x != 1 && b._y > 8 && _map[b._x - 2][b._y] != null && _map[b._x - 1][b._y] != null && !_map[b._x - 2][b._y].getType().equals(_map[b._x - 1][b._y].getType())) {
                if (!_map[b._x - 1][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x - 1][b._y]);
                    _wasEaten = true;
                    _map[b._x - 1][b._y] = null;
                }
            }
            //right:
            if (b._y != 9 && b._y != 10 && b._y != 0 && b._x > 8 && _map[b._x][b._y + 2] != null && _map[b._x][b._y + 1] != null && !_map[b._x][b._y + 2].getType().equals(_map[b._x][b._y + 1].getType())) {
                if (!_map[b._x][b._y + 1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][b._y + 1]);
                    _wasEaten = true;
                    _map[b._x][b._y + 1] = null;
                }
            }
            if (b._y != 9 && b._y != 10 && b._y != 0 && b._y != 1 && b._x > 8 && _map[b._x][b._y - 2] != null && _map[b._x][b._y - 1] != null && !_map[b._x][b._y - 2].getType().equals(_map[b._x][b._y - 1].getType())) {
                if (!_map[b._x][b._y - 1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][b._y - 1]);
                    _wasEaten = true;
                    _map[b._x][b._y - 1] = null;
                }
            }
            //left:
            if (b._y != 9 && b._y != 10 && b._y != 0 && b._x < 2 && _map[b._x][b._y + 2] != null && _map[b._x][b._y + 1] != null && !_map[b._x][b._y + 2].getType().equals(_map[b._x][b._y + 1].getType())) {
                if (!_map[b._x][b._y + 1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][b._y + 1]);
                    _wasEaten = true;
                    _map[b._x][b._y + 1] = null;
                }
            }
            if (b._y != 10 && b._y != 0 && b._y != 1 && b._x < 2 && _map[b._x][b._y - 2] != null && _map[b._x][b._y - 1] != null && !_map[b._x][b._y - 2].getType().equals(_map[b._x][b._y - 1].getType())) {
                if (!_map[b._x][b._y - 1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][b._y - 1]);
                    _wasEaten = true;
                    _map[b._x][b._y - 1] = null;
                }
            }
            //the new "if" checks the "♟♙♟" situation in the corners:
            //left up corner:
            if (b._x == 0 && b._y == 1 && _map[1][1] != null && _map[2][1] != null && !_map[1][1].getType().equals(_map[2][1].getType())) {
                if (!_map[1][1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[1][1]);
                    _wasEaten = true;
                    _map[1][1] = null;
                }
            }
            if (b._x == 1 && b._y == 0 && _map[1][1] != null && _map[1][2] != null && !_map[1][1].getType().equals(_map[1][2].getType())) {
                if (!_map[1][1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[1][1]);
                    _wasEaten = true;
                    _map[1][1] = null;
                }
            }
            //right up corner:
            if (b._x == 9 && b._y == 0 && _map[9][1] != null && _map[9][2] != null && !_map[9][1].getType().equals(_map[9][2].getType())) {
                if (!_map[9][1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[9][1]);
                    _wasEaten = true;
                    _map[9][1] = null;
                }
            }
            if (b._x == 10 && b._y == 1 && _map[9][1] != null && _map[8][1] != null && !_map[9][1].getType().equals(_map[8][1].getType())) {
                if (!_map[9][1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[9][1]);
                    _wasEaten = true;
                    _map[9][1] = null;
                }
            }
            //right down corner:
            if (b._x == 10 && b._y == 9 && _map[9][9] != null && _map[8][9] != null && !_map[9][9].getType().equals(_map[8][9].getType())) {
                if (!_map[9][9].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[9][9]);
                    _wasEaten = true;
                    _map[9][9] = null;
                }
            }
            if (b._x == 9 && b._y == 10 && _map[9][9] != null && _map[9][8] != null && !_map[9][9].getType().equals(_map[9][8].getType())) {
                if (!_map[9][9].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[9][9]);
                    _wasEaten = true;
                    _map[9][9] = null;
                }
            }
            //left down corner:
            if (b._x == 1 && b._y == 10 && _map[1][9] != null && _map[1][8] != null && !_map[1][9].getType().equals(_map[1][8].getType())) {
                if (!_map[1][9].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[1][9]);
                    _wasEaten = true;
                    _map[1][9] = null;
                }
            }
            if (b._x == 0 && b._y == 9 && _map[1][9] != null && _map[2][9] != null && !_map[1][9].getType().equals(_map[2][9].getType())) {
                if (!_map[1][9].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[1][9]);
                    _wasEaten = true;
                    _map[1][9] = null;
                }
            }
            //this 4 if statements will make the pawn be eaten with the "wall" of the game.
            if (b._y == 1 && _map[b._x][0] != null && _map[a._x][a._y] != null && !_map[b._x][0].getType().equals(_map[a._x][a._y].getType())) {
                if (!_map[b._x][b._y - 1].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][b._y - 1]);
                    _wasEaten = true;
                    _map[b._x][b._y - 1] = null;
                }
            }
            if (b._x == 9 && _map[10][b._y] != null && !_map[10][b._y].getType().equals(_map[a._x][a._y].getType())) {
                if (!_map[10][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[10][b._y]);
                    _wasEaten = true;
                    _map[10][b._y] = null;
                }
            }
            if (b._y == 9 && _map[b._x][10] != null && !_map[b._x][10].getType().equals(_map[a._x][a._y].getType())) {
                if (!_map[b._x][10].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[b._x][10]);
                    _wasEaten = true;
                    _map[b._x][10] = null;

                }
            }
            if (b._x == 1 && _map[0][b._y] != null && !_map[0][b._y].getType().equals(_map[a._x][a._y].getType())) {
                if (!_map[0][b._y].getType().equals("♔")) {
                    _stackForEatenUndo.push(_map[0][b._y]);
                    _wasEaten = true;
                    _map[0][b._y] = null;
                }
            }
        }
    }

    private boolean eatKing(Position a, Position b) {
        if (_map[a._x][a._y].getType().equals("♟")) {
            if (b._x > 1 && b._x < 9 && b._y > 1 && b._y < 9) {
                //DOWN
                if (_map[b._x][b._y - 1] != null && _map[b._x][b._y - 1].getType().equals("♔")) {
                    if (_map[b._x][b._y - 2] != null && _map[b._x - 1][b._y - 1] != null && _map[b._x + 1][b._y - 1] != null) {
                        if (_map[b._x][b._y - 2].getType().equals("♟") && _map[b._x - 1][b._y - 1].getType().equals("♟") && _map[b._x + 1][b._y - 1].getType().equals("♟")) {
                            _map[b._x][b._y - 1] = null;
                            return true;
                        }
                    }
                }
                //UP
                if (_map[b._x][b._y + 1] != null && _map[b._x][b._y + 1].getType().equals("♔")) {
                    if (_map[b._x][b._y + 2] != null && _map[b._x - 1][b._y + 1] != null && _map[b._x + 1][b._y + 1] != null) {
                        if (_map[b._x][b._y + 2].getType().equals("♟") && _map[b._x - 1][b._y + 1].getType().equals("♟") && _map[b._x + 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x][b._y + 1] = null;
                            return true;
                        }
                    }
                }
                //RIGHT
                if (_map[b._x - 1][b._y] != null && _map[b._x - 1][b._y].getType().equals("♔")) {
                    if (_map[b._x - 1][b._y - 1] != null && _map[b._x - 2][b._y] != null && _map[b._x - 1][b._y + 1] != null) {
                        if (_map[b._x - 1][b._y - 1].getType().equals("♟") && _map[b._x - 2][b._y].getType().equals("♟") && _map[b._x - 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x - 1][b._y] = null;
                            return true;
                        }
                    }
                }
                //LEFT
                if (_map[b._x + 1][b._y] != null && _map[b._x + 1][b._y].getType().equals("♔")) {
                    if (_map[b._x + 1][b._y - 1] != null && _map[b._x + 2][b._y] != null && _map[b._x + 1][b._y + 1] != null) {
                        if (_map[b._x + 1][b._y - 1].getType().equals("♟") && _map[b._x + 2][b._y].getType().equals("♟") && _map[b._x + 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x + 1][b._y] = null;
                            return true;
                        }
                    }
                }
            }
            //down on the 10th row
            if (b._y == 10) {
                if (_map[b._x][b._y - 1] != null && _map[b._x][b._y - 1].getType().equals("♔")) {
                    if (_map[b._x][b._y - 2] != null && _map[b._x - 1][b._y - 1] != null && _map[b._x + 1][b._y - 1] != null) {
                        if (_map[b._x][b._y - 2].getType().equals("♟") && _map[b._x - 1][b._y - 1].getType().equals("♟") && _map[b._x + 1][b._y - 1].getType().equals("♟")) {
                            _map[b._x][b._y - 1] = null;
                            return true;
                        }
                    }
                }
            }
            //up on the 0 row.
            if (b._y == 0) {
                if (_map[b._x][b._y + 1] != null && _map[b._x][b._y + 1].getType().equals("♔")) {
                    if (_map[b._x][b._y + 2] != null && _map[b._x - 1][b._y + 1] != null && _map[b._x + 1][b._y + 1] != null) {
                        if (_map[b._x][b._y + 2].getType().equals("♟") && _map[b._x - 1][b._y + 1].getType().equals("♟") && _map[b._x + 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x][b._y + 1] = null;
                            return true;
                        }
                    }
                }
            }
            //right on the 10 column
            if (b._x == 10) {
                if (_map[b._x - 1][b._y] != null && _map[b._x - 1][b._y].getType().equals("♔")) {
                    if (_map[b._x - 1][b._y - 1] != null && _map[b._x - 2][b._y] != null && _map[b._x - 1][b._y + 1] != null) {
                        if (_map[b._x - 1][b._y - 1].getType().equals("♟") && _map[b._x - 2][b._y].getType().equals("♟") && _map[b._x - 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x - 1][b._y] = null;
                            return true;
                        }
                    }
                }
            }
            //left on the 0 column
            if (b._x == 0) {
                if (_map[b._x + 1][b._y] != null && _map[b._x + 1][b._y].getType().equals("♔")) {
                    if (_map[b._x + 1][b._y - 1] != null && _map[b._x + 2][b._y] != null && _map[b._x + 1][b._y + 1] != null) {
                        if (_map[b._x + 1][b._y - 1].getType().equals("♟") && _map[b._x + 2][b._y].getType().equals("♟") && _map[b._x + 1][b._y + 1].getType().equals("♟")) {
                            _map[b._x + 1][b._y] = null;
                            return true;
                        }
                    }
                }
            }
            //IN THE OUTER MATRIX eat by 3 pawns
            //down
            if (b._y == 10 || b._y == 9) {
                if (_map[b._x + 1][10] != null && _map[b._x + 1][10].getType().equals("♔")) {
                    if (_map[b._x + 2][10] != null && _map[b._x + 2][10].getType().equals("♟") && _map[b._x + 1][9] != null && _map[b._x + 1][9].getType().equals("♟")) {
                        _map[b._x + 1][10] = null;
                        return true;
                    }
                }
                if (_map[b._x - 1][10] != null && _map[b._x - 1][10].getType().equals("♔")) {
                    if (_map[b._x - 2][10] != null && _map[b._x - 2][10].getType().equals("♟") && _map[b._x - 1][9] != null && _map[b._x - 1][9].getType().equals("♟")) {
                        _map[b._x - 1][10] = null;
                        return true;
                    }
                }
                if (_map[b._x][10] != null && _map[b._x][10].getType().equals("♔")) {
                    if (_map[b._x - 1][10] != null && _map[b._x - 1][10].getType().equals("♟") && _map[b._x + 1][10] != null && _map[b._x + 1][10].getType().equals("♟")) {
                        _map[b._x][10] = null;
                        return true;
                    }
                }
            }
            //up
            if (b._y == 0 || b._y == 1) {
                if (_map[b._x + 1][0] != null && _map[b._x + 1][0].getType().equals("♔")) {
                    if (_map[b._x + 2][0] != null && _map[b._x + 2][0].getType().equals("♟") && _map[b._x + 1][1] != null && _map[b._x + 1][1].getType().equals("♟")) {
                        _map[b._x + 1][0] = null;
                        return true;
                    }
                }
                if (_map[b._x - 1][0] != null && _map[b._x - 1][0].getType().equals("♔")) {
                    if (_map[b._x - 2][0] != null && _map[b._x - 2][0].getType().equals("♟") && _map[b._x - 1][1] != null && _map[b._x - 1][1].getType().equals("♟")) {
                        _map[b._x - 1][0] = null;
                        return true;
                    }
                }
                if (_map[b._x][0] != null && _map[b._x][0].getType().equals("♔")) {
                    if (_map[b._x - 1][0] != null && _map[b._x - 1][0].getType().equals("♟") && _map[b._x + 1][0] != null && _map[b._x + 1][0].getType().equals("♟")) {
                        _map[b._x][0] = null;
                        return true;
                    }
                }
            }
            //right
            if (b._x == 10 || b._x == 9) {
                if (_map[10][b._y + 1] != null && _map[10][b._y + 1].getType().equals("♔")) {
                    if (_map[10][b._y + 2] != null && _map[10][b._y + 2].getType().equals("♟") && _map[9][b._y + 1] != null && _map[9][b._y + 1].getType().equals("♟")) {
                        _map[10][b._y + 1] = null;
                        return true;
                    }
                }
                if (_map[10][b._y - 1] != null && _map[10][b._y - 1].getType().equals("♔")) {
                    if (_map[10][b._y - 2] != null && _map[10][b._y - 2].getType().equals("♟") && _map[9][b._y - 1] != null && _map[9][b._y - 1].getType().equals("♟")) {
                        _map[10][b._y - 1] = null;
                        return true;
                    }
                }
                if (_map[10][b._y] != null && _map[10][b._y].getType().equals("♔")) {
                    if (_map[10][b._y - 1] != null && _map[10][b._y - 1].getType().equals("♟") && _map[10][b._y + 1] != null && _map[10][b._y + 1].getType().equals("♟")) {
                        _map[10][b._y] = null;
                        return true;
                    }
                }
            }
            //left
            if (b._x == 0 || b._x == 1) {
                if (_map[0][b._y + 1] != null && _map[0][b._y + 1].getType().equals("♔")) {
                    if (_map[0][b._y + 2] != null && _map[0][b._y + 2].getType().equals("♟") && _map[1][b._y + 1] != null && _map[1][b._y + 1].getType().equals("♟")) {
                        _map[0][b._y + 1] = null;
                        return true;
                    }
                }
                if (_map[0][b._y - 1] != null && _map[0][b._y - 1].getType().equals("♔")) {
                    if (_map[0][b._y - 2] != null && _map[0][b._y - 2].getType().equals("♟") && _map[1][b._y - 1] != null && _map[1][b._y - 1].getType().equals("♟")) {
                        _map[0][b._y - 1] = null;
                        return true;
                    }
                }
                if (_map[0][b._y] != null && _map[0][b._y].getType().equals("♔")) {
                    if (_map[0][b._y - 1] != null && _map[0][b._y - 1].getType().equals("♟") && _map[0][b._y + 1] != null && _map[0][b._y + 1].getType().equals("♟")) {
                        _map[0][b._y] = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean move(Position a, Position b) {
        //check weather or not b position is valid:
        if (a.equals(b)) {
            return false;
        }
        if (!isEmpty(b)) {
            return false;
        }
        if (isDiagonal(a, b)) {
            return false;
        }
        int direction = direction(a, b);
        if (direction == 1 && !isRightValid(a, b)) {
            return false;
        }
        if (direction == 2 && !isLeftValid(a, b)) {
            return false;
        }
        if (direction == 3 && !isUpValid(a, b)) {
            return false;
        }
        if (direction == 4 && !isDownValid(a, b)) {
            return false;
        }
        if (!isValidTurn(a)) {
            return false;
        }
        if (!corners(a, b)) {
            return false;
        }
        eatPawn(a, b);
        //if the king is on the corners:
        if (_map[a._x][a._y] != null && _map[a._x][a._y].getType().equals("♔")) {
            if (b._x == 0 && b._y == 0) {
                _player1._wins++;
                _isGameFinished = true;
            }
            if (b._x == 0 && b._y == 10) {
                _player1._wins++;
                _isGameFinished = true;

            }
            if (b._x == 10 && b._y == 0) {
                _player1._wins++;
                _isGameFinished = true;

            }
            if (b._x == 10 && b._y == 10) {
                _player1._wins++;
                _isGameFinished = true;
            }
        }
        if (eatKing(a, b)) {
            _player2._wins++;
            _isGameFinished = true;
        }
        //move the piece:
        _map[b._x][b._y] = _map[a._x][a._y];
        _map[b._x][b._y]._position._x = b._x;
        _map[b._x][b._y]._position._y = b._y;
        Map.Entry<Position, ConcretePiece> map = new AbstractMap.SimpleEntry<>(a, _map[b._x][b._y]);
        _stackForUndo.push(map);
        _map[a._x][a._y] = null;
        //change the turn:
        if (this._isPlayer2Turn) {
            _isPlayer2Turn = false;
        } else {
            _isPlayer2Turn = true;
        }
        _map[b._x][b._y].set_Steps(b);
        return true;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        return _map[position._x][position._y];
    }

    @Override
    public Player getFirstPlayer() {
        return this._player1;
    }

    @Override
    public Player getSecondPlayer() {
        return this._player2;
    }

    @Override
    public boolean isGameFinished() {
        return _isGameFinished;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return _isPlayer2Turn;
    }

    @Override
    public void reset() {
        this._isPlayer2Turn = true;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                _map[i][j] = null;
            }
        }
        _map[3][0] = new Pawn(new Position(0, 3), 1, _player2, "♟");
        _map[4][0] = new Pawn(new Position(0, 4), 2, _player2, "♟");
        _map[5][0] = new Pawn(new Position(0, 5), 3, _player2, "♟");
        _map[6][0] = new Pawn(new Position(0, 6), 4, _player2, "♟");
        _map[7][0] = new Pawn(new Position(0, 7), 5, _player2, "♟");
        _map[5][1] = new Pawn(new Position(5, 1), 6, _player2, "♟");
        _map[0][3] = new Pawn(new Position(3, 0), 7, _player2, "♟");
        _map[10][3] = new Pawn(new Position(3, 10), 8, _player2, "♟");
        _map[0][4] = new Pawn(new Position(4, 0), 9, _player2, "♟");
        _map[10][4] = new Pawn(new Position(4, 10), 10, _player2, "♟");
        _map[0][5] = new Pawn(new Position(5, 0), 11, _player2, "♟");
        _map[1][5] = new Pawn(new Position(5, 1), 12, _player2, "♟");
        _map[9][5] = new Pawn(new Position(5, 9), 13, _player2, "♟");
        _map[10][5] = new Pawn(new Position(5, 10), 14, _player2, "♟");
        _map[0][6] = new Pawn(new Position(6, 0), 15, _player2, "♟");
        _map[10][6] = new Pawn(new Position(6, 10), 16, _player2, "♟");
        _map[0][7] = new Pawn(new Position(7, 0), 17, _player2, "♟");
        _map[10][7] = new Pawn(new Position(7, 10), 18, _player2, "♟");
        _map[5][9] = new Pawn(new Position(9, 5), 19, _player2, "♟");
        _map[3][10] = new Pawn(new Position(10, 3), 20, _player2, "♟");
        _map[4][10] = new Pawn(new Position(10, 4), 21, _player2, "♟");
        _map[5][10] = new Pawn(new Position(10, 5), 22, _player2, "♟");
        _map[6][10] = new Pawn(new Position(10, 6), 23, _player2, "♟");
        _map[7][10] = new Pawn(new Position(10, 7), 24, _player2, "♟");
        _map[5][5] = new King(new Position(5, 5), 7, _player1, "♔");
        _map[5][3] = new Pawn(new Position(3, 5), 1, _player1, "♙");
        _map[4][4] = new Pawn(new Position(4, 4), 2, _player1, "♙");
        _map[5][4] = new Pawn(new Position(4, 5), 3, _player1, "♙");
        _map[6][4] = new Pawn(new Position(4, 6), 4, _player1, "♙");
        _map[3][5] = new Pawn(new Position(5, 3), 5, _player1, "♙");
        _map[4][5] = new Pawn(new Position(5, 4), 6, _player1, "♙");
        _map[6][5] = new Pawn(new Position(5, 6), 8, _player1, "♙");
        _map[7][5] = new Pawn(new Position(5, 7), 9, _player1, "♙");
        _map[4][6] = new Pawn(new Position(6, 4), 10, _player1, "♙");
        _map[5][6] = new Pawn(new Position(6, 5), 11, _player1, "♙");
        _map[6][6] = new Pawn(new Position(6, 6), 12, _player1, "♙");
        _map[5][7] = new Pawn(new Position(7, 5), 13, _player1, "♙");
        _isGameFinished = false;
    }

    @Override
    public void undoLastMove() {
        _map[_stackForUndo.peek().getKey()._x][_stackForUndo.peek().getKey()._y] = _stackForUndo.peek().getValue();
        _map[_stackForUndo.peek().getValue()._position._x][_stackForUndo.peek().getValue()._position._y] = null;
        _stackForUndo.pop();
        if (_wasEaten == true && _stackForEatenUndo != null) {
            _map[_stackForEatenUndo.peek()._position._x][_stackForEatenUndo.peek()._position._y] = _stackForEatenUndo.peek();
            _stackForEatenUndo.pop();
            _wasEaten = false;
        }
        _isPlayer2Turn = !_isPlayer2Turn;
    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}

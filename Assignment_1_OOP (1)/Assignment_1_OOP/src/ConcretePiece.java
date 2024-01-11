import java.util.ArrayList;

public class ConcretePiece implements  Piece {
    protected Position _position;
    private int _ID;
    private ConcretePlayer _owner;
    private String _type;
    private ArrayList <Position> _steps = new ArrayList<>();
    public ConcretePiece(Position p,int id,ConcretePlayer owner, String type){
        this._ID=id;
        this._position=p;
        this._owner = owner;
        this._type = type;
    }

    @Override
    public Player getOwner() {
        return this._owner;
    }

    @Override
    public String getType() {
        return this._type;
    }
    public int get_ID(){
        return this._ID;
    }
    public ConcretePlayer get_owner(){
        return this._owner;
    }
    public void set_Steps(Position p ){
        _steps.add(p);
    }
    public ArrayList get_Steps(){
        return this._steps;
    }

}

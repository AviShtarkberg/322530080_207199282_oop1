public class ConcretePlayer implements Player {
    private int _num;
    public int _wins;

    public ConcretePlayer(int num){
        this._num=num;
        this._wins= 0;
    }

    @Override
    public boolean isPlayerOne() {
        return this._num==1;
    }

    @Override
    public int getWins() {
        return this._wins;
    }
}

public class Block {
    int posx, posy;
    int distance;
    Block previous;
    char lastMove;

    public Block(int posx, int posy, int distance, Block previous, char lastMove) {
        this.posx = posx;
        this.posy = posy;
        this.distance = distance;
        this.previous = previous;
        this.lastMove = lastMove;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Block getPrevious() {
        return previous;
    }

    public void setPrevious(Block previous) {
        this.previous = previous;
    }

    public char getLastMove() {
        return lastMove;
    }

    public void setLastMove(char lastMove) {
        this.lastMove = lastMove;
    }
}

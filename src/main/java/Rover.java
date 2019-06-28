public class Rover {
    private final Orientation orientation;
    private final Position position;

    public Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }
    public Rover() {
        this.position = new Position(0,0);
        this.orientation = new Orientation(CardinalPoint.NORTH);
    }

    public Position getPosition() {
        return position;
    }
}

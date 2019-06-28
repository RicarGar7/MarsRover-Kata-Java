public class Position {
    private final int xAxis;
    private final int yAxis;

    public Position(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "Position{" +
                "xAxis=" + xAxis +
                ", yAxis=" + yAxis +
                '}';
    }
}

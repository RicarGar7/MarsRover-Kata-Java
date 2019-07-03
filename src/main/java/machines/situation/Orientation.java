package machines.situation;

public class Orientation {

    private final CardinalPoint cardinalPoint;

    public Orientation(CardinalPoint cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    public CardinalPoint getCardinalPoint() {
        return cardinalPoint;
    }

    @Override
    public String toString() {
        return "Orientation{" +
                "cardinalPoint=" + cardinalPoint +
                '}';
    }
}

public interface Machine {
    char getInstruction();
    Position getPosition();
    void setPosition(Position position);
    Orientation getOrientation();
    void setOrientation(Orientation orientation);
    int[] getAxisHelper();
    void setAxisHelper(int[] axisHelper);
    void addComponent(Component component);
    void removeComponent(Component component);
}

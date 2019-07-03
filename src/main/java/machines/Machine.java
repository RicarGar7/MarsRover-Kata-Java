package machines;

import components.Component;
import machines.situation.Position;

public interface Machine {
    char getInstruction();
    Position getPosition();
    void setPosition(Position position);
    void addComponent(Component component);
    void removeComponent(Component component);
}

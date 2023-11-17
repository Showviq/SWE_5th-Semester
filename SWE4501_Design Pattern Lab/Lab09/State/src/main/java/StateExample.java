// Context
class LightSwitch {
    private State state;

    public LightSwitch() {
        this.state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void performOperation() {
        state.operation(this);
    }
}

// State interface
interface State {
    void operation(LightSwitch lightSwitch);
}

// Concrete state
class OnState implements State {
    @Override
    public void operation(LightSwitch lightSwitch) {
        System.out.println("Turning the light off");
        lightSwitch.setState(new OffState());
    }
}

// Concrete state
class OffState implements State {
    @Override
    public void operation(LightSwitch lightSwitch) {
        System.out.println("Turning the light on");
        lightSwitch.setState(new OnState());
    }
}

// Client part
public class StateExample {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();

        lightSwitch.performOperation(); // Turning on
        lightSwitch.performOperation(); // Turning off
    }
}
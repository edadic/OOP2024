package week13.labs.task5;

interface TrafficLightState {
    void transitionToRed(TrafficLightContext context);
    void transitionToGreen(TrafficLightContext context);
    void transitionToYellow(TrafficLightContext context);
}

class RedLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Already in Red state.");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transitioning to Green state.");
        context.setState(new GreenLightState());
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transitioning to Yellow state.");
        context.setState(new YellowLightState());
    }
}

class YellowLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Transitioning to Red state.");
        context.setState(new RedLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transitioning to Green state.");
        context.setState(new GreenLightState());
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Already in Yellow state.");
    }
}

class GreenLightState implements TrafficLightState {
    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Transitioning to Red state.");
        context.setState(new RedLightState());
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Already in Green state.");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transitioning to Yellow state.");
        context.setState(new YellowLightState());
    }
}

class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void transitionToRed() {
        state.transitionToRed(this);
    }

    public void transitionToGreen() {
        state.transitionToGreen(this);
    }

    public void transitionToYellow() {
        state.transitionToYellow(this);
    }
}


public class TrafficLightController {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();
    }
}

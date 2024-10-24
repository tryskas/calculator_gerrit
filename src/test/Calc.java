package test;

public class Calc {

    private float state = 0.0f;

    public Float getState() {
        return state;
    }

    public Float pressKey(float i) {
        state=10*state+i;
        return state;
    }

    public void add() {
        state = 0;
    }
}
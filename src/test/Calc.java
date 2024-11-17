package test;

public class Calc {

    private Float state = 0.0f;

    private boolean negative = false;

    public Float getState() {
        return negative ? - state : state;
    }

    public Float pressKey(float i) {
        if (i < 0) {
            negative = true;
        } else {
            state = state*10 + i;
        }
        
        return getState();
    }

    public void add() {
        state = 0.0f;
    }

    public Float equal() {
        state = state + 3.0f; //simple change
        return getState();
    }
    
}
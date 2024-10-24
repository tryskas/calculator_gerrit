package test;
 
import static org.junit.jupiter.api.Assertions.*;
 
import java.util.stream.Stream;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
 
public class CalcTest {
 
    public static Stream<Arguments> keyPressArgs() {
        return Stream.of(
            Arguments.of(new int[] {0}, 0.0f),
            Arguments.of(new int[] {9}, 9.0f),
            Arguments.of(new int[] {0, 9}, 9.0f),
            Arguments.of(new int[] {4, 2}, 42.0f)
        );
    }
 
    private Calc sut;
 
    @BeforeEach
    public void createSut(){
        sut = new Calc();
    }
     
    @Test
    public void initialState() {
        Float state = sut.getState();
        assertEquals(0.0f, state, Float.MIN_NORMAL);
    }
 
    /* 
 
    @Test
    public void pressZeroKey() {
        Float nb = sut.pressKey(0);
        Float state = sut.getState();
        assertEquals(0.0f, state, Float.MIN_NORMAL);
        assertEquals(0.0f, nb, Float.MIN_NORMAL);
    }
 
    @Test
    public void pressAKey(){
        Float nb = sut.pressKey(9);
        Float state = sut.getState();
        assertEquals(9.0f, state, Float.MIN_NORMAL);
        assertEquals(9.0f, nb, Float.MIN_NORMAL);
    }
 
    @Test
    public void pressTwoKey(){
        sut.pressKey(0);
        Float nb = sut.pressKey(9);
        Float state = sut.getState();
        assertEquals(9.0f, state, Float.MIN_NORMAL);
        assertEquals(9.0f, nb, Float.MIN_NORMAL);
    }
 
    @Test
    public void pressTwoDigitsNumber(){
        sut.pressKey(4);
        Float nb = sut.pressKey(2);
        Float state = sut.getState();
        assertEquals(42.0f, state, Float.MIN_NORMAL);
        assertEquals(42.0f, nb, Float.MIN_NORMAL);
    } */
 
    // The following test method replaces the previous 4
 
    @ParameterizedTest
    @MethodSource("keyPressArgs")
    public void pressKeys(int [] keys, float result) {
        Float nb = 0.0f;
        for (int k : keys) {
            nb = sut.pressKey(k);
        }
        Float state = sut.getState();
        assertEquals(result, state, Float.MIN_NORMAL);
        assertEquals(result, nb, Float.MIN_NORMAL);
    }
 
    @Test
    public void testTypeAddition(){
        sut.pressKey(4);
        sut.add();
        Float nb = sut.pressKey(2);
        Float state = sut.getState();
        assertEquals(2.0f, state, Float.MIN_NORMAL);
        assertEquals(2.0f, nb, Float.MIN_NORMAL);
    }
 
}
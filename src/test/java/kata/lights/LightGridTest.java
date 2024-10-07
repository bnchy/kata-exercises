package kata.lights;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LightGridTest {

  LightGrid grid;

  @BeforeEach
  void setUp() {
    this.grid = new LightGrid();
  }

  @Test
  void shouldTurnOnASingleLight() {
    int x1 = 0;
    int y1 = 0;
    grid = new LightGrid();
    grid.turnOn(x1, y1);

    boolean[][] foundLights = grid.getLights();
    Assertions.assertTrue(foundLights[0][0]);
  }

  @Test
  void shouldTurnOffASingleLight() {
    int x1 = 0;
    int y1 = 0;
    grid.turnOff(x1, y1);

    boolean[][] foundLights = grid.getLights();
    Assertions.assertFalse(foundLights[0][0]);
  }

  @Test
  void shouldTurnOnARowOf1000Lights() {
    int x1 = 0;
    int y1 = 0;
    int x2 = 999;
    int y2 = 0;

    grid.turnOn(x1, y1, x2, y2);
    boolean[][] foundLights = grid.getLights();
    for (int i = 0; i <= 999; i++) {
      Assertions.assertTrue(foundLights[i][0]);
    }
  }

  @Test
  void shouldTurnOffARowOf1000Lights() {
    int x1 = 0;
    int y1 = 1;
    int x2 = 999;
    int y2 = 1;

    grid.turnOn(x1, y1, x2, y2);
    grid.turnOff(x1, y1, x2, y2);

    boolean[][] foundLights = grid.getLights();
    for (int i = 0; i <= 999; i++) {
      Assertions.assertFalse(foundLights[i][1]);
    }
  }

  @Test
  void shouldTurnOnAllLights() {
    int x1 = 0;
    int y1 = 0;
    int x2 = 999;
    int y2 = 999;

    grid.turnOn(x1, y1, x2, y2);
    boolean[][] foundLights = grid.getLights();

    for (int i = 0; i <= 999; i++) {
      for (int j = 0; j <= 999; j++) {
        Assertions.assertTrue(foundLights[i][j]);
      }
    }
  }

  @Test
  void shouldTurnOffAllLights() {
    int x1 = 0;
    int y1 = 0;
    int x2 = 999;
    int y2 = 999;

    grid.turnOff(x1, y1, x2, y2);
    boolean[][] foundLights = grid.getLights();

    for (int i = 0; i <= 999; i++) {
      for (int j = 0; j <= 999; j++) {
        Assertions.assertFalse(foundLights[i][j]);

      }
    }
  }

  @Test
  void shouldToggleRowOfLights(){
    int x1 =0;
    int y1 = 0;
    int x2 = 900;
    int y2 = 0;

    grid.turnOn(0, 0, 999, 999); //turn on all lights to check if they toggled true => false
    grid.toggle(x1,y1,x2,y2);


    boolean[][] foundLights = grid.getLights();

    for (int i= Math.min(x1,x2); i<= Math.max(x1,x2); i++ ) {
      for (int k = Math.min(y1, y2); k <= Math.max(y1,y2); k++ ) {
        Assertions.assertFalse(foundLights[i][k]);
      }
    }

    //separate to test the other lights are still on
    Assertions.assertTrue(foundLights[1][1]);

  }

  @Test
  void shouldThrowExceptionWhenOutsideOfRange() {
    int x1 = 0;
    int y1 = 0;
    int x2 = 1001;
    int y2 = 999;
    Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> grid.turnOn(x1, y1, x2, y2));
  }

  @Test
  void shouldTestSantasInstructions(){
    grid.turnOn(887,9,959,629);
    grid.turnOn(454,389,844,488);
    grid.turnOff(539,243,559,965);
    grid.turnOff(370, 819, 676, 868);
    grid.turnOff(145,40,370,997);
    grid.turnOff(301, 3, 808, 453);
    grid.turnOn(351, 678, 951, 908);
    grid.toggle(720,196,897, 994);
    grid.toggle(831,394, 904, 860 );

    boolean[][] foundLights = grid.getLights();

    int counter = 0;

    for(int i = 0; i <= 999; i++){
      for(int j = 0; j <= 999; j++){
        if(foundLights[i][j]){
          counter++;
        }
      }
    }

    Assertions.assertEquals(234950, counter);
  }



}

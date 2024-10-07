package kata.lights;

public class LightGrid {
  private boolean[][] lights;

  public LightGrid() {
    lights = new boolean[1000][1000];
  }

  public boolean[][] getLights() {
    return lights;
  }

  public void turnOn(int x1, int y1) {
    lights[x1][y1] = true;
  }
  public void turnOff(int x1, int y1) {
    lights[x1][y1] = false;
  }
  public void turnOn(int x1, int y1, int x2, int y2) {
    for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
      for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
        lights[i][j] = true;
      }
    }
  }

  public void turnOff(int x1, int y1, int x2, int y2) {

    for(int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
      for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
        lights[i][j] = false;
      }
    }
  }

  public void toggle(int x1, int y1, int x2, int y2) {
    for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++){
      for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++){
        lights[i][j] = !lights[i][j];

      }
    }
  }
}

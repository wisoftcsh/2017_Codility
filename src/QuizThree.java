import java.util.ArrayList;
import java.util.List;

public class QuizThree {
  private List<Integer> list = new ArrayList<>();
  private List<Location> locationList = new ArrayList<>();

  QuizThree() {
  }

  public int solution(int[] A) {
    addValue(A);
    return start();
  }

  private void addValue(int[] A) {
    for (int i : A) {
      list.add(i);
    }
  }

  private int start() {
    int loop = 0;
    Location turtle = new Location(0, 0);
    locationList.add(turtle);
    for (int i : list) {

      switch (loop % 4) {
        case 0:
          turtle.setLocation(turtle.getX(), turtle.getY() + i);
          break;
        case 1:
          turtle.setLocation(turtle.getX() + i, turtle.getY());
          break;
        case 2:
          turtle.setLocation(turtle.getX(), turtle.getY() - i);
          break;
        case 3:
          turtle.setLocation(turtle.getX() - i, turtle.getY());
          break;
      }
      loop++;
      locationList.add(new Location(turtle.getX(), turtle.getY()));
      if (checkPath(turtle, loop % 4)) {
        return loop + 1;
      }
    }
    return 0;
  }

  private boolean checkPath(Location turtle, int loop) {
    try {
      switch (loop) {
        case 0:
          int minX = 9999;
          for (Location location : locationList) {
            if (location.getX() < minX) {
              minX = location.getX();
            }
          }
          if (minX < turtle.getX()) {
            return true;
          }
          break;
        case 1:
          int maxY = -9999;
          for (Location location : locationList) {
            if (location.getY() > maxY) {
              maxY = location.getY();
            }
          }
          if (maxY > turtle.getY()) {
            return true;
          }
          break;
        case 2:
          int maxX = -9999;
          for (Location location : locationList) {
            if (location.getX() > maxX) {
              maxX = location.getX();
            }
          }
          if (maxX > turtle.getX()) {
            return true;
          }
          break;
        case 3:
          int minY = 9999;
          for (Location location : locationList) {
            if (location.getY() < minY) {
              minY = location.getY();
            }
          }
          if (minY < turtle.getY()) {
            return true;
          }
          break;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  class Location {
    private int x;
    private int y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}

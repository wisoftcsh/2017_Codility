import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class QuizOne {
  private List<Integer> list = new ArrayList<>();
  private String time = "";
  private boolean flag = false;

  QuizOne() {
  }

  public String solution(int A, int B, int C, int D, int E, int F) {
    addValue(A, B, C, D, E, F);
    Collections.sort(list);
    time = first(list.get(0)) + second(list.get(1)) + first(list.get(2)) + second(list.get(3)) + first(list.get(4)) + first(list.get(5));
    if (!checkAvailableString()) {
      return "NOT POSSIBLE";
    }
    list.clear();
    return time;
  }

  private void addValue(int A, int B, int C, int D, int E, int F) {
    list.add(A);
    list.add(B);
    list.add(C);
    list.add(D);
    list.add(E);
    list.add(F);
  }

  private String first(int number) {
    return String.valueOf(number);
  }

  private String second(int number) {
    return String.valueOf(number) + ":";
  }

  private boolean checkAvailableString() {
    StringTokenizer st = new StringTokenizer(time, ":");
    int count = 0;
    try {
      while (st.hasMoreTokens()) {
        int tmp = Integer.parseInt(st.nextToken());
        if ((tmp > 12 && count == 0) || (tmp > 60 && count == 1)) {
          return false;
        } else if (tmp > 60 && count == 2) {
          if (flag) {
            StringBuilder builder = new StringBuilder(time);
            char swapString = time.charAt(1);
            builder.setCharAt(1, time.charAt(6));
            builder.setCharAt(6, swapString);
            time = builder.toString();
            return true;
          }
          time = time.replaceFirst(time.substring(4, 7), new StringBuffer(time.substring(4, 7)).reverse().toString());
          flag = true;
          return checkAvailableString();
        }
        count++;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

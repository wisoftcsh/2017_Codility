import java.util.ArrayList;
import java.util.List;

public class QuizTwo {
  List<Integer> list = new ArrayList<>();

  QuizTwo() {
  }

  public int solution(int[] A, int S) {
    addValue(A);
    return subListSum(S);
  }

  private void addValue(int[] A) {
    for (int i : A) {
      list.add(i);
    }
  }

  private int subListSum(int S) {
    List<Integer> originList = new ArrayList<>();
    List<Integer> subList;
    int copySize;
    int startIndex = 0;
    int sum = 0;
    for (int size = list.size(); size > 0; size--) {
      copySize = size;
      while (startIndex <= (list.size() - size)) {
        originList.addAll(list);
        subList = originList.subList(startIndex, copySize);
        for (int n : subList) {
          sum += n;
        }
        if (sum == S) {
          return size;
        }
        startIndex++;
        copySize++;
        sum = 0;
        originList.clear();
      }
      startIndex = 0;
    }
    return -1;
  }
}

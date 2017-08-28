public class Main {
  public static void main(String[] args) {
    QuizThree quizThree = new QuizThree();
    QuizTwo quizTwo = new QuizTwo();
    QuizOne quizOne = new QuizOne();

    System.out.println(quizOne.solution(0, 0, 0, 7, 8, 9));
    System.out.println(quizOne.solution(1,5,3,0,6,7));
    System.out.println(quizOne.solution(1,8,3,2,6,4));
    System.out.println(quizOne.solution(2,4,5,9,5,9));
    int[] a = {1,0,-1,1,1,-1,-1};
    System.out.println(quizTwo.solution(a, 2));
    int[] b= {1,3,2,5,4,4,6,3,2};
    int[] c = {1,1,2,2,1,1};
    System.out.println(quizThree.solution(b));
    System.out.println(quizThree.solution(c));
  }
}

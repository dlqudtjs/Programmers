import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws Exception {
        solution(new int[][] { { 40, 10, 10 }, { 20, 5, 0 }, { 30, 30, 30 }, { 70, 0, 70 }, { 100, 100, 100 } });
    }

    public static int solution(int[][] ability) {
        int answer = 0;

        int row = ability.length;
        int col = ability[0].length;

        Person[][] persons = new Person[col][col]; // 가장 높은 순위를 열의 개수만큼 생성
        PriorityQueue<Person> pq = new PriorityQueue<Person>(new Comparator<Person>() {

            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getAbility() == p2.getAbility()) {
                    return p2.getId() - p1.getId();
                }

                return p2.getAbility() - p1.getAbility();
            }
        });

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                pq.add(new Person(j, ability[j][i]));
            }

            for (int j = 0; j < row; j++) {
                Person selectPerson = pq.poll();
                persons[j][i] = selectPerson;
            }
        }

        answer = dfs(0, 0, 0, persons);

        return answer;
    }

    public static int dfs(int depth, int index, int sum, Person[][] persons) {
        // if(depth == )

        return 1;
    }
}

class Person {
    private int id;
    private int ability;

    Person(int id, int ability) {
        this.id = id;
        this.ability = ability;
    }

    int getId() {
        return id;
    }

    int getAbility() {
        return ability;
    }
}

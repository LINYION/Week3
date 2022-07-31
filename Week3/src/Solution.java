import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        //现存需排队人数
        int n = tickets.length;
        //排队时间
        int time = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                tickets[i]--;
                if (tickets[i] > -1) {
                    time++;
                }
            }
        }
        return time;
    }

    class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<Integer>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }


    class AnimalShelf {

        LinkedList<int[]> queueCat;
        LinkedList<int[]> queueDog;

        public AnimalShelf() {
            queueCat = new LinkedList<>();
            queueDog = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            // 判断种类后入队
            switch (animal[1]) {
                case 0 : queueCat.addLast(animal); break;
                case 1 : queueDog.addLast(animal); break;
            }
        }

        // 挑选所有动物中最老的
        public int[] dequeueAny() {
            if (queueCat.isEmpty() && queueDog.isEmpty()) {
                return new int[]{-1, -1};
            }
            if (queueCat.isEmpty() || queueDog.isEmpty()) {
                return queueCat.isEmpty() ? queueDog.removeFirst() : queueCat.removeFirst();
            }
            int[] headCat = queueCat.getFirst();
            int[] headDog = queueDog.getFirst();
            if (headCat[0] < headDog[0]) {
                return queueCat.removeFirst();
            }
            return queueDog.removeFirst();
        }

        // 挑选狗
        public int[] dequeueDog() {
            if (queueDog.isEmpty()) {
                return new int[]{-1, -1};
            }
            return queueDog.removeFirst();
        }

        // 挑选猫
        public int[] dequeueCat() {
            if (queueCat.isEmpty()) {
                return new int[]{-1, -1};
            }
            return queueCat.removeFirst();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,1,1};
        System.out.println(timeRequiredToBuy(arr,0));
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque(10000);

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push_front")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.pushFront(value);
            } else if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                deque.pushBack(value);
            } else if (command.equals("pop_front")) {
                sb.append(deque.popFront()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.popBack()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.back()).append("\n");
            }
        }

        System.out.print(sb);
    }
}

class Deque {
    private int[] data;
    private int front;
    private int back;
    private int size;

    public Deque(int capacity) {
        data = new int[capacity];
        front = 0;
        back = 0;
        size = 0;
    }

    public void pushFront(int value) {
        front = (front - 1 + data.length) % data.length;
        data[front] = value;
        size++;
    }

    public void pushBack(int value) {
        data[back] = value;
        back = (back + 1) % data.length;
        size++;
    }

    public int popFront() {
        if (isEmpty()) return -1;
        int value = data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public int popBack() {
        if (isEmpty()) return -1;
        back = (back - 1 + data.length) % data.length;
        int value = data[back];
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() {
        return isEmpty() ? -1 : data[front];
    }

    public int back() {
        return isEmpty() ? -1 : data[(back - 1 + data.length) % data.length];
    }
}

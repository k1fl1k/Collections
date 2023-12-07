import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueueCollections {

    public void queueTest() {
        int dataSize = 1000000;

        Queue<Integer> linkedListQueue = new LinkedList<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));
        Queue<Integer> arrayDequeQueue = new ArrayDeque<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));
        Queue<Integer> priorityQueue = new PriorityQueue<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));

        // Enqueue and Dequeue (offer, poll)
        measureTime("LinkedList Queue enqueue/dequeue", () -> performEnqueueDequeue(linkedListQueue));
        measureTime("ArrayDeque Queue enqueue/dequeue", () -> performEnqueueDequeue(arrayDequeQueue));
        measureTime("PriorityQueue enqueue/dequeue", () -> performEnqueueDequeue(priorityQueue));

        // Peek
        measureTime("LinkedList Queue peek", () -> performPeek(linkedListQueue));
        measureTime("ArrayDeque Queue peek", () -> performPeek(arrayDequeQueue));
        measureTime("PriorityQueue peek", () -> performPeek(priorityQueue));
    }

    private static void measureTime(String operationName, Runnable operation) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.println(operationName + " time: " + (endTime - startTime) + " ms");
    }

    private static void performEnqueueDequeue(Queue<Integer> queue) {
        for (int i = 0; i < 100000; i++) {
            queue.offer(i);
        }
        for (int i = 0; i < 100000; i++) {
            queue.poll();
        }
    }

    private static void performPeek(Queue<Integer> queue) {
        for (int i = 0; i < 100000; i++) {
            queue.peek();
        }
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ListCollections {
    public void listTest(){

        int dataSize = 1000000;

        List<Integer> arrayList = new ArrayList<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));
        List<Integer> linkedList = new LinkedList<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));

        // CRUD операции
        measureTime("ArrayList CRUD", () -> performCRUDOperations(arrayList));
        measureTime("LinkedList CRUD", () -> performCRUDOperations(linkedList));

        // Filter
        measureTime("ArrayList filter", () -> performFilterOperation(arrayList));
        measureTime("LinkedList filter", () -> performFilterOperation(linkedList));

        // Sort
        measureTime("ArrayList sort", () -> performSortOperation(arrayList));
        measureTime("LinkedList sort", () -> performSortOperation(linkedList));

        // Find
        measureTime("ArrayList find", () -> performFindOperation(arrayList));
        measureTime("LinkedList find", () -> performFindOperation(linkedList));

        // Concat
        measureTime("ArrayList concat", () -> performConcatOperation(arrayList));
        measureTime("LinkedList concat", () -> performConcatOperation(linkedList));

        // Reduce
        measureTime("ArrayList reduce", () -> performReduceOperation(arrayList));
        measureTime("LinkedList reduce", () -> performReduceOperation(linkedList));

        // Match
        measureTime("ArrayList match", () -> performMatchOperation(arrayList));
        measureTime("LinkedList match", () -> performMatchOperation(linkedList));

        // Counting
        measureTime("ArrayList counting", () -> performCountingOperation(arrayList));
        measureTime("LinkedList counting", () -> performCountingOperation(linkedList));

        // Sum
        measureTime("ArrayList sum", () -> performSumOperation(arrayList));
        measureTime("LinkedList sum", () -> performSumOperation(linkedList));

        // Average
        measureTime("ArrayList average", () -> performAverageOperation(arrayList));
        measureTime("LinkedList average", () -> performAverageOperation(linkedList));
    }

    private static void measureTime(String operationName, Runnable operation) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.println(operationName + " time: " + (endTime - startTime) + " ms");
    }

    private static void performCRUDOperations(List<Integer> list) {
        // Add
        list.add(1000000);
        // Update
        list.set(0, 999);
        // Remove
        list.remove(1000000);
    }

    private static void performFilterOperation(List<Integer> list) {
        list.stream().filter(value -> value % 2 == 0).collect(Collectors.toList());
    }

    private static void performSortOperation(List<Integer> list) {
        list.sort(Integer::compareTo);
    }

    private static void performFindOperation(List<Integer> list) {
        list.contains(500000);
    }

    private static void performConcatOperation(List<Integer> list) {
        List<Integer> anotherList = new ArrayList<>(IntStream.range(1000000, 2000000).boxed().collect(Collectors.toList()));
        list.addAll(anotherList);
    }

    private static void performReduceOperation(List<Integer> list) {
        list.stream().reduce(Integer::sum);
    }

    private static void performMatchOperation(List<Integer> list) {
        list.stream().anyMatch(value -> value == 500000);
    }

    private static void performCountingOperation(List<Integer> list) {
        list.stream().filter(value -> value % 2 == 0).count();
    }

    private static void performSumOperation(List<Integer> list) {
        list.stream().mapToInt(Integer::intValue).sum();
    }

    private static void performAverageOperation(List<Integer> list) {
        list.stream().mapToInt(Integer::intValue).average();
    }
}
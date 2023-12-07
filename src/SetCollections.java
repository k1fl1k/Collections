import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetCollections {

    public void setTest() {
        int dataSize = 1000000;

        Set<Integer> hashSet = new HashSet<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));
        Set<Integer> treeSet = new TreeSet<>(IntStream.range(0, dataSize).boxed().collect(Collectors.toList()));

        // CRUD операції
        measureTime("HashSet CRUD", () -> performCRUDOperations(hashSet));
        measureTime("TreeSet CRUD", () -> performCRUDOperations(treeSet));

        // Filter
        measureTime("HashSet filter", () -> performFilterOperation(hashSet));
        measureTime("TreeSet filter", () -> performFilterOperation(treeSet));

        // Sort (TreeSet буде вже відсортованим)

        // Find
        measureTime("HashSet find", () -> performFindOperation(hashSet));
        measureTime("TreeSet find", () -> performFindOperation(treeSet));

        // Concat
        measureTime("HashSet concat", () -> performConcatOperation(hashSet));
        measureTime("TreeSet concat", () -> performConcatOperation(treeSet));

        // Reduce
        measureTime("HashSet reduce", () -> performReduceOperation(hashSet));
        measureTime("TreeSet reduce", () -> performReduceOperation(treeSet));

        // Match
        measureTime("HashSet match", () -> performMatchOperation(hashSet));
        measureTime("TreeSet match", () -> performMatchOperation(treeSet));

        // Counting
        measureTime("HashSet counting", () -> performCountingOperation(hashSet));
        measureTime("TreeSet counting", () -> performCountingOperation(treeSet));

        // Sum
        measureTime("HashSet sum", () -> performSumOperation(hashSet));
        // TreeSet не має оператора sum

        // Average
        measureTime("HashSet average", () -> performAverageOperation(hashSet));
        // TreeSet не має оператора average
    }

    private static void measureTime(String operationName, Runnable operation) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.println(operationName + " time: " + (endTime - startTime) + " ms");
    }

    private static void performCRUDOperations(Set<Integer> set) {
        // Add
        set.add(1000000);
        // Remove
        set.remove(1000000);
    }

    private static void performFilterOperation(Set<Integer> set) {
        set.stream().filter(value -> value % 2 == 0).collect(Collectors.toSet());
    }

    private static void performFindOperation(Set<Integer> set) {
        set.contains(500000);
    }

    private static void performConcatOperation(Set<Integer> set) {
        Set<Integer> anotherSet = new HashSet<>(IntStream.range(1000000, 2000000).boxed().collect(Collectors.toList()));
        set.addAll(anotherSet);
    }

    private static void performReduceOperation(Set<Integer> set) {
        set.stream().reduce(Integer::sum);
    }

    private static void performMatchOperation(Set<Integer> set) {
        set.stream().anyMatch(value -> value == 500000);
    }

    private static void performCountingOperation(Set<Integer> set) {
        set.stream().filter(value -> value % 2 == 0).count();
    }

    private static void performSumOperation(Set<Integer> set) {
        set.stream().mapToInt(Integer::intValue).sum();
    }

    private static void performAverageOperation(Set<Integer> set) {
        set.stream().mapToInt(Integer::intValue).average();
    }
}

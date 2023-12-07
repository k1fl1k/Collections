import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapCollections {

    public void mapTest() {
        int dataSize = 1000000;

        Map<Integer, String> hashMap = new HashMap<>(IntStream.range(0, dataSize)
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> "Value" + i)));

        Map<Integer, String> treeMap = new TreeMap<>(IntStream.range(0, dataSize)
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> "Value" + i)));

        // CRUD (put, get, remove)
        measureTime("HashMap CRUD", () -> performCRUDOperations(hashMap));
        measureTime("TreeMap CRUD", () -> performCRUDOperations(treeMap));

        // Iteration
        measureTime("HashMap iteration", () -> performIteration(hashMap));
        measureTime("TreeMap iteration", () -> performIteration(treeMap));

        // Filter
        measureTime("HashMap filter", () -> performFilterOperation(hashMap));

        // Find
        measureTime("HashMap find", () -> performFindOperation(hashMap));
        measureTime("TreeMap find", () -> performFindOperation(treeMap));

        // Concat
        measureTime("HashMap concat", () -> performConcatOperation(hashMap));

        // Match
        measureTime("HashMap match", () -> performMatchOperation(hashMap));
        measureTime("TreeMap match", () -> performMatchOperation(treeMap));

        // Counting
        measureTime("HashMap counting", () -> performCountingOperation(hashMap));
    }

    private static void measureTime(String operationName, Runnable operation) {
        long startTime = System.currentTimeMillis();
        operation.run();
        long endTime = System.currentTimeMillis();
        System.out.println(operationName + " time: " + (endTime - startTime) + " ms");
    }

    private static void performCRUDOperations(Map<Integer, String> map) {
        map.put(1000000, "Value1000000");
        String value = map.get(500000);
        map.remove(1000000);
    }

    private static void performIteration(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            // Iteration
        }
    }

    private static void performFilterOperation(Map<Integer, String> map) {
        map.entrySet().stream()
            .filter(entry -> entry.getKey() % 2 == 0)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    private static void performFindOperation(Map<Integer, String> map) {
        map.containsKey(500000);
    }

    private static void performConcatOperation(Map<Integer, String> map) {
        Map<Integer, String> anotherMap = new HashMap<>(IntStream.range(1000000, 2000000)
            .boxed()
            .collect(Collectors.toMap(i -> i, i -> "Value" + i)));
        map.putAll(anotherMap);
    }

    private static void performMatchOperation(Map<Integer, String> map) {
        map.entrySet().stream().anyMatch(entry -> entry.getValue().equals("Value500000"));
    }

    private static void performCountingOperation(Map<Integer, String> map) {
        map.entrySet().stream().filter(entry -> entry.getKey() % 2 == 0).count();
    }
}

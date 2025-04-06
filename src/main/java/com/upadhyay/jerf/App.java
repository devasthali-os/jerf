package com.upadhyay.jerf;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class App {

    public static final int FIVE_MILL = 5_000_000;
    public static final int MILLION = 1_000_000;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Initial Memory Usage:");
        printMemoryUsage(runtime);

        var s = IntStream.range(1, 10).collect(
                () -> new StringBuilder(),
                (a, b) -> a.append(b + "_"),
                (a, b) -> {
                }
        );

        System.out.println(s);

        listPerf(runtime);
    }

    public static void listPerf(Runtime runtime) {
        var prepStart = System.currentTimeMillis();

        System.out.println("Memory Usage Before Preparing List:");
        printMemoryUsage(runtime);

        List<Ad> ads = IntStream.range(1, MILLION).collect(
                () -> new ArrayList<Ad>(),
                (acc, elem) -> acc.add(
                        new Ad(
                                "adId_" + elem / 100,
                                ZonedDateTime.now(),
                                ZonedDateTime.now(),
                                "location_" + UUID.randomUUID()
                        )
                ),
                (acc, elem) -> {
                }
        );

        var start = System.currentTimeMillis();
//        System.out.println("Prep time taken " + (start - prepStart) + " ms");

        System.out.println("Memory Usage After Preparing List:");
        printMemoryUsage(runtime);

        var adIds = ads.stream().map($ -> $.adId);
        var uniqueAdIds = adIds.distinct();

        System.out.println("Unique adIds " + uniqueAdIds.count());
        var timeTaken = System.currentTimeMillis() - start;

        System.out.println("Unique search time taken " + timeTaken + " ms");
        System.out.println("Memory Usage After Processing List:");
        printMemoryUsage(runtime);
    }

    public static void printMemoryUsage(Runtime runtime) {
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = (totalMemory - freeMemory);

        System.out.printf("Total Memory: %d mb%n", totalMemory);
        System.out.printf("Free Memory: %d mb%n", freeMemory);
        System.out.printf("Used Memory: %d mb%n", usedMemory);
        System.out.println();
    }
}

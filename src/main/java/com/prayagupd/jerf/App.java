package com.prayagupd.jerf;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        var s = IntStream.range(1, 10).collect(
                () -> new StringBuilder(),
                (a, b) -> a.append(b + "_"),
                (a, b) -> {
                }
        );

        System.out.println(s);

        listPerf();
    }

    public static void listPerf() {

        List<Ad> ads = IntStream.range(1, 1000000).collect(
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

        var adIds = ads.stream().map($ -> $.adId);
        var uniqueAdIds = adIds.distinct();

        System.out.println("unique adIds " + uniqueAdIds.count());
        var timeTaken = System.currentTimeMillis() - start;

        System.out.println("time taken " + timeTaken + " ms"); //time taken 107 ms
    }

}

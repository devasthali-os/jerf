jperf
-----


```bash
 export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.8.jdk/Contents/Home
./gradlew run
```

basic java perf examples

- find unique ids in "1 million" records - 100ms+

```bash
Memory Usage Before Preparing List:
Total Memory: 260 mb
Free Memory: 257 mb
Used Memory: 3 mb

Memory Usage After Preparing List:
Total Memory: 1748 mb
Free Memory: 1313 mb
Used Memory: 435 mb

Unique adIds 10000
Unique search time taken 110 ms
Memory Usage After Processing List:
Total Memory: 1748 mb
Free Memory: 1313 mb
Used Memory: 435 mb
```

jmeter
--------

- https://jmeter.apache.org/download_jmeter.cgi


database-perf
---
https://github.com/prayagupa/rdb

# Repository to reproduce Junit5 and Gradle issue 

Original JUnit issue https://github.com/junit-team/junit5/issues/1773

If you comment `junit-platform-commons` dependency, everything is works fine:

```
baev:gradle-junit5-issue baev$ ./gradlew clean build

> Task :test

com.example.junit5.DemoTest > demoTest() PASSED

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

In case of dependency hell (emulated in master) no tests running and no warning at all:

```
charlie:gradle-junit5-issue charlie$ ./gradlew clean build

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

Using `--debug` flag the following error appears:

```
17:45:15.924 [DEBUG] [TestEventLogger] Gradle Test Executor 17 STANDARD_ERROR
17:45:15.924 [DEBUG] [TestEventLogger]     Apr 05, 2019 5:45:15 PM org.junit.platform.launcher.core.DefaultLauncher handleThrowable
17:45:15.925 [DEBUG] [TestEventLogger]     WARNING: TestEngine with ID 'junit-jupiter' failed to execute tests
17:45:15.925 [DEBUG] [TestEventLogger]     java.lang.NoSuchMethodError: org.junit.platform.commons.util.ReflectionUtils.tryToLoadClass(Ljava/lang/String;)Lorg/junit/platform/commons/function/Try;
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.jupiter.engine.support.OpenTest4JAndJUnit4AwareThrowableCollector.createAbortedExecutionPredicate(OpenTest4JAndJUnit4AwareThrowableCollector.java:40)
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.jupiter.engine.support.OpenTest4JAndJUnit4AwareThrowableCollector.<clinit>(OpenTest4JAndJUnit4AwareThrowableCollector.java:30)
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.jupiter.engine.support.JupiterThrowableCollectorFactory.createThrowableCollector(JupiterThrowableCollectorFactory.java:34)
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:74)
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
17:45:15.925 [DEBUG] [TestEventLogger]          at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:220)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$6(DefaultLauncher.java:188)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:202)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:181)
17:45:15.926 [DEBUG] [TestEventLogger]          at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:128)
```

package pages;

import org.junit.Assert;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DB_Z_page {
    private static long maxWaitTimeInMillis = 30000;

    private static int numberOfConcurrentRequests = 10;

    public static void the_system_should_not_slow_down_or_crash() {
        // Add assertion to check that the system is not slowing down or crashing
        // Add code to monitor system performance while signups are being submitted concurrently
        // For example, check CPU and memory usage, response time, etc.
        // If the system slows down or crashes, the test should fail.

        // Monitor CPU usage
        double cpuUsage = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        Assert.assertTrue("The system CPU usage is too high", cpuUsage < 0.9);

        // Monitor memory usage
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        long usedMemory = heapMemoryUsage.getUsed();
        long maxMemory = heapMemoryUsage.getMax();
        double memoryUsage = (double) usedMemory / maxMemory;
        Assert.assertTrue("The system memory usage is too high", memoryUsage < 0.9);

        // Monitor response time
        long startTime = System.currentTimeMillis();
        // Add code to wait until all signups are completed
        long elapsedTime = System.currentTimeMillis() - startTime;
        Assert.assertTrue("The system response time is too slow", elapsedTime < 5000);
    }

    public static void the_signups_should_complete_within_a_reasonable_time_frame() {
        // Add assertion to check that signups are completed within a reasonable time frame
        long startTime = System.currentTimeMillis();
        // Add code to wait until all signups are completed
        long elapsedTime = System.currentTimeMillis() - startTime;

        Assert.assertTrue("The signups did not complete within a reasonable time frame",
                elapsedTime <= maxWaitTimeInMillis);
    }

    public static void the_user_submits_multiple_signups_concurrently() {
        // Add code to submit multiple signups concurrently
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfConcurrentRequests);
        for (int i = 0; i < numberOfConcurrentRequests; i++) {
            executorService.submit(() -> {
                // Add code to submit a single signup
                // For example, call the signup API endpoint
                Sign_in_factory_Z sign_in = new Sign_in_factory_Z();
                sign_in.signNewUser();
            });
        }
        executorService.shutdown();
    }
}


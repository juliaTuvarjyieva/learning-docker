package com.jcg.selenium.junit;

import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelParameterized extends Parameterized {
    private static class ThreadPoolScheduler implements RunnerScheduler {
        private ExecutorService executor;

        public ThreadPoolScheduler() {
            System.out.println("121212121212");
            //String threads = System.getProperty("junit.parallel.threads", "2");
            //int numThreads = Integer.parseInt(threads);
            executor = Executors.newFixedThreadPool(1);
        }

        @Override
        public void finished() {
            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                throw new RuntimeException(exc);
            }
        }

        @Override
        public void schedule(Runnable childStatement) {
            executor.submit(childStatement);
        }
    }

    public ParallelParameterized(Class klass) throws Throwable {
        super(klass);
        setScheduler(new ThreadPoolScheduler());
    }
}

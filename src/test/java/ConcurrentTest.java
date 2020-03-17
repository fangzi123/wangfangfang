import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentTest {
    //1000个请求
    private static int quest_count = 10000;

    private static AtomicInteger count = new AtomicInteger(0);
    private static int count2 = 0;

    public static void main(String[] args) throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(quest_count);

        for (int i = 0; i < quest_count; i++){
            executor.execute(()->{
                try {
                    add();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        executor.shutdown();
        System.out.println("count:"+count);
        System.out.println("count2:"+count2);
    }

    private synchronized static void add(){
        count2++;
        count.incrementAndGet();
    }
}
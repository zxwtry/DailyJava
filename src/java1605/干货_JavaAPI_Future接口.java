package java1605;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 	01	java.util.concurrent ：Future<V>  接口
 * 		V 是Future的get方法得到的返回值
 * 		所有已知子接口: 	Response<T>   RunnableFuture<V>   
 * 						RunnableScheduledFuture<V>   ScheduledFuture<V>
 * 		所有已知实现类:	FutureTask   SwingWorker
 * 	02	Future 表示异步计算的接口。
 * 			1,	Future提供了检查运行是否结束的方法，并等待运行结束，获得运行结果。
 * 			2,	运行完成后，只能通过get方法来获得运行结果；可以配置运行结束前阻塞get方法。
 * 			3,	通过cancel方法可以取消运行。
 * 			4,	只为取消运行而采用Future，可以采用Future<?>类型，null作为底层任务结果。
 * 	03	
 * 		
 */
public class 干货_JavaAPI_Future接口 {
	public static void main(String[] args) {
		
	}

}

interface ArchiveSearcher {
	String search(String target);
}

class App {
	ExecutorService executor = Executors.newFixedThreadPool(4);
	ArchiveSearcher searcher = null;

	void showSearch(final String target) throws InterruptedException {
		Future<String> future = executor.submit(new Callable<String>() {
			public String call() {
				return searcher.search(target);
			}
		});
		displayOtherThings(); // do other things while searching
		try {
			displayText(future.get()); // use future
		} catch (ExecutionException ex) {
			cleanup();
			return;
		}
	}

	private void cleanup() {
	}

	private void displayText(String string) {
	}

	private void displayOtherThings() {
	}
}

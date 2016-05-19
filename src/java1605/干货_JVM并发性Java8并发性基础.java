package java1605;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/*
 * 	Source:	IBM developerworks
 * 	URL:	http://www.ibm.com/developerworks/cn/java/j-jvmc2/index.html
 * 	Title:	JVM 并发性: Java 8 并发性基础 
 * 	01:	Java8的并发改进：java.util.concurrent增加新的类和并行流。
 * 		并行流的设计目的：配合 lambda
 * 	02：	分为三部分：
 * 			一，使用 CompletableFuture 类协调异步操作；
 * 			二，如何使用并行流
 * 			三，Java8 新功能的执行方法
 * 	03：	CompletableFuture<T> 类实现 CompletionStage<T> 接口，并扩展了Future<T>类
 * 		CompletionStage　代表异步计算中的一个阶段或步骤
 * 		CompletionStage  总共有59种方法, 比Future的５中要多。
 * 	04:	Future 的用法:
 * 		在Java8之前是只有两种：检查future是否完成和等待future完成
 * 		Scala版本灵活得多，可以在future完成时执行回调函数，并以Throwable方式完成异常处理。
 * 	05:	看ChunkDistanceChecker类
 * 		
 * 
 */
public class 干货_JVM并发性Java8并发性基础 {

}

class ChunkDistanceChecker {
    private final String[] knownWords;
    public ChunkDistanceChecker(String[] knowns) {
        knownWords = knowns;
    }
    /**
    * Build list of checkers spanning word list.
    * 
    * @param words
    * @param block
    * @return checkers
    */
    public static List<ChunkDistanceChecker> buildCheckers(String[] words, int block) {
        List<ChunkDistanceChecker> checkers = new ArrayList<>();
        for (int base = 0; base < words.length; base += block) {
            int length = Math.min(block, words.length - base);
            checkers.add(new ChunkDistanceChecker(Arrays.copyOfRange(words, base, base + length)));
        }
        return checkers;    
    }
    /**
     * Find best distance from target to any known word.
     * 
     * @param target
     * @return best
     */
    public DistancePair bestDistance(String target) {
        int[] v0 = new int[target.length() + 1];
        int[] v1 = new int[target.length() + 1];
        int bestIndex = -1;
        int bestDistance = Integer.MAX_VALUE;
        boolean single = false;
        for (int i = 0; i < knownWords.length; i++) {
            int distance = editDistance(target, knownWords[i], v0, v1);
            if (bestDistance > distance) {
                bestDistance = distance;
                bestIndex = i;
                single = true;
            } else if (bestDistance == distance) {
                single = false;
            }
        }
        return single ? new DistancePair(bestDistance, knownWords[bestIndex]) :
            new DistancePair(bestDistance);
    }
    private int editDistance(String target, String string, int[] v0, int[] v1) {
		return 0;
	}
}
class DistancePair {
	public DistancePair(int bestDistance, String string) {
	}
	public DistancePair(int bestDistance) {
	}
	public static DistancePair worstMatch() {
		// TODO Auto-generated method stub
		return null;
	}
	public static DistancePair best(DistancePair best, DistancePair join) {
		// TODO Auto-generated method stub
		return null;
	}
}
class CompletableFutureDistance0 extends TimingTestBase {
    private final List<ChunkDistanceChecker> chunkCheckers;

    private final int blockSize;

    public CompletableFutureDistance0(String[] words, int block) {
        blockSize = block;
        chunkCheckers = ChunkDistanceChecker.buildCheckers(words, block);
    }
    public DistancePair bestMatch(String target) {
    	if (blockSize == 0) {
    		
    	}
        List<CompletableFuture<DistancePair>> futures = new ArrayList<>();
        for (ChunkDistanceChecker checker: chunkCheckers) {
            CompletableFuture<DistancePair> future =
                CompletableFuture.supplyAsync(() -> checker.bestDistance(target));
            futures.add(future);
        }
        DistancePair best = DistancePair.worstMatch();
        for (CompletableFuture<DistancePair> future: futures) {
            best = DistancePair.best(best, future.join());
        }
        return best;
    }
}

class TimingTestBase {
	
}
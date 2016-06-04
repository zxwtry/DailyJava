package src1606;

import java.util.Arrays;

/*
 * 	１，
 * 		在Java6的中文API中，有104个静态方法
 * 		虽然有非常多的多态方法，但是还是很多啊～！！！！
 * 	２，
 * 		在Arrays类中，只有一个静态变量：	
 * 			private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;
 * 			附带的解释是：
 * 				* The minimum array length below which a parallel sorting
     			* algorithm will not further partition the sorting task. Using
     			* smaller sizes typically results in memory contention across
     			* tasks that makes parallel speedups unlikely.
 * 			翻译过来就是：
 * 				这个数字是：数组的最小长度
				低于这个长度，一个并行的排序算法将不再对排序任务进行分割。
				使用小sizes的一个典型是：导致任务间存储冲突，让并行任务几乎不可能
	３，
		接下来就是一个　    static final class NaturalOrder implements Comparator<Object>
			描述一下：内部类，不能再被继承，叫NaturalOrder，实现Comparator接口，泛型是Object
			内部的方法是非静态方法，这个类只有在没有提供comparator才可能被使用。
				非静态方法，两个参数都是Object，返回一个(Comparable<Object>first).compareTo(second)
			还有一个静态final变量，static final NaturalOrder INSTANCE = new NaturalOrder();
	４，
		超界检查，私有静态方法，处理的方法就是抛异常
		private static void rangeCheck(int arrayLength, int fromIndex, int toIndex)
	５，
		说了一下，我们这个方法是两个pivot的，O(N*log(N))，比其他的算法不知道高到哪里去
		实现类是java.util.DualPivotQuicksort，反正很NB，不信，自己看
		如果Arrays.sort(arr)，这样调用的话，就是直接进DualPivotQuicksort
	６，
		如果是Arrays.sort(arr, sta, end)这样调用的话，两步
			A，rangeCheck
			B，DualPivotQuicksort
	７，
		有时间一定要看Float.NaN
		现在当然不看
	８，
		有一个从Java8开始的方法
		解释是：
			英文解释没有多少干货，大概意思是：	
			１，这是一个升序排序算法
			２，采用的方法是sort-merge，排序之后再归并的方法
			３，使用了线程的ForkJoin
			４，需要一个小于数组长度的额外空间
			５，如果出现
				a，子数组长度达到最小粒度
				b，数组长度小于最小粒度
				会自动选择合适的排序算法
			６，很NB，就是了。
		我叫：
			public static void parallelSort(byte[] a) {
			里面是一个很简单的判断逻辑，
				如果 数组长度小于哪个静态　||　好像是线程只能再开一个
						DualPivotQuicksort
				else
					ArraysParallelSortHelpers
					(到时候，再看)
	９，如果强行翻译的话，可能是并行前缀
		给了一个例子 [2,1,0,3] 那么就是[2,3,3,6]
		好高端。。。
		parallelPrefix
	１０，接下来就是排序，当然都是二分
		while (low <= high) {
            int mid = (low + high) >>> 1;
		是不是比你牛！！！！
		
	１１，泛型复制
		public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
	        @SuppressWarnings("unchecked")
	        T[] copy = ((Object)newType == (Object)Object[].class)
	            ? (T[]) new Object[newLength]
	            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
		是不是好高端！！！
	１２，
		copyOfRange和copyOf区别联系是什么
	１３，
		@SafeVarargs
	    @SuppressWarnings("varargs")
	    public static <T> List<T> asList(T... a) {
	        return new ArrayList<>(a);
	    }
	   　是不是好熟悉的感角
	    内部竟然写了一个小的ArrayList,给跪
	１４，
	    看看这段代码，是不是自己会写成shit
	    b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    １５，
    	又是一段从Java8开始的代码
    	 /**
     * Set all elements of the specified array, using the provided
     * generator function to compute each element.
     *
     * <p>If the generator function throws an exception, it is relayed to
     * the caller and the array is left in an indeterminate state.
     *
     * @param array array to be initialized
     * @param generator a function accepting an index and producing the desired
     *        value for that position
     * @throws NullPointerException if the generator is null
     * @since 1.8
     
    	public static void setAll(int[] array, IntUnaryOperator generator) {
	        Objects.requireNonNull(generator);
	        for (int i = 0; i < array.length; i++)
	            array[i] = generator.applyAsInt(i);
	    }
 */

/*
 * 	BinarySearch:	二分法
 * 		很常见，如果存在好说，总是能够找到的。
 * 		如果原数组中不存在的话，很容易出错，看Java是怎么写的
 */

public class Arrays是什么东西 {
	public static void main(String[] args) {
		findNegativeHashCode();
	}
	static void findNegativeHashCode() {
		int val = Integer.MAX_VALUE / (31*5);
		int[] arr = new int[6];
		Arrays.fill(arr, val);
		System.out.println(Arrays.hashCode(arr));
		//bullshit
	}
}

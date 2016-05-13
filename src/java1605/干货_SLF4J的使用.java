package java1605;

/*
 * 	01，	现在已知的日志库有 java.util.logging、Apache log4j、logback。
 * 	02，	SLF4J（Simple logging Facade for Java）不是一个真正的日志实现，
 * 		而是一个抽象层（abstraction layer），SLF4J允许使用者在后台使用
 * 		任意一个日志类库。
 * 	03，	使用SLF4J写日志语句的主要出发点是使程序独立于任意特定的日志类库。
 * 		因为依赖于特定类可能需要新的配置，增加更多的维护麻烦。
 * 	04，	占位符（place holder），在代码中表示为“{}”的特性；在运行时被某个
 * 		提供的实际字符串所替换。优点：减少字符串连接次数和节省新建String
 * 	05，	对比 log4j 与 SLF4J
 * 		log4j : 
 * 			if (logger.isDebugEnabled()) {
 * 				logger.debug("Processing trade with id: " + id + 
 * 					" symbol: " +symbol);
 * 			}
 * 		SLF4J : 
 * 			logger.debug("Processing trade with id: {} and symbol: {}"
 * 				, id, symbol);
 * 	06，	SLF4J 需要传递很多个参数怎么办？
 * 			a，	日志方法中有变量参数的版本
 * 			b，	Object数组传递
 * 			在生成最终日志信息的字符串之前，这个方法会检查能否输出对应日志。
 * 			slf4j-log4j12-1.6.1.jar 中的 log4j 的适配类 log4jLoggerAdapter
 * 		写SLF4J日志方法的代码：
 * 			public void debug(String format, Object arg1, Object arg2) {
 * 				if(logger.idDebugEnabled()) {
 * 					FormattingTuple ft = MessageFormatter.format(format, arg1, arg2);
 * 					logger.log(FQCN, Level.DEBUG, ft.getMessage(), ft.getThrowable());
 * 				}
 * 			}
 * 	07，	使用 SLF4J 做 Log4J 的日志记录，需要导入的 JAR包有：
 * 		1，	slf4j-api-1.6.1.jar			JAR for SLF4J API
 * 		2，	log4j-1.2.16.jar			JAR for Log4J API
 * 		3，	slf4j-log4j12-1.6.1.jar		Log4J Adapter for SLF4J
 * 
 */

public class 干货_SLF4J的使用 {
	
}

package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {


    // 使用SLF4J日志接口
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 环绕通知：记录Controller方法的执行信息
     *
     * @Around 注解声明环绕通知
     * execution(* com.example.demo.controller.*.*(..)) 切点表达式含义：
     *   - 第一个 * : 任意返回类型
     *   - com.example.demo.controller.* : controller包下的所有类
     *   - .*(..) : 所有方法，任意参数
     */
    @Around("execution(* com.example.demo.controller.*.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        long duration = System.currentTimeMillis() - startTime;

        // 记录结构化日志
        logger.info("Method: {} | Args: {} | Duration: {}ms | Result: {}",
                joinPoint.getSignature().getName(),  // 方法名
                joinPoint.getArgs(),                // 方法参数
                duration,                           // 执行时间(ms)
                result);                            // 返回结果

        return result;
    }
}
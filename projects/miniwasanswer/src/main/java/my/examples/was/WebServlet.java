package my.examples.was;

import java.lang.annotation.*;

/**
 * Annotation used to declare a servlet.
 *
 * <p>This annotation is processed by the container at deployment time,
 * and the corresponding servlet made available at the specified URL
 * patterns.
 *
 * @since Servlet 3.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {
    /**
     * The name of the servlet
     */
    String name() default "";

    /**
     * The URL patterns of the servlet
     */
    String value() default "";
}

package prosecutor.optval.variables;

import prosecutor.optval.ValidationException;

import java.lang.reflect.Field;

/**
 * Created by Fry on 04.09.2016.
 */
public @interface Range
    {
        public double Min() default Double.MIN_VALUE;
        public double Max() default Double.MAX_VALUE;
    }


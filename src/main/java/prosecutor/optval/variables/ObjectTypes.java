package prosecutor.optval.variables;

import com.sun.org.apache.bcel.internal.generic.ObjectType;

/**
 * Created by Fry on 04.09.2016.
 */
public @interface ObjectTypes {

    public @interface NotNull {}

    public @interface Type
    {
        Class value();
    }

    public @interface Unique
    {
        String uniqueSet() default "defaultSet";
    }
}

package prosecutor.optval.variables;

/**
 * Created by Fry on 08.09.2016.
 */
public @interface StringLenght {
        public int Minimum() default 0;
        public int Maximum();
}

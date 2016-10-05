package prosecutor.optval;


import prosecutor.optval.variables.IntegerTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by Fry on 04.09.2016.
 */
public class Validator {

    public static void validate(Object object) throws ValidationException
    {

    }

    static void validateField(Object object, Field field) throws ValidationException
    {
        if(field.getType() == Boolean.TYPE)
        {

        }
        else if(field.getType() == Integer.TYPE)
        {
            IntegerTypes.validateInt(object,field);
        }
        else if(field.getType() == Long.TYPE)
        {

        }
        else if(field.getType() == Short.TYPE)
        {

        }
        else if(field.getType() == Double.TYPE)
        {

        }
        else if(field.getType() == Float.TYPE)
        {

        }
        else if(field.getType() == String.class)
        {

        }
        else
        {

        }
    }

}

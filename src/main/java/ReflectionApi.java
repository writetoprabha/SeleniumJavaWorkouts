import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* Reflection API is to execute the functions specified in string variables*/
public class ReflectionApi {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "sampleFunction";
        Method method = ReflectionApi.class.getMethod(methodName, String.class);
        method.invoke(method,"Hello");
    }

    //All the methods called using Reflection API must me declared as static
    public static void sampleFunction(String x) {
        System.out.println("inside sample function " + x );
    }
}

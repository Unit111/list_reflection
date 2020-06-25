import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        doStuff("Kur");
        doStuff("Hoi");
    }

    private static void doStuff(final String className) {
        try {
//            Create a class reference
            Class<?> cls = Class.forName(className);
//            Create a reference for a method
            Method method = cls.getMethod("getName");

//            Create a list of elements
            List<Object> list = new ArrayList<>();
            list.add(cls.getConstructor(String.class).newInstance("Pesho"));
            list.add(cls.getConstructor(String.class).newInstance("Gosho"));

            list.forEach(element -> {
                try {
                    System.out.println(method.invoke(element));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

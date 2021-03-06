package tutorial.lib.rxjava;

import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author JiaweiMao on 2017.09.21
 * @since 1.0.0
 */
public class HelloWorld
{
    public static void hello(String... names)
    {
        Observable.fromArray(names).subscribe(s -> System.out.println("Hello " + s + "!"));
    }

    String result = "";

    @Test
    public void returnAValue()
    {
        Observable<String> observable = Observable.just("Hello");

        observable.subscribe(s -> result = s);

        assertTrue(result.equals("Hello"));
    }

}

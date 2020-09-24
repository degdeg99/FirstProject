import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WikiSearchTest {

    @Test
    void WikiSearchTest1(){
        Assertions.assertEquals("Fish",new WikiSearch("Fish"));

    }
    @Test
    void WikiSearchTest2(){
        Assertions.assertEquals("Ball State University",new WikiSearch("Ball State"));
    }
}

import jodd.bean.BeanUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travisnv.jodd.NestedObject;
import org.travisnv.jodd.TargetBean;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JoddTest {

    TargetBean bean;

    @BeforeEach
    void beforeTest() {
        //build object
        var nested = new NestedObject();
        nested.setNestedField("valueFromNested1");
        nested.setNestedPrimitive(1);
        nested.setTasks(List.of("nestedTask1", "nestedTask11"));

        var nested2 = new NestedObject();
        nested2.setNestedField("valueFromNested2");
        nested2.setNestedPrimitive(2);
        nested2.setTasks(List.of("nestedTask2", "nestedTask22"));

        var bean = new TargetBean();
        bean.setName("target_bean_name");
        bean.setTasks(List.of("target_task1", "target_task2"));
        bean.setNestedObjects(List.of(nested, nested2));
        this.bean = bean;
    }

    @Test
    void test() {
        System.out.println("Start test....");
        System.out.println(bean);
        try (var ins = getClass().getResourceAsStream("test1_expression.csv")) {
            var expressions = new String(ins.readAllBytes(), Charset.defaultCharset());
            Arrays.stream(expressions.split(System.lineSeparator()))
                    .map(x -> x.split(","))
                    .forEach(test -> testExpression(test[0], test[1], bean));
        } catch (IOException e) {
            System.out.println("There is error for reading expression file. Please check again.");
            throw new RuntimeException(e);
        }
        System.out.println("Test completed!");
    }

    private void testExpression(String expression, String expected, Object bean) {
        System.out.println("Test bean with expression:`" + expression + "` to have value:`" + expected + "`");
        if (expected.equals("null")) {
            assertTrue(Optional.ofNullable(BeanUtil.pojo.getProperty(bean, expression)).isEmpty());
        } else {
            assertEquals(BeanUtil.pojo.getProperty(bean, expression), expected);
        }
    }
}

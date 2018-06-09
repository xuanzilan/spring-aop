import com.xuanzilan.ssm.spring4.bean.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    private final static Logger logger = Logger.getLogger(StudentTest.class);

    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) ac.getBean("student");
        logger.info(student);
    }
}

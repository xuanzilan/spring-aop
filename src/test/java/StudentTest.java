import com.xuanzilan.ssm.spring4Aop.bean.Student;
import com.xuanzilan.ssm.spring4Aop.service.IStudentService;
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

    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentService");
        System.out.println(student.doOther());
    }

    @Test
    public void test03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentService");
        student.doSome();
    }

    /**
     * 前置通知，这里调用的是代理工厂bean对象，而不是target
     */
    @Test
    public void test04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentServiceProxyFactory");
        student.doSome();
    }

    /**
     * 前置通知，这里调用的是代理工厂bean对象，而不是target
     * 带参数的，试一下
     */
    @Test
    public void test05(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentServiceProxyFactory");
        System.out.println(student.doHello("Jack"));
    }

    /**
     * 使用环绕通知增强doOther方法
     */
    @Test
    public void test06(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentServiceProxyFactory");
        System.out.println(student.doOther());
    }


    /**
     * 使用异常通知处理抛出的异常
     */
    @Test
    public void test07() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentServiceProxyFactory");
        student.doThrow();
    }

    /**
     * 使用advisor
     */
    @Test
    public void test08() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService student = (IStudentService) ac.getBean("studentServiceAdvisorProxyFactory");
        System.out.println("====================================");
        student.doSome();
        System.out.println("====================================");
        student.doOther();
        System.out.println("====================================");
        student.doHello("Bob");
    }
}

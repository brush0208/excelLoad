import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    static public class A{
        static protected int i=1;
    }
    static public class B extends A{
        static protected int i;
        static {
            i=2;
        }
    }
    static public class C extends A{
        static {
            i=3;
        }
    }

    public static void main(String[] args) throws Exception {
       /* Class<TestExcelBean> beanClass = TestExcelBean.class;
        TestExcelBean testExcelBean = beanClass.newInstance();
        Method method = beanClass.getMethod("setName",String.class);
        method.invoke(testExcelBean,"brush");
        System.out.println(testExcelBean.getName());*/
        System.out.println("A"+A.i);
        System.out.println("B"+B.i);
        System.out.println("C"+C.i);
        List<? extends C> list=new ArrayList<>();
        List<A> Alist=new ArrayList<>();
        Alist.add(new B());
    }
}

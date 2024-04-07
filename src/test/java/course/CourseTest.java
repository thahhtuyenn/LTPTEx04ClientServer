package course;

import com.thahhtuyen.dao.CourseDao;
import com.thahhtuyen.dao.DepartmentDao;
import com.thahhtuyen.dao.impl.CourseDaoImpl;
import com.thahhtuyen.dao.impl.DepartmentDaoImpl;
import com.thahhtuyen.entity.Course;
import com.thahhtuyen.entity.Department;
import com.thahhtuyen.entity.OnlineCourse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {
    private CourseDao courseDao;
    private DepartmentDao departmentDao;
    @BeforeEach
    public void setUp(){
        courseDao = new CourseDaoImpl();
        departmentDao = new DepartmentDaoImpl();
    }

    @Test
    public void testAddCourse(){
       Course course = new OnlineCourse();
         course.setTitle("Java Programming");
            course.setCredits(100);
            course.setDepartment(departmentDao.getDepartment(3));
            courseDao.addCourse(course);

    }
}

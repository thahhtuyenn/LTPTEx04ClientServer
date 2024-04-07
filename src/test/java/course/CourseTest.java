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
    public void setUp() {
        courseDao = new CourseDaoImpl();
        departmentDao = new DepartmentDaoImpl();
    }

    @Test
    public void testAddCourse() {
        Course course = new OnlineCourse(
                3,
                "Java Programming",
                "https://www.udemy.com/java-programming"
        );
        course.setDepartment(departmentDao.getDepartment(2));
        courseDao.addCourse(course);

    }

    @Test
    public void testGetCourse() {
        Course course = courseDao.getCourseById(2042);
        System.out.println(course);
    }

    @Test
    public void testUpdateCourse() {
        Course course = courseDao.getCourseById(2);
        course.setTitle("C# Programming");
        course.setDepartment(departmentDao.getDepartment(2));

        courseDao.updateCourse(course);
    }

    @Test
    public void testGetAllCourses() {
        courseDao.getAllCourse().forEach(System.out::println);
    }

    @Test
    public void testDeleteCourse() {
        courseDao.deleteCourseById(4063);
    }
}

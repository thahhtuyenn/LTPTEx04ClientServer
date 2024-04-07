package department;

import com.thahhtuyen.dao.DepartmentDao;
import com.thahhtuyen.dao.impl.DepartmentDaoImpl;
import com.thahhtuyen.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DepartmentTest {
    private DepartmentDao departmentDao;
    @BeforeEach
    public void setUp() {
        departmentDao = new DepartmentDaoImpl();
    }

    @Test
    public void testAddDepartment() {
        Department department = new Department();
        department.setName("IT");
        department.setAdministrator(1);
        department.setBudget(1000000);
        department.setStartDate(LocalDateTime.now());
        System.out.println(departmentDao.addDepartment(department));
    }
}

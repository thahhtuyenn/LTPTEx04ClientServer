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
        department.setBudget(4500000);
        department.setStartDate(LocalDateTime.of(2022, 1, 8, 0, 0, 0));
        System.out.println(departmentDao.addDepartment(department));
    }
    @Test
    public void testUpdateDepartment() {
        Department department = new Department();
        department.setId(1);
        department.setName("IT");
        department.setAdministrator(5);
        department.setBudget(500000);
        department.setStartDate(LocalDateTime.of(2021, 1, 1, 0, 0, 0));
        System.out.println(departmentDao.updateDepartment(department));
    }

    @Test
    public void testDeleteDepartment() {
        System.out.println(departmentDao.deleteDepartment(1));
    }

    @Test
    public void testGetDepartment() {
        System.out.println(departmentDao.getDepartment(2));
    }

    @Test
    public void testGetAllDepartments() {
        departmentDao.getAllDepartments().forEach(System.out::println);
    }
}

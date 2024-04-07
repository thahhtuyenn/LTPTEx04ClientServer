package person;

import com.thahhtuyen.dao.PersonDao;
import com.thahhtuyen.dao.impl.PersonDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private PersonDao personDao;
    @BeforeEach
    public void setUp(){
        personDao = new PersonDaoImpl();
    }


}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Main.class)*/
public class DataJpaTestExmpl {
 /*   @Autowired
    TestEntityManager entityManager;
    @Autowired
    PersonRepository repository;

    @Test
    public void testExmpl(){
        Person person=new Person("12345");
        entityManager.persist(person);
        //repository.save(person);
        Person person1=repository.findByName("12345");
        assertThat(person1.getName()).isEqualTo(person.getName());
    }*/

}

import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class MockitoTest {
    @Mock
    MyDatabase databaseMock;   // #1

    @Rule
    public org.mockito.junit.MockitoRule MockitoRule = MockitoJUnit.rule();  // #2

    @Test
    public void testQuery() {
        ClassToTest t = new ClassToTest(databaseMock);        // #3
        boolean check = t.query("select * from studenti");    // #4
        assertTrue(check);                                    // #5
        verify(databaseMock).query("select * from studenti"); // #6
    }

}
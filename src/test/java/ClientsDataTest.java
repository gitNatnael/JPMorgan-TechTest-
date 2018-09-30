import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by natna on 2018-09-28.
 */
public class ClientsDataTest {
    ClientsData clientData;

    @Before
    public void setup() {
        clientData = new ClientsData();
    }


    @Test
    public void getEntity() throws Exception {
        clientData.setItem("foo");
        assertEquals("foo", clientData.getItem());
    }

    @Test
    public void getInstructionDate() throws Exception {
        clientData.setInstructionDate("2/2/2009");
        assertEquals("2/2/2009", clientData.getInstructionDate());

    }

}
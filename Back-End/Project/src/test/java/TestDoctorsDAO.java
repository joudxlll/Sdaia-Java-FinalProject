import org.example.dao.DoctorsDAO;
import org.example.models.Doctors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestDoctorsDAO {

    @Mock
    private DoctorsDAO doctorsDAO; 

    @InjectMocks
    private Doctors doctors; 

    @BeforeEach
    public void setUp() {
    }


    @Test
    public void testSelectAllDoc() throws SQLException, ClassNotFoundException {
        // Prepare expected test data
        ArrayList<Doctors> expectedDoctors = new ArrayList<>();
        expectedDoctors.add(new Doctors(1, "Dr. Jane Smith", "Pediatrics", "janesmith@example.com", "pass123", 987654321));

        // Stub the behavior of doctorsDAO.selectAllDoc() directly
        when(doctorsDAO.selectAllDoc()).thenReturn(expectedDoctors);

        // Perform the DAO operation
        ArrayList<Doctors> result = doctorsDAO.selectAllDoc();

        // Assertions
        Assertions.assertEquals(expectedDoctors.size(), result.size());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_id(), result.get(0).getDoctor_id());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_name(), result.get(0).getDoctor_name());
        Assertions.assertEquals(expectedDoctors.get(0).getDoctor_specialty(), result.get(0).getDoctor_specialty());

        verify(doctorsDAO, times(1)).selectAllDoc();

    }
}

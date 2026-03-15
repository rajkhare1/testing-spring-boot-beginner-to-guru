package guru.springframework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

public class AnnotationMocksTest {

    @Mock
    Map<String, Object> mapMocks;

    AutoCloseable closeable;

    @Test
    void testMockWithAnnotations() {
        mapMocks.put("keyvalue", "foo");
    }

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}

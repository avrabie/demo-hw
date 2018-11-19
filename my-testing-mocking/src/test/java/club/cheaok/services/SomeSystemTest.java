package club.cheaok.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
public class SomeSystemTest {

    private Service service;
    private SomeSystem system;
    private ServiceListener serviceListener;

    @Before
    public void setupMock() {
        // Mock
        service = Mockito.mock(Service.class);
        serviceListener = Mockito.mock(ServiceListener.class);

        system = Mockito.spy(new SomeSystem());
        system.add(service);
        system.setServiceListener(serviceListener);
    }

    @Test
    public void startSystemTest() {
        PowerMockito.when(service.start()).thenReturn(1);
        system.start();

    }
}
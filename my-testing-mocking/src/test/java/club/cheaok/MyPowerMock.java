package club.cheaok;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class MyPowerMock {

    Iaka iaka = PowerMock.createMock(Iaka.class);

    @Test
    public void name() {
        
    }
}

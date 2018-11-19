package club.cheaok;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
//@PrepareForTest(value = {Iaka.class})
public class MyEasyMock {

    Iaka iaka = EasyMock.mock(Iaka.class);
    @Test
    public void name() {
        EasyMock.expect(iaka.iaka()).andReturn("salut");
        EasyMock.expect(iaka.iaka()).andReturn("hello");
        EasyMock.replay(iaka);
        System.out.println(iaka.iaka());
        Assert.assertEquals("hello", iaka.iaka());
    }


}

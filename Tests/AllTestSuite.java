import UnitTests.*;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersonTest.class,
        VehicleTest.class,
        EcuTest.class,
        FactoryProjectTest.class,
        SimpleEcuTest.class,
        SoftwareTest.class,
        ProjectTest.class})

public class AllTestSuite {
}

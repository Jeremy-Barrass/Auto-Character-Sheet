import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestCharacterSheet.class,
        TestAbilities.class,
        TestCosmeticDetails.class,
        TestSaveProcessor.class,
        TestLoadProcessor.class,
        TestNewProcessor.class,
        TestModelFactory.class,
        TestHttpClientWrapper.class
})

public class ACSTestSuite { }
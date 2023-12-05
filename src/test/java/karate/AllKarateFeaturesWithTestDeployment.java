package karate;

import com.intuit.karate.Results;
import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllKarateFeaturesWithTestDeployment {
    @Test
    public void runAllFeaturesInParallel() {
        Results results = Karate
                .run("./target/test-classes/karate")
                .parallel(8);
        Assertions.assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

}

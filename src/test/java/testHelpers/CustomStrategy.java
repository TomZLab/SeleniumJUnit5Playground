package testHelpers;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

@Slf4j
public class CustomStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {

    private int getTestThreads() {
        String property = System.getProperty("testThreads");
        if (property == null) {
            log.info("\"testThreads\" system property is null, number of threads set to 1.");
            return 1;
        }
        return Integer.parseInt(property);
    }
    @Override
    public int getParallelism() {
        return getTestThreads();
    }

    @Override
    public int getMinimumRunnable() {
        return 0;
    }

    @Override
    public int getMaxPoolSize() {
        return getTestThreads();
    }

    @Override
    public int getCorePoolSize() {
        return getTestThreads();
    }

    @Override
    public int getKeepAliveSeconds() {
        return 60;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(final ConfigurationParameters configurationParameters) {
        return this;
    }
}
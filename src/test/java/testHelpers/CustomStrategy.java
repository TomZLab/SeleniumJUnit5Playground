package testHelpers;

import lombok.extern.slf4j.Slf4j;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

@Slf4j
public class CustomStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {

    private int getTestThreads(boolean logInfo) {
        String property = System.getProperty("testThreads");
        if (property == null) {
            if (logInfo) {
                log.info("\"testThreads\" system property is null, number of threads set to 1.");
            }
            return 1;
        }
        return Integer.parseInt(property);
    }

    @Override
    public int getParallelism() {
        return getTestThreads(true);
    }

    @Override
    public int getMinimumRunnable() {
        return 0;
    }

    @Override
    public int getMaxPoolSize() {
        return getTestThreads(false);
    }

    @Override
    public int getCorePoolSize() {
        return getTestThreads(false);
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
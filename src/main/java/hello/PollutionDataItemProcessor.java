package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by ahmadjawid on 5/21/17.
 */

public class PollutionDataItemProcessor implements ItemProcessor<PollutionData, PollutionData> {

    private static final Logger log = LoggerFactory.getLogger(PollutionDataItemProcessor.class);

    @Override
    public PollutionData process(final PollutionData pollutionData) throws Exception {

        return pollutionData;
    }

}

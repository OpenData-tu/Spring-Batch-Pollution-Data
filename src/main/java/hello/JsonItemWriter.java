package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import hello.controller.JobInvokerController;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ahmadjawid on 5/28/17.
 */
public class JsonItemWriter implements ItemWriter<Schema> {

    @Autowired
    JobInvokerController jobInvokerController;

    @Override
    public void write(List<? extends Schema> list) throws Exception {


        List<PollutionData> pollutionData = (List<PollutionData>) list;

        Gson gson = new Gson();

        String pollutionDataString = gson.toJson(pollutionData);

        jobInvokerController.addToJsonObject(pollutionDataString.substring(1, pollutionDataString.length() - 1));
    }


}

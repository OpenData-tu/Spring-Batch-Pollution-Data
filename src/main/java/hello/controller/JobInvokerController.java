package hello.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ahmadjawid on 5/21/17.
 */
@RestController
public class JobInvokerController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobRegistry jobRegistry;


    private String jsonObject = "";

    public void addToJsonObject(String chunk) {
        jsonObject += chunk;
    }


    private void resetJsonObject(){
        jsonObject = "";
    }


    @RequestMapping("/jobs/pollution/invoke")
    public String invokeJob() throws Exception {

        resetJsonObject();

        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                .toJobParameters();
        Job job = jobRegistry.getJob("pollutionDataJob");
        jobLauncher.run(job, jobParameters);

        return "Batch job has been invoked";
    }


    @RequestMapping("/jobs/pollution/json")
    public String getJsonObject() {
        return jsonObject;
    }

}
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
 
//    @Autowired
//    Job processJob;
//
//    @Autowired
//    JobRepository jobRepository;

    @Autowired
    JobRegistry jobRegistry;


 
    @RequestMapping("/invokejob")
    public String handle() throws Exception {

            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
       Job job = jobRegistry.getJob("importUserJob");
            jobLauncher.run(job, jobParameters);
 
        return "Batch job has been invoked";
    }
}
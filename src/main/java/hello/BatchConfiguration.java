package hello;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


/**
 * Created by ahmadjawid on 5/21/17.
 */

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader reader() throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        FlatFileItemReader reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("data.csv"));

        //TODO the following line functionality should be moved to the user side
        reader.setLinesToSkip(2);

        ClassLoader loader = URLClassLoader.newInstance(
                new URL[]{new URL("file://program.jar")},
                getClass().getClassLoader()
        );
//
       Schema userModelInstance = (Schema) Class.forName("hello.PollutionData", true, loader).newInstance();


      //  lineMapper.setFieldSetMapper((FieldSetMapper<PollutionData>) instance);
       // reader.setLineMapper(lineMapper);


        reader.setLineMapper(new DefaultLineMapper<Schema>() {{
            setLineTokenizer(new DelimitedLineTokenizer(userModelInstance.getDelimiter()) {{
                setNames(userModelInstance.getClassVariableNames());
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Schema>() {{
                setTargetType(userModelInstance.getClass());
            }});
        }});
        return reader;
    }

    @Bean
    public PollutionDataItemProcessor processor() {
        return new PollutionDataItemProcessor();
    }


    @Bean
    public JdbcBatchItemWriter<Schema> writer() {

        JdbcBatchItemWriter<Schema> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO pollution_data (station_code, station_name, daily_mean, measuring_method, first_measuring_date, " +
                "recent_measuring_date, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec) VALUES (:stationCode, " +
                ":stationName, :dailyMean, :measuringMethod, :firstMeasuringDate, " +
                ":recentMeasuringDate, :jan, :feb, :mar, :apr, :may, :jun, :jul, :aug, :sep, :oct, :nov, :dec)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, MalformedURLException {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, MalformedURLException, ClassNotFoundException {
        return stepBuilderFactory.get("step1")
                .<PollutionData, PollutionData>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcess(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return jobRegistryBeanPostProcessor;
    }
    // end::jobstep[]
}

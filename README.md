# Spring-Batch-Pollution-Data

### Build
```sh
$ docker build -t spring-batch-pollution-data .
```
### Run
```sh
$ docker run -p 8080:8080 spring-batch-pollution-data
```
### API
- Invoke 'pollution' job: /jobs/pollution/invoke
- Get the result of 'pollution' job as JSON: /jobs/pollution/invoke


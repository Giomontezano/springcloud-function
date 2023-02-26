<h1>Local Test</h1>

1. Insert data to app:
>curl -X POST localhost:8080/create -H "Content-Type: text/plain" -d dcaf8386-8921-4e9b-bdbb-2f52ef1132f6

(UUID generator: https://www.uuidgenerator.net/version4)

<br>

2. List data from app:
> curl localhost:8080/findAll

---

---

<h2> Uploading app to aws </h2>

1. Generate .jar file to upload to AWS:
> mvn clean package

OBS: Make sure your build the app with Java 11.

(File -> Project Structure -> SDK)

---

---

<h1> Testint app in aws </h1>

1. Get the lambda's url.

Console -> Lambda -> URL da Função


2. Put a data in app, with a post http request:
 >  curl --location --request POST 'https://mhkd3e3rwfjmr7xwythn7qs5je0hnxgs.lambda-url.us-east-1.on.aws/' \
   --header 'spring.cloud.function.definition: create' \
   --header 'Content-Type: text/plain' \
   --data-raw '"0622ddcb-e437-4ef0-a892-9d865ee44f88"'
 
3. List the app data: 
> curl --location --request GET 'https://mhkd3e3rwfjmr7xwythn7qs5je0hnxgs.lambda-url.us-east-1.on.aws/' \
--header 'spring.cloud.function.definition: findAll'

---

---

Lambda -> Código -> Manipulador

Com Api:
>org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest

Com Evento:
>com.example.resiliencia.functions.ResilienciaFunction::findAll

---

---

Tutorials:

https://tanzu.vmware.com/developer/guides/serverless-spring/
https://www.youtube.com/watch?v=gj1DDymw5iY

Oficial Documentation:

https://spring.io/projects/spring-cloud-function

Oficial GitHub:

https://github.com/spring-cloud/spring-cloud-function

SnapStart (Future Use):

https://aws.amazon.com/pt/blogs/compute/reducing-java-cold-starts-on-aws-lambda-functions-with-snapstart/


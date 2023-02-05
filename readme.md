Tutorial:

https://tanzu.vmware.com/developer/guides/serverless-spring/
https://www.youtube.com/watch?v=gj1DDymw5iY

Documentação:

https://spring.io/projects/spring-cloud-function

GitHub oficial:

https://github.com/spring-cloud/spring-cloud-function

SnapStart:

https://aws.amazon.com/pt/blogs/compute/reducing-java-cold-starts-on-aws-lambda-functions-with-snapstart/

---

---

<h1>Testando Local</h1>

1. Inserir dados na aplicação:
>curl -X POST localhost:8080/create -H "Content-Type: text/plain" -d dcaf8386-8921-4e9b-bdbb-2f52ef1132f6

(Caso queria mais UUIDs, gere no site: https://www.uuidgenerator.net/version4)

<br>

2. Listar dados inseridos:
> curl localhost:8080/findAll

---

---

<h2> Subindo app para aws </h2>

1. Gerar .jar para subir na AWS:
> mvn clean package

OBS: Tenha certeza que está buildando o projeto na versão 11 do java.

(File -> Project Structure -> SDK)

---

---

<h1> Testando na aws </h1>

1. Pegue a URL da Lambda.

Console -> Lambda -> URL da Função


2. Insira um registro, via Post:
 >  curl --location --request POST 'https://mhkd3e3rwfjmr7xwythn7qs5je0hnxgs.lambda-url.us-east-1.on.aws/' \
   --header 'spring.cloud.function.definition: create' \
   --header 'Content-Type: text/plain' \
   --data-raw '"0622ddcb-e437-4ef0-a892-9d865ee44f88"'
 
3. Listar Dados inseridos: 
> curl --location --request GET 'https://mhkd3e3rwfjmr7xwythn7qs5je0hnxgs.lambda-url.us-east-1.on.aws/' \
--header 'spring.cloud.function.definition: findAll'



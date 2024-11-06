Api Frankenstein

comandos uteis:

actuator -> mostrar nivel de log
curl http://localhost:8080/actuator/loggers/br.com.qwasolucoes.workshop.githubactions.controller
actuator -> mudar nivel de log
curl -X POST -H "Content-Type: application/json" -d '{"configuredLevel": "DEBUG"}' http://localhost:8080/actuator/loggers/br.com.qwasolucoes.workshop.githubactions.controller
actuator -> mudar nivel de log no Windows
curl -X POST -H "Content-Type: application/json" -d "{\"configuredLevel\": \"DEBUG\"}" http://localhost:8080/actuator/loggers/br.com.qwasolucoes.workshop.githubactions.controller

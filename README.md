Show profile
$ curl http://<clientIP:port>/<client_application_name>/<profile>/label
$ curl http://localhost:8888/config-client-k8s/dev/release
jerry@ubuntu:/opt$ curl http://localhost:8888/config-client-k8s/dev/release
{"name":"config-client-k8s","profiles":["dev"],"label":"release","version":null,"state":null,"propertySources":[{"name":"file:/opt/release/config-client-k8s-dev.properties","source":{"pkslow.age":"999","pkslow.email":"\"jerry@com.tw\"","pkslow.webSite":"\"jerry\""}},{"name":"file:/opt/config-client-k8s-dev.properties","source":{"pkslow.age":"100","pkslow.email":"\"jerry@com.tw\"","pkslow.webSite":"\"jerry\""}}]}j

spring.cloud.coinfig.active=dev
Spring.cloud.config.label=release


Update 
vim /opt/release/config-client-k8s-dev.properties 
$curl -X POST http://localhost:8088/actuator/refresh -d {} -H "Content-Type: application/json"
$ curl http://localhost:8088/pkslow


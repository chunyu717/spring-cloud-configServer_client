# Show server config
$ curl http://<serverIP:port>/<client_application_name>/<profile>/label
$ curl http://localhost:8888/config-client-k8s/dev/release
jerry@ubuntu:/opt$ curl http://localhost:8888/config-client-k8s/dev/release
{"name":"config-client-k8s","profiles":["dev"],"label":"release","version":null,"state":null,"propertySources":[{"name":"file:/opt/release/config-client-k8s-dev.properties","source":{"pkslow.age":"999","pkslow.email":"\"jerry@com.tw\"","pkslow.webSite":"\"jerry\""}},{"name":"file:/opt/config-client-k8s-dev.properties","source":{"pkslow.age":"100","pkslow.email":"\"jerry@com.tw\"","pkslow.webSite":"\"jerry\""}}]}j

spring.cloud.coinfig.active=dev
Spring.cloud.config.label=release

# Config Update 
vim /opt/release/config-client-k8s-dev.properties 
$ curl -X POST http://localhost:8088/actuator/refresh -d {} -H "Content-Type: application/json"
$ curl http://localhost:8088/pkslow


# build image 
$  ~/java/gradle-5.6.3/bin/gradle clean build
~/java/configServer-client$ docker build -t kingbike/config-server-client .
~/java/configServer-server$ docker build -t kingbike/config-server-server .
$ docker images

# run test. (put config file in /home/jerry/configfile
$ docker run --rm -p 8888:8888 -v /home/jerry/configfile:/opt --name config-server kingbike/config-server-server
$ docker run -p 8088:8088 kingbike/config-server-client

# k8s 
jerry@ubuntu:~/java/configServer-server$ curl http://10.152.183.6:8888/config-client-k8s/dev/release


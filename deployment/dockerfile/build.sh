#!/bin/bash
docker build -t cedo:1 cedo/
docker run -idt -v /cedo/webwar:/cedo/tomcat7/webapps -p 80:8080 --name cedowebapp cedo:1 
echo execute the command to start tomcat "docker exec cedowebapp /cedo/tomcat7/bin/startup.sh "
#sleep 5s && docker exec cedowebapp /cedo/tomcat7/bin/shutdown.sh  
#sleep 5s && docker exec cedowebapp /cedo/tomcat7/bin/startup.sh

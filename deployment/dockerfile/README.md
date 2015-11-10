# Say Something
<h3>step</h3>
<ol>
<li>
docker build -t cedo:1 cedo/
</li>
<li>
docker run -idt -v /cedo/webwar:/cedo/tomcat7/webapps -p 80:8080 --name cedowebapp  cedo:1 
</li>
<li>
docker exec cedowebapp /cedo/tomcat7/bin/startup.sh <br />
##docker exec cedowebapp /cedo/tomcat7/bin/shutdown.sh  <br />
##docker exec cedowebapp /cedo/tomcat7/bin/startup.sh  
#首次需要重启一次
</li>
</ol>
#
# my website Dockerfile
# https://github.com/cedooo/dockerfile/cedo
#

# Pull base image.
FROM centos:7

MAINTAINER cedo <cedoo@qq.com>

# Install.
RUN \
  mkdir /cedo && \
  yum update -y && \
  yum install wget -y 
RUN \
  yum install java-1.7.0-openjdk* -y  
RUN \
  cd /cedo && \
  wget http://apache.fayea.com/tomcat/tomcat-7/v7.0.63/bin/apache-tomcat-7.0.63.tar.gz && \ 
  tar -xzf apache-tomcat-7.0.63.tar.gz && \
  mv apache-tomcat-7.0.63 tomcat7 && \ 
  rm -fr apache-tomcat-7.0.63.tar.gz
RUN \
  yum update -y && yum install -y mysql-server mysql mysql-devel 

ADD docker-entrypoint.sh /cedo/entrypoint.sh
ADD server.xml /cedo/tomcat7/conf/server.xml
ADD restartapache.sh /cedo/restartapache.sh

# set enviroment variable
ENV CATALINA_HOME /cedo/tomcat7  
ENV PATH $PATH:$CATALINA_HOME/

# Define mountable directories.
VOLUME ["/cedo/tomcat7/webapps"]

# Define working directory.
WORKDIR /cedo
 
# start shell
#ENTRYPOINT chmod +x /cedo/entrypoint.sh && /cedo/entrypoint.sh && service mysqld start
#ENTRYPOINT ["/cedo/tomcat7/bin/startup.sh"]

# Expose ports. 
EXPOSE 8080

# Define default command.
#CMD ["ping baidu.com"]

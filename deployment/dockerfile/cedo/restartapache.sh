#!/bin/sh
pid=`ps aux | grep tomcat | grep -v grep | grep -v retomcat | awk '{print $2}'`
echo $pid
if [ -n "$pid" ]
then
{
   echo ===========shutdown================
   /cedo/tomcat7/bin/shutdown.sh
   sleep 2
   pid=`ps aux | grep tomcat | grep -v grep | grep -v retomcat | awk '{print $2}'`
   if [ -n "$pid" ]
   then
    {
      sleep 2
      echo ========kill tomcat begin==============
      echo $pid
      kill -9 $pid
      echo ========kill tomcat end==============
    }
   fi
   sleep 2
   echo ===========startup.sh==============
   /cedo/tomcat7/bin/startup.sh
}
else
echo ===========startup.sh==============
	/cedo/tomcat7/bin/startup.sh
fi

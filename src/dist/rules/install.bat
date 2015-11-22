@echo off

set LIB_DIR=%~dp0..\lib
set SUBMIT_JAR=%LIB_DIR%\byteman-submit-3.0.2.jar
set MAIN_CLASS=org.jboss.byteman.agent.submit.Submit

java -classpath %SUBMIT_JAR% %MAIN_CLASS% -l %*


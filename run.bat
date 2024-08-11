@echo off
@title かえでサーバー JMS v327.0
set CLASSPATH=.;dist\*
java -server -Dnet.sf.odinms.wzpath=wz\ server.Start
pause
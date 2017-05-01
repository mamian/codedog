process=`ps -ef | grep spring-boot:run | grep "codedog"`
pid=`echo $process | cut -d ' ' -f 2`
echo pid = $pid

if  [ ! -n "$pid" ] ;then
    echo "codedog未启动，不用kill"
else
    kill -9 $pid
    echo "kill codedog"
fi


nohup mvn spring-boot:run &





$server = "xsample.xreflect.xserver"
$libs = "xap.libs"

cd xlang
mvn install
cd ../

cd xrmi
mvn install
cd ../

cd xutil
mvn install
cd ../

cd xscript
mvn install
cd ../

cd xwt
mvn install
cd ../

cd xface
mvn install
cd ../

cd xap
mvn install
cd ../



cd xlang.impl
mvn install
cd ../

cd xrmi.impl
mvn install
cd ../

cd xutil.impl
mvn install
cd ../

cd xscript.impl
mvn install
cd ../

cd xlang.xrmi.impl
mvn install
cd ../

cd xscript.xrmi.impl
mvn install
cd ../


cp xutil\target\*.jar $libs\ -recurse -force
cp xap\target\*.jar $libs\ -recurse -force
cp xlang\target\*.jar $libs\ -recurse -force
cp xrmi\target\*.jar $libs\ -recurse -force
cp xrmi.impl\target\*.jar $libs\ -recurse -force
cp xscript\target\*.jar $libs\ -recurse -force

cd xsample.xreflect.xserver
mvn install
cd ../

cp xlang\target\classes\* $server\target\classes\ -recurse -force
cp xlang\target\*.jar $server\target\ -recurse -force

cp xrmi\target\classes\* $server\target\classes\ -recurse -force
cp xrmi\target\*.jar $server\target\ -recurse -force

cp xscript\target\classes\* $server\target\classes\ -recurse -force
cp xscript\target\*.jar $server\target\ -recurse -force

cp xutil\target\classes\* $server\target\classes\ -recurse -force
cp xutil\target\*.jar $server\target\ -recurse -force


cd $server\target\classes
rmiregistry
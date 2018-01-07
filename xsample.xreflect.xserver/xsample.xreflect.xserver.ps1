cp ..\xlang\target\classes\* .\target\classes\ -recurse -force
cp ..\xlang\target\*.jar .\target\ -recurse -force

cp ..\xrmi\target\classes\* .\target\classes\ -recurse -force
cp ..\xrmi\target\*.jar .\target\ -recurse -force

cp ..\xscript\target\classes\* .\target\classes\ -recurse -force
cp ..\xscript\target\*.jar .\target\ -recurse -force

cp ..\xutil\target\classes\* .\target\classes\ -recurse -force
cp ..\xutil\target\*.jar .\target\ -recurse -force

cd target\classes
rmiregistry
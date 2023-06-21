#!/usr/bin/bash
rm -rf ./target
javac -encoding utf-8 -d ./target ./can/* -cp "lib/;resources/icon.png"
cp -r lib ./target/lib
mkdir ./target/resources
cp resources/icon.png ./target/resources/icon.png
cp resources/Manifest.txt target/Manifest.txt
pushd ./target
jar cfm ./application.jar ./Manifest.txt ./can/* ./resources/*
popd
launch4jc ./resources/execonfig.xml
rm -f ./CAN-CRC.exe
mv ./target/CAN-CRC.exe .
# rm -rf ./target
exec ./CAN-CRC.exe
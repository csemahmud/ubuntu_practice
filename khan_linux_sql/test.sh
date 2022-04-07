#!/bin/sh

# Author : KHAN MAHMUDUL HASAN CSE
# Script follows here:


echo "Enter First Number : "
read NUM_1
echo "First Number is : $NUM_1"
echo "Enter Second Number : "
read NUM_2
echo "Second Number is : $NUM_2"
MULTIPLY_RESULT=`expr $NUM_1 \* $NUM_2`
echo "Multiplication of two numbers is : $MULTIPLY_RESULT"

echo "Enter Name : "
read NAME
readonly INFORMATION="information"
if [ "${NAME}" = "${INFORMATION}" ]
then
   echo "success"
else
   echo "failed"
fi

a=1

until [ ! $a -lt 11 ]
do
   echo $a
   a=`expr $a + 1`
done

sudo tty
sudo touch data.csv
sudo ls -l data.csv
sudo chmod 777 data.csv
sudo ls -l data.csv
sudo nano data.csv
sudo cat data.csv
sudo tail data.csv
sudo gzip -v data.csv
sudo ls -l data.csv.gz
sudo gunzip -v data.csv.gz
sudo ls -l data.csv
sudo rm data.csv











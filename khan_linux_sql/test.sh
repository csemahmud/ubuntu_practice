#!/bin/sh

# Author : KHAN MAHMUDUL HASAN CSE
# Script follows here:


sudo echo "Enter First Number : "
read NUM_1
sudo echo "First Number is : $NUM_1"
sudo echo "Enter Second Number : "
read NUM_2
sudo echo "Second Number is : $NUM_2"
RESULT=`expr $NUM_1 + $NUM_2`
sudo echo "Addition of two numbers is : $RESULT"
RESULT=`expr $NUM_1 - $NUM_2`
sudo echo "Subtraction of two numbers is : $RESULT"
RESULT=`expr $NUM_1 \* $NUM_2`
sudo echo "Multiplication of two numbers is : $RESULT"
RESULT=`expr $NUM_1 / $NUM_2`
sudo echo "Division of two numbers is : $RESULT"

sudo echo "Enter Name : "
read NAME
readonly INFORMATION="information"
if [ "${NAME}" = "${INFORMATION}" ]
then
   sudo echo "success"
else
   sudo echo "failed"
fi


sudo echo "Enter a value for a : "
read a
sudo echo "Enter a value for b : "
read b

if [ $a = $b ]
then
   sudo echo "a is equal to b"
elif [ $a -gt $b ]
then
   sudo echo "a is greater than b"
elif [ $a -lt $b ]
then
   sudo echo "a is less than b"
else
   sudo echo "None of the condition met"
fi


for var in 1 2 3 4 5 6 7 8 9 10
do
   sudo echo $var
done

for FILE in $HOME/.bash*
do
   sudo echo $FILE
done

a=1

while [ $a -lt 11 ]
do
   sudo echo $a
   a=`expr $a + 2`
done

a=0

until [ ! $a -lt 11 ]
do
   sudo echo $a
   a=`expr $a + 2`
done

a=0
while [ "$a" -lt 10 ]    # this is loop1
do
   b="$a"
   while [ "$b" -ge 0 ]  # this is loop2
   do
      sudo echo -n "$b "
      b=`expr $b - 1`
   done
   sudo echo
   a=`expr $a + 1`
done


a=0

while [ $a -lt 10 ]
do
   sudo echo $a
   if [ $a -eq 5 ]
   then
      break
   fi
   a=`expr $a + 1`
done


for var1 in 1 2 3
do
   for var2 in 0 5
   do
      if [ $var1 -eq 2 -a $var2 -eq 0 ]
      then
         break 2
      else
         sudo echo "$var1 $var2"
      fi
   done
done


NUMS="1 2 3 4 5 6 7"

for NUM in $NUMS
do
   Q=`expr $NUM % 2`
   if [ $Q -eq 0 ]
   then
      sudo echo "Number is an even number!!"
      continue
   fi
   sudo echo "Found odd number"
done


sudo tty
sudo pwd
sudo echo "Process ID number, or PID, of the current shell is : $$"
sudo echo "File Name: $0"
sudo echo "First Parameter : $1"
sudo echo "Second Parameter : $2"
sudo echo "Quoted Values: $@"
sudo echo "Quoted Values: $*"
sudo echo "Total Number of Parameters : $#"
for TOKEN in $*
do
   sudo echo $TOKEN
done
sudo date
sudo cal
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



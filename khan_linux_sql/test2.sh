DATE=`date`
echo "Date is $DATE"

USERS=`who | wc -l`
sudo echo "Logged in user are $USERS"

UP=`date ; uptime`
sudo echo "Uptime is $UP"

sudo echo ${var:-"Variable is not set"}
sudo echo "1 - Value of var is ${var}"

sudo echo ${var:="Variable is not set"}
sudo echo "2 - Value of var is ${var}" 

unset var
sudo echo ${var:+"This is default value"}
sudo echo "3 - Value of var is $var"

var="Prefix"
sudo echo ${var:+"This is default value"}
sudo echo "4 - Value of var is $var"

sudo echo ${var:?"Print this message"} 
sudo echo "5 - Value of var is ${var}"

sudo echo Hello\; Word
sudo echo "I have \$1200"

sudo echo \<-\$1500.\*\*\>\; \(update\?\) \[y\|n\]
sudo echo '<-$1500.**>; (update?) [y|n]'
sudo echo 'It\'s Shell Programming
sudo echo 'It\'s Shell Programming''

VAR=KHAN
sudo echo '$VAR owes <-$1500.**>; [ as of (`date +%m/%d`) ]'
VAR=KHAN
echo "$VAR owes <-\$1500.**>; [ as of (`date +%m/%d`) ]"

DATE=`date`
sudo echo "Current Date: $DATE"

who > users
sudo cat users
echo line 1 > users
sudo cat users
sudo wc -l users
users
command << delimiter
document
delimiter


sudo wc -l << EOF
   This is a simple lookup program 
	for good (and bad) restaurants
	in Cape Town.
EOF

sudo cat << EOF
This is a simple lookup program 
for good (and bad) restaurants
in Cape Town.
EOF


filename=test.txt
sudo vi $filename <<EndOfCommands
i
This file was created automatically from
a shell script
^[
ZZ
EndOfCommands


sudo cat test.txt
sudo rm users
sudo rm '*test.txt*'
sudo rm .test.txt.swp

command > /dev/null
command > /dev/null 2>&1
sudo echo message 1>&2


# Define your function here
Hello () {
   sudo echo "Hello World"
}

# Invoke your function
Hello

# Define your function here
Hello () {
   sudo echo "Hello World $1 $2"
}

# Invoke your function
Hello Khan Mahmud

# Define your function here
Hello () {
   sudo echo "Hello World $1 $2"
   return 10
}

# Invoke your function
Hello Khan Mahmud

# Capture value returnd by last command
ret=$?

sudo echo "Return value is $ret"


# Calling one function from another
number_one () {
   sudo echo "This is the first function speaking..."
   number_two
}

number_two () {
   sudo echo "This is now the second function speaking..."
}

# Calling function one.
number_one

unset -f number_one
number_one

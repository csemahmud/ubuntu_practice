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
echo '$VAR owes <-$1500.**>; [ as of (`date +%m/%d`) ]'
VAR=KHAN
echo "$VAR owes <-\$1500.**>; [ as of (`date +%m/%d`) ]"

DATE=`date`
echo "Current Date: $DATE"

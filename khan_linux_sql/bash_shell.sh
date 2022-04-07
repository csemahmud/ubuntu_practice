NAME[0]="Khan"
NAME[1]="Mahmudul"
NAME[2]="Hasan"
NAME[3]="Ayan"
NAME[4]="Daisy"
sudo echo "First Index: ${NAME[0]}"
sudo echo "Second Index: ${NAME[1]}"
${array_name[*]}
${array_name[@]}


select DRINK in tea cofee water juice appe all none
do
   case $DRINK in
      tea|cofee|water|all) 
         echo "Go to canteen"
         ;;
      juice|appe)
         echo "Available at home"
      ;;
      none) 
         break 
      ;;
      *) echo "ERROR: Invalid selection" 
      ;;
   esac
done

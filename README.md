####Assumptions####
- correct numeric argument will always be provided when running program, no argument validation
- start and end time for each satellite are in the same day
- each line in provided file contains correct data, correct data types, no data validation in program
- if there are two or more periods that have the highest total downlink, first one found is taken
- file pass-schedule.txt is based in the folder ./src/resources/

###Run the program###
- open command line navigate to project root and run following commands: 
mvnw package
java -jar ./target/space-exercise-1.0-SNAPSHOT.jar 60

where 60 is the argument representing the bandwidth of the ground station
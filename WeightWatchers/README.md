# GurdeepWeightWatchers

#### How to run ####
IMPORTANT: I've deployed the code so that it runs with single command using Maven.
So, you need to have mvn, mvn2 or mvn3 in your path, i.e., assuming you've installed Maven 3, you should be able
to run mvn3 in terminal or command prompt.

All 3 questions are under src/main/java/ directory
I've created a package arora.gurdeep.weightwatchers, so the code is in src/main/java/arora/gurdeep/weightwatchers directory

#### Question 1 ####
This questions asks me to parse the input file and print key value pairs.

To run this, type:

mvn3 -e exec:java -Dexec.mainClass=arora.gurdeep.weightwatchers.Question1 -Dexec.args="data/sample.txt"
This runs Question 1 and passes "sample.txt" as the input. You may also pass data/bad.txt for file with some badly
formatted lines.


#### Question 3 ####
This questions asks find 500 random numbers and print the "n"th.

To run this, type:

mvn3 -e exec:java -Dexec.mainClass=arora.gurdeep.weightwatchers.Question3 -Dexec.args="3"
This will print all 500 random numbers and print the 3rd.
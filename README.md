# HothFamilyTree

This README file explains how to use HothFamilyTree application. This file also specifies minimum system requirements needed to run the application.
<hr>

Project Description:

The story is set on the planet Hoth. King Shan and Queen Anga and their family are the protagonists. This application solves problem 1 of the challenge.<br>
Problem: Model out the Shan family tree so that when given a ‘name’ and a ‘relationship’ as an input, the output are the people that correspond to the relationship.

<hr>

System Requirements:
    <ul>
        <li>System must have Java8 or higher version.</li>
        <li>Maven pom.xml contains source and target JDK 1.8 </li>
        <li>System must comply minimum requirements specified for JVM.</li>
    </ul>
    
<hr>

Libraries included:
    <ul>
        <li>Junit-4.13-beta-3.jar: This is used for unit testing of the application. All Unit tests are written in /src/test/java/hoth/utility/RelationshipUtilityTest.java.</li>
    </ul>
    
<hr>

Running in an IDE:

If you want to run the application in an IDE, such as Intellij IDEA, you should be able to import the entire project into the IDE. Alternatively,
you can copy entire source files into existing java maven project, add dependencies into maven pom.xml and then use /src/main/java/hoth/main/FamilyTree.java to run application.

<hr>

Run using JAR file:

The HothFamilyTree.jar file is in /out/artifacts/HothFamilyTree_jar directory. Use following command to execute the jar:<br>
<i>java -jar HothFamilyTree.jar</i>

Remember to have the Java version above 8 or higher.

<hr>

Execution instructions:

When you execute the application, following prompt occurs: <br>
<i>This program implemented Problem1. Please enter the correct name and relation.<br>
Sample Input=> Person = Ish; Relation = Brothers<br>
Sample Input=> Person = Chit; Relation = sisterinlaws<br>
Sample Input=> Person = Drita; Relation = paternaluncles<br>
Sample Input=> Person = Drita; Relation = maternalaunts<br>
Type 'exit' to quit the program.</i>

Provide your sample input as shown above with correct name and relation:<br>
<i>Person = Ish; Relation = Brothers</i>

Person name is case-sensitive and relation value is case-insensitive. However, remember there is no space between relation value. 
For example, the correct spelling (can be uppercase or lowercase) for the relation is provided as follows 'sisterinlaws', 'paternaluncles', 'maternalaunts', 'Granddaughter', and so on.

Application will continue to prompt for inputs and will show results.<br>
Type 'exit' to terminate the program.
<hr>

Following relationships are maintained in the application:

[FATHER, MOTHER, BROTHER, SISTER, SON, DAUGHTER, CHILDREN, COUSIN, GRANDMOTHER, GRANDFATHER, GRANDSON, GRANDDAUGHTER, PATERNALAUNT, PATERNALUNCLE, MATERNALAUNT, MATERNALUNCLE, SISTERINLAW, BROTHERINLAW, HUSBAND, WIFE]

<hr>

Assumptions:
    <ul>
        <li>All Persons would have unique name in the tree.</li>
        <li>Members can be added in a top-down approach meaning immediate members can be added in family tree.</li>
    </ul>

<hr>

Structure of the application:

The code is presented in the following directory: <br>
/src/main/java/hoth<br>
├───exception<br>
│       InvalidArgumentException.java<br>
│<br>
├───main<br>
│       FamilyTree.java<br>
│<br>
├───person<br>
│       Person.java<br>
│<br>
├───relation<br>
│       Relationship.java<br>
│<br>
└───utility<br>
        RelationshipConstants.java<br>
        RelationshipUtility.java






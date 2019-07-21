package hoth.main;

import hoth.exception.InvalidArgumentException;
import hoth.person.Person;
import hoth.utility.RelationshipConstants;
import hoth.utility.RelationshipUtility;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Contains main method for the Shan family tree creation and program for problem1 where,
 * given a ‘name’ and a ‘relationship’ as an input, the output are the people that correspond to the relationship.
 *
 * @author Vedant
 */
public class FamilyTree {

    public static void main(String args[]) throws InvalidArgumentException {
        RelationshipUtility hothTree = new RelationshipUtility();

        //Creating the Shan family tree
        hothTree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
        hothTree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
        hothTree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
        hothTree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
        hothTree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
        hothTree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
        hothTree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
        hothTree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
        hothTree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
        hothTree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
        hothTree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
        hothTree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

        Scanner sc = new Scanner(System.in);

        System.out.println("This program implemented Problem1. Please enter the correct name and relation.");
        System.out.println("Sample Input=> Person = Ish; Relation = Brothers");
        System.out.println("Sample Input=> Person = Chit; Relation = sisterinlaws");
        System.out.println("Sample Input=> Person = Drita; Relation = paternaluncles");
        System.out.println("Sample Input=> Person = Drita; Relation = maternalaunts");
        System.out.println("Type 'exit' to quit the program.");

        while(sc.hasNextLine()){
            try{
                //Taking the input
                String inputString = sc.nextLine();
                if (!inputString.isEmpty()) {
                    //Splitting the input based on '; '
                    String[] input = inputString.split("; ");
                    //Type 'exit' program terminates
                    if (input[0].equals("exit")) {
                        sc.close();
                        System.exit(0);
                    }
                    //If the input contains 'Person' and 'Relation' then do following
                    if (input[0].contains("Person") && input[1].contains("Relation")) {
                        String[] person = input[0].split(" = ");
                        String[] relation = input[1].split(" = ");
                        //Getting the person name
                        String name = person[1];
                        String value = relation[1].toUpperCase();
                        if (value.charAt(value.length() - 1) == 'S') {
                            value = value.substring(0, value.length() - 1);
                        }

                        //Getting the relation
                        RelationshipConstants.RELATIONSHIPS relationshipType = RelationshipConstants.RELATIONSHIPS.valueOf(value);
                        //Switch case for fetching different relationships
                        switch (relationshipType) {

                            case FATHER:
                                Optional<Person> father = Optional.ofNullable(hothTree.getFather(name));
                                if (father.isPresent()) {
                                    System.out.println(hothTree.getFather(name).getName());
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case MOTHER:
                                Optional<Person> mother = Optional.ofNullable(hothTree.getMother(name));
                                if (mother.isPresent()) {
                                    System.out.println(hothTree.getMother(name).getName());
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case CHILDREN:
                                Optional<List<Person>> children = Optional.ofNullable(hothTree.getChildren(name));
                                if(children.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getChildren(name).stream().map(Person::getName)
                                            .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case SON:
                                Optional<List<Person>> son = Optional.ofNullable(hothTree.getSons(name));
                                if(son.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getSons(name).stream().map(Person::getName)
                                            .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case DAUGHTER:
                                Optional<List<Person>> daughter = Optional.ofNullable(hothTree.getDaughters(name));
                                if(daughter.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getDaughters(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case BROTHER:
                                Optional<List<Person>> brother = Optional.ofNullable(hothTree.getBrothers(name));
                                if(brother.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getBrothers(name).stream()
                                            .map(Person::getName).collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case SISTER:
                                Optional<List<Person>> sister = Optional.ofNullable(hothTree.getSisters(name));
                                if(sister.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getSisters(name).stream().map(Person::getName)
                                            .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case COUSIN:
                                Optional<List<Person>> cousin = Optional.ofNullable(hothTree.getCousins(name));
                                if(cousin.map(List::size).orElse(0) != 0) {
                                System.out.println(hothTree.getCousins(name).stream().map(Person::getName)
                                        .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case PATERNALAUNT:
                            case MATERNALAUNT:
                                Optional<List<Person>> aunt = Optional.ofNullable(hothTree.getAunts(name, value));
                                if(aunt.map(List::size).orElse(0) != 0) {
                                    System.out.println(hothTree.getAunts(name, value).stream().map(Person::getName)
                                            .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case PATERNALUNCLE:
                            case MATERNALUNCLE:
                                Optional<List<Person>> uncle = Optional.ofNullable(hothTree.getUncles(name, value));
                                if(uncle.map(List::size).orElse(0) != 0) {
                                System.out.println(hothTree.getUncles(name, value).stream().map(Person::getName)
                                        .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case SISTERINLAW:
                            case BROTHERINLAW:
                                Optional<List<Person>> inLaw = Optional.ofNullable(hothTree.getInlaws(name, value));
                                if(inLaw.map(List::size).orElse(0) != 0) {
                                System.out.println(hothTree.getInlaws(name, value).stream().map(Person::getName)
                                        .collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case GRANDMOTHER:
                                Optional<Person> grandMother = Optional.ofNullable(hothTree.getGrandMother(name));
                                if (grandMother.isPresent()) {
                                    System.out.println(hothTree.getGrandMother(name).getName());
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case GRANDFATHER:
                                Optional<Person> grandFather = Optional.ofNullable(hothTree.getGrandFather(name));
                                if (grandFather.isPresent()) {
                                    System.out.println(hothTree.getGrandFather(name).getName());
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case GRANDSON:
                                Optional<List<Person>> grandSon = Optional.ofNullable(hothTree.getGrandSons(name));
                                if(grandSon.map(List::size).orElse(0) != 0) {
                                System.out.println(hothTree.getGrandSons(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            case GRANDDAUGHTER:
                                Optional<List<Person>> grandDaughter = Optional.ofNullable(hothTree.getGrandDaughters(name));
                                if(grandDaughter.map(List::size).orElse(0) != 0) {
                                System.out.println(hothTree.getGrandDaughters(name).stream()
                                        .map(Person::getName).collect(Collectors.joining(", ")));
                                }else{
                                    System.out.println("No relation found");
                                }
                                break;
                            default:
                                System.out.println("No relation found");
                        }
                    } else{
                        throw new InvalidArgumentException("Invalid Input!! Please enter the input again similar to the sample string.");
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

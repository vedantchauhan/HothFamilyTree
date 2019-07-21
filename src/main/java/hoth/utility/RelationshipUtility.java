package hoth.utility;

import hoth.exception.InvalidArgumentException;
import hoth.person.Person;
import hoth.relation.Relationship;

import java.util.*;

/**
 * Utility class containing all the important functions for tracking the relationships.
 *
 * @author Vedant
 */
public class RelationshipUtility {

    private Person rootPerson;
    private Map<String, Boolean> visitedPersons = new HashMap();

    /**
     * Associating gender based on the relationship
     * @param type
     * @return
     */
    private RelationshipConstants.GENDER genderRelation(RelationshipConstants.RELATIONSHIPS type) {
        if (RelationshipConstants.RELATIONSHIPS.MOTHER.equals(type) || RelationshipConstants.RELATIONSHIPS.DAUGHTER.equals(type) || RelationshipConstants.RELATIONSHIPS.WIFE.equals(type))
            return RelationshipConstants.GENDER.FEMALE;
        else
            return RelationshipConstants.GENDER.MALE;
    }

    /**
     * Associating family relation types: SPOUSE, PARENT, CHILD
     * @param type
     * @return
     */
    private RelationshipConstants.FAMILYRELATIONTYPE familyRelation(RelationshipConstants.RELATIONSHIPS type) {
        if (RelationshipConstants.RELATIONSHIPS.MOTHER.equals(type) || RelationshipConstants.RELATIONSHIPS.FATHER.equals(type))
            return RelationshipConstants.FAMILYRELATIONTYPE.CHILD;
        else if (RelationshipConstants.RELATIONSHIPS.HUSBAND.equals(type) || RelationshipConstants.RELATIONSHIPS.WIFE.equals(type))
            return RelationshipConstants.FAMILYRELATIONTYPE.SPOUSE;
        else
            return RelationshipConstants.FAMILYRELATIONTYPE.PARENT;
    }

    /**
     * Adds the person in the family tree
     * @param name1
     * @param relationship1
     * @param name2
     * @param relationship2
     * @throws InvalidArgumentException
     */
    public void addPerson(String name1, RelationshipConstants.RELATIONSHIPS relationship1, String name2, RelationshipConstants.RELATIONSHIPS relationship2)
            throws InvalidArgumentException {
        RelationshipConstants.FAMILYRELATIONTYPE familyRelation1 = familyRelation(relationship1);
        RelationshipConstants.FAMILYRELATIONTYPE familyRelation2 = familyRelation(relationship2);
        RelationshipConstants.GENDER gender1 = genderRelation(relationship1);
        RelationshipConstants.GENDER gender2 = genderRelation(relationship2);
        if (this.rootPerson == null) {
            Person person1 = new Person(name1, gender1);
            Person person2 = new Person(name2, gender2);
            this.rootPerson = person1;
            addFamilyRelation(familyRelation1, person1, familyRelation2, person2);
        } else {
            Person person1 = searchPerson(this.rootPerson, name1);
            if (person1 == null) {
                throw new InvalidArgumentException("Invalid argument");
            }
            Person person2 = new Person(name2, gender2);
            addFamilyRelation(familyRelation1, person1, familyRelation2, person2);
            if (RelationshipConstants.FAMILYRELATIONTYPE.CHILD.equals(familyRelation1)) {
                for (Relationship relation : person1.getRelations()) {
                    if (RelationshipConstants.FAMILYRELATIONTYPE.SPOUSE.equals(relation.getFamilyRelationType())) {
                        person1 = relation.getSecondPerson();
                        break;
                    }

                }
                addFamilyRelation(familyRelation1, person1, familyRelation2, person2);
            }

        }

    }

    /**
     * Finds and returns the person in the family tree
     * @param person
     * @param name
     * @return
     */
    private Person searchPerson(Person person, String name) {
        this.visitedPersons.put(person.getName(), Boolean.TRUE);
        if (person.getName().equals(name)) {
            this.visitedPersons.clear();
            return person;
        } else {
            for (Relationship relation : person.getRelations()) {
                Person person2 = relation.getSecondPerson();
                if (!visitedPersons.containsKey(person2.getName())) {
                    Person updatedPerson = searchPerson(person2, name);
                    if (updatedPerson != null) {
                        return updatedPerson;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Associates the relationship with the correponding persons
     * @param type1
     * @param person1
     * @param type2
     * @param person2
     */
    private void addFamilyRelation(RelationshipConstants.FAMILYRELATIONTYPE type1, Person person1, RelationshipConstants.FAMILYRELATIONTYPE type2, Person person2) {
        Relationship relation1 = new Relationship(type1, person1, person2);
        person1.addRelation(relation1);
        Relationship relation2 = new Relationship(type2, person2, person1);
        person2.addRelation(relation2);
    }

    /**
     * Fetches the children of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getChildren(String name) throws InvalidArgumentException {
        List<Person> children = new ArrayList();
        Person person = searchPerson(this.rootPerson, name);
        if (person == null) {
            throw new InvalidArgumentException("Invalid argument");
        }
        for (Relationship relation : person.getRelations()) {
            if (RelationshipConstants.FAMILYRELATIONTYPE.CHILD.equals(relation.getFamilyRelationType())) {
                children.add(relation.getSecondPerson());
            }
        }
        return children;
    }

    /**
     * Fetches the parents of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    private List<Person> getParents(String name) throws InvalidArgumentException {
        List<Person> parents = new ArrayList();
        Person person = searchPerson(this.rootPerson, name);
        if (person == null) {
            throw new InvalidArgumentException("Invalid argument");
        }
        for (Relationship relation : person.getRelations()) {
            if (RelationshipConstants.FAMILYRELATIONTYPE.PARENT.equals(relation.getFamilyRelationType())) {
                parents.add(relation.getSecondPerson());

            }
        }
        return parents;
    }

    /**
     * Fetches the father of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public Person getFather(String name) throws InvalidArgumentException {
        Person father = null;
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            if (RelationshipConstants.GENDER.MALE.equals(person.getGender()))
                father = person;
        }
        return father;
    }

    /**
     * Fetches the mother of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public Person getMother(String name) throws InvalidArgumentException {
        Person mother = null;
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            if (RelationshipConstants.GENDER.FEMALE.equals(person.getGender()))
                mother = person;
        }
        return mother;
    }

    /**
     * Fetches the siblings of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    private List<Person> getSiblings(String name) throws InvalidArgumentException {
        List<Person> siblings = new ArrayList();
        Person father = getFather(name);
        if (father != null) {
            List<Person> children = getChildren(father.getName());
            for (Person person : children) {
                if (!person.getName().equals(name)) {
                    siblings.add(person);
                }
            }
        }
        return siblings;
    }

    /**
     * Fetches the brothers of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getBrothers(String name) throws InvalidArgumentException {
        List<Person> brothers = new ArrayList();
        List<Person> siblings = getSiblings(name);
        for (Person person : siblings) {
            if (RelationshipConstants.GENDER.MALE.equals(person.getGender())) {
                brothers.add(person);
            }
        }
        return brothers;
    }

    /**
     * Fetches the sisters of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getSisters(String name) throws InvalidArgumentException {
        List<Person> sisters = new ArrayList();
        List<Person> siblings = getSiblings(name);
        for (Person person : siblings) {
            if (RelationshipConstants.GENDER.FEMALE.equals(person.getGender())) {
                sisters.add(person);
            }
        }
        return sisters;
    }

    /**
     * Fetches the sons of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getSons(String name) throws InvalidArgumentException {
        List<Person> sons = new ArrayList();
        List<Person> children = getChildren(name);
        for (Person person : children) {
            if (RelationshipConstants.GENDER.MALE.equals(person.getGender())) {
                sons.add(person);
            }
        }
        return sons;
    }

    /**
     * Fetches the daughters of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getDaughters(String name) throws InvalidArgumentException {
        List<Person> daughters = new ArrayList();
        List<Person> children = getChildren(name);
        for (Person person : children) {
            if (RelationshipConstants.GENDER.FEMALE.equals(person.getGender())) {
                daughters.add(person);
            }
        }
        return daughters;
    }

    /**
     * Fetches the cousins of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getCousins(String name) throws InvalidArgumentException {
        List<Person> cousins = new ArrayList();
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            List<Person> siblings = getSiblings(person.getName());
            for (Person sibling : siblings) {
                List<Person> children = getChildren(sibling.getName());
                cousins.addAll(children);
            }
        }
        return cousins;
    }

    /**
     * Fetches the grandparents of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    private List<Person> getGrandParents(String name) throws InvalidArgumentException {
        List<Person> grandParents = new ArrayList();
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            grandParents.addAll(getParents(person.getName()));
        }
        return grandParents;
    }

    /**
     * Fetches the grandmother of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public Person getGrandMother(String name) throws InvalidArgumentException {
        Person grandMother = null;
        List<Person> grandParents = getGrandParents(name);
        for (Person person : grandParents) {
            if (RelationshipConstants.GENDER.FEMALE.equals(person.getGender())) {
                grandMother = person;
            }
        }
        return grandMother;
    }

    /**
     * Fetches the grandfather of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public Person getGrandFather(String name) throws InvalidArgumentException {
        Person grandFather = null;
        List<Person> grandParents = getGrandParents(name);
        for (Person person : grandParents) {
            if (RelationshipConstants.GENDER.MALE.equals(person.getGender())) {
                grandFather = person;
            }
        }
        return grandFather;
    }

    /**
     * Fetches the grandchildren of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    private List<Person> getGrandChildren(String name) throws InvalidArgumentException {
        List<Person> children = getChildren(name);
        List<Person> grandChildren = new ArrayList();
        for (Person person : children) {
            grandChildren.addAll(getChildren(person.getName()));
        }

        return grandChildren;
    }

    /**
     * Fetches the grandsons of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getGrandSons(String name) throws InvalidArgumentException {
        List<Person> grandSons = new ArrayList();
        List<Person> grandChildren = getGrandChildren(name);
        for (Person person : grandChildren) {
            if (RelationshipConstants.GENDER.MALE.equals(person.getGender())) {
                grandSons.add(person);
            }
        }

        return grandSons;
    }

    /**
     * Fetches the granddaughters of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getGrandDaughters(String name) throws InvalidArgumentException {
        List<Person> grandDaughters = new ArrayList();
        List<Person> grandChildren = getGrandChildren(name);
        for (Person person : grandChildren) {
            if (RelationshipConstants.GENDER.FEMALE.equals(person.getGender())) {
                grandDaughters.add(person);
            }
        }
        return grandDaughters;
    }

    /**
     * Fetches the aunts(both paternal and maternal) of a particular name from the family tree
     * @param name
     * @param value
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getAunts(String name, String value) throws InvalidArgumentException {
        List<Person> maternal_aunts = new ArrayList(); // mother sisters
        List<Person> paternal_aunts = new ArrayList(); // father sisters
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            List<Person> siblings = getSiblings(person.getName());
            for (Person sibling : siblings) {
                if (RelationshipConstants.GENDER.FEMALE.equals(sibling.getGender())) {
                    paternal_aunts.add(sibling);
                } else {
                    Optional<Person> spouse = Optional.ofNullable(getSpouse(sibling.getName()));
                    if (spouse.isPresent()) {
                        maternal_aunts.add(spouse.get());
                    }

                }
            }
        }
        if(RelationshipConstants.RELATIONSHIPS.PATERNALAUNT.name().equals(value)){
            return paternal_aunts;
        }else{
            return maternal_aunts;
        }

    }

    /**
     * Fetches the uncles(both paternal and maternal) of a particular name from the family tree
     * @param name
     * @param value
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getUncles(String name, String value) throws InvalidArgumentException {
        List<Person> maternal_uncles = new ArrayList(); // mother brothers
        List<Person> paternal_uncles = new ArrayList(); // father brothers
        List<Person> parents = getParents(name);
        for (Person person : parents) {
            List<Person> siblings = getSiblings(person.getName());
            for (Person sibling : siblings) {
                if (RelationshipConstants.GENDER.MALE.equals(sibling.getGender())) {
                    paternal_uncles.add(sibling);
                } else {
                    Optional<Person> spouse = Optional.ofNullable(getSpouse(sibling.getName()));
                    if (spouse.isPresent()) {
                        maternal_uncles.add(spouse.get());
                    }

                }
            }
        }
        if(RelationshipConstants.RELATIONSHIPS.PATERNALUNCLE.name().equals(value)){
            return paternal_uncles;
        }else{
            return maternal_uncles;
        }
    }

    /**
     * Fetches the inlaws(both sister-inlaw and brother-inlaw) of a particular name from the family tree
     * @param name
     * @param value
     * @return
     * @throws InvalidArgumentException
     */
    public List<Person> getInlaws(String name, String value) throws InvalidArgumentException {
        List<Person> sisterinlaws = new ArrayList(); // spouse sister or siblings wife
        List<Person> brotherinlaws = new ArrayList(); // spouse brother or siblings husband
        List<Person> siblings = getSiblings(name);
        for (Person sibling : siblings) {
            if (RelationshipConstants.GENDER.MALE.equals(sibling.getGender())) { //male
                Optional<Person> spouse = Optional.ofNullable(getSpouse(sibling.getName()));
                if (spouse.isPresent()) {
                    sisterinlaws.add(spouse.get());
                }
            }else{ //female
                Optional<Person> spouse = Optional.ofNullable(getSpouse(sibling.getName()));
                if (spouse.isPresent()) {
                    brotherinlaws.add(spouse.get());
                }
            }
        }
        if(RelationshipConstants.RELATIONSHIPS.SISTERINLAW.name().equals(value)){
            return sisterinlaws;
        }else{
            return brotherinlaws;
        }

    }

    /**
     * Fetches the spouse of a particular name from the family tree
     * @param name
     * @return
     * @throws InvalidArgumentException
     */
    private Person getSpouse(String name) throws InvalidArgumentException {
        Person spouse = null;
        Person person = searchPerson(this.rootPerson, name);
        if (person == null) {
            throw new InvalidArgumentException("Invalid argument");
        }
        for (Relationship relation : person.getRelations()) {
            if (RelationshipConstants.FAMILYRELATIONTYPE.SPOUSE.equals(relation.getFamilyRelationType())) {
                spouse = relation.getSecondPerson();
                break;
            }
        }
        return spouse;
    }

}

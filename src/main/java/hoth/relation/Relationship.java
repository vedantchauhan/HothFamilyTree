package hoth.relation;

import hoth.person.Person;
import hoth.utility.RelationshipConstants;

/**
 * Maintains the relationship type between two persons in a family tree.
 *
 * @author Vedant
 */
public class Relationship {

    private RelationshipConstants.FAMILYRELATIONTYPE familyRelationType;
    private Person firstPerson;
    private Person secondPerson;

    public Relationship(RelationshipConstants.FAMILYRELATIONTYPE familyRelationType, Person firstPerson, Person secondPerson) {
        this.familyRelationType = familyRelationType;
        this.firstPerson = firstPerson;
        this.secondPerson = secondPerson;
    }

    public RelationshipConstants.FAMILYRELATIONTYPE getFamilyRelationType() {
        return familyRelationType;
    }

    public void setFamilyRelationType(RelationshipConstants.FAMILYRELATIONTYPE familyRelationType) {
        this.familyRelationType = familyRelationType;
    }

    public Person getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(Person firstPerson) {
        this.firstPerson = firstPerson;
    }

    public Person getSecondPerson() {
        return secondPerson;
    }

    public void setSecondPerson(Person secondPerson) {
        this.secondPerson = secondPerson;
    }
}

package hoth.person;

import java.util.ArrayList;
import java.util.List;
import hoth.relation.Relationship;
import hoth.utility.RelationshipConstants;

/**
 * Person class to keep information about individual member of the family.
 *
 * @author Vedant
 */
public class Person {

    private String name;
    private RelationshipConstants.GENDER gender;
    private List<Relationship> relations = new ArrayList();

    public Person(String name, RelationshipConstants.GENDER gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RelationshipConstants.GENDER getGender() {
        return gender;
    }

    public void setGender(RelationshipConstants.GENDER gender) {
        this.gender = gender;
    }

    public List<Relationship> getRelations() {
        return relations;
    }

    public void setRelations(List<Relationship> relations) {
        this.relations = relations;
    }

    public void addRelation(Relationship relation) {
        relations.add(relation);
    }
}

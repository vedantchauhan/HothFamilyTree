package hoth.utility;

import hoth.person.Person;
import org.junit.Assert;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * JUnit Test class for testing utility class methods
 *
 * @author Vedant
 */
public class RelationshipUtilityTest {

    RelationshipUtility tree = new RelationshipUtility();

    @org.junit.Test
    public void getChildren() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Ish, Chit, Vich, Saty", tree.getChildren("King Shan").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getFather() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals(null, tree.getFather("King Shan"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getMother() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Queen Anga", tree.getMother("Saty").getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getBrothers() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Ish, Chit, Vich", tree.getBrothers("Saty").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getSisters() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Saty", tree.getSisters("Vich").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getSons() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Ish, Chit, Vich", tree.getSons("Queen Anga").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getDaughters() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);

            Assert.assertEquals("Saty", tree.getDaughters("King Shan").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getCousins() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Kriya", tree.getCousins("Misa").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getGrandMother() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals(null, tree.getGrandMother("Ish"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getGrandFather() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Vya", tree.getGrandFather("Kriya").getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getGrandSons() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("", tree.getGrandSons("Lika").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getGrandDaughters() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Lavnya", tree.getGrandDaughters("Lika").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getPaternalAunts() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Saty", tree.getAunts("Vila", "PATERNALAUNT").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getMaternalAunts() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Ambi", tree.getAunts("Vila", "MATERNALAUNT").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getPaternalUncles() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Ish, Vich", tree.getUncles("Drita", "PATERNALUNCLE").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getMaternalUncles() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Vya", tree.getUncles("Drita", "MATERNALUNCLE").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getSisterInLaws() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Lika", tree.getInlaws("Chit", "SISTERINLAW").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void getBrotherInLaws() {
        try{
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Queen Anga", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Ish", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Chit", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Vich", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("King Shan", RelationshipConstants.RELATIONSHIPS.FATHER, "Saty", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Ambi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Lika", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.WIFE, "Vya", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Drita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Chit", RelationshipConstants.RELATIONSHIPS.FATHER, "Vrita", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Vila", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Vich", RelationshipConstants.RELATIONSHIPS.FATHER, "Chika", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Satvy", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Savya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saty", RelationshipConstants.RELATIONSHIPS.MOTHER, "Saayan", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jaya", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Jnki", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Chika", RelationshipConstants.RELATIONSHIPS.WIFE, "Kpila", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Satvy", RelationshipConstants.RELATIONSHIPS.WIFE, "Asva", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Krpi", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.HUSBAND, "Mina", RelationshipConstants.RELATIONSHIPS.WIFE);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Jata", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Drita", RelationshipConstants.RELATIONSHIPS.FATHER, "Driya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Vila", RelationshipConstants.RELATIONSHIPS.FATHER, "Lavnya", RelationshipConstants.RELATIONSHIPS.DAUGHTER);
            tree.addPerson("Savya", RelationshipConstants.RELATIONSHIPS.FATHER, "Kriya", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Saayan", RelationshipConstants.RELATIONSHIPS.FATHER, "Misa", RelationshipConstants.RELATIONSHIPS.SON);
            tree.addPerson("Driya", RelationshipConstants.RELATIONSHIPS.WIFE, "Mnu", RelationshipConstants.RELATIONSHIPS.HUSBAND);
            tree.addPerson("Lavnya", RelationshipConstants.RELATIONSHIPS.WIFE, "Gru", RelationshipConstants.RELATIONSHIPS.HUSBAND);

            Assert.assertEquals("Vya", tree.getInlaws("Chit", "BROTHERINLAW").stream().map(Person::getName)
                    .collect(Collectors.joining(", ")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
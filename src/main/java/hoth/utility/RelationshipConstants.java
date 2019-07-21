package hoth.utility;

/**
 * The class contains constants for the Hoth family tree.
 *
 * @author Vedant
 */
public class RelationshipConstants {

    /**
     * Type of relationship used to associate members of the family tree
     */
    public enum FAMILYRELATIONTYPE {
        SPOUSE, PARENT, CHILD
    }

    /**
     * Gender consideration
     */
    public enum GENDER {
        MALE, FEMALE
    }

    /**
     * Relationship handled in the program
     */
    public enum RELATIONSHIPS {
        FATHER, MOTHER, BROTHER, SISTER, SON, DAUGHTER, CHILDREN, COUSIN, GRANDMOTHER, GRANDFATHER, GRANDSON, GRANDDAUGHTER, PATERNALAUNT, PATERNALUNCLE, MATERNALAUNT, MATERNALUNCLE, SISTERINLAW, BROTHERINLAW, HUSBAND, WIFE
    }

}

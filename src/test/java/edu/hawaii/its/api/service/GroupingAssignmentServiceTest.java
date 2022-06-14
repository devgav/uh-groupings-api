package edu.hawaii.its.api.service;

import org.junit.jupiter.api.Test;
import edu.hawaii.its.api.configuration.SpringBootWebApplication;
import edu.hawaii.its.api.type.Group;
import edu.hawaii.its.api.type.Grouping;
import edu.hawaii.its.api.type.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = { SpringBootWebApplication.class })
public class GroupingAssignmentServiceTest {

    @Value("${groupings.api.person_attributes.username}")
    private String UID;

    @Value("${groupings.api.person_attributes.first_name}")
    private String FIRST_NAME;

    @Value("${groupings.api.person_attributes.last_name}")
    private String LAST_NAME;

    @Value("${groupings.api.person_attributes.composite_name}")
    private String COMPOSITE_NAME;

    @Value("${groupings.api.person_attributes.uhuuid}")
    private String UHUUID;

    @Value("${groupings.api.person_attributes.uhuuid}")
    private String UHUUID_KEY;

    @Value("${groupings.api.person_attributes.username}")
    private String UID_KEY;

    @Value("${groupings.api.person_attributes.first_name}")
    private String FIRST_NAME_KEY;

    @Value("${groupings.api.person_attributes.last_name}")
    private String LAST_NAME_KEY;

    @Value("${groupings.api.person_attributes.composite_name}")
    private String COMPOSITE_NAME_KEY;

    private static final String PATH_ROOT = "path:to:grouping";
    private static final String INCLUDE = ":include";
    private static final String EXCLUDE = ":exclude";
    private static final String OWNERS = ":owners";
    private static final String BASIS = ":basis";
    private static final String BASIS_PLUS_INCLUDE = ":basis+include";

    private static final String GROUPING_INCLUDE = PATH_ROOT + INCLUDE;
    private static final String GROUPING_EXCLUDE = PATH_ROOT + EXCLUDE;
    private static final String GROUPING_BASIS = PATH_ROOT + BASIS;
    private static final String GROUPING_OWNERS = PATH_ROOT + OWNERS;
    private static final String GROUPING_BASIS_PLUS_INCLUDE = PATH_ROOT + BASIS_PLUS_INCLUDE;
    private static final String USERNAME = "user";

    private static final String GROUPING_0_PATH = PATH_ROOT + 0;

    @Autowired
    private GroupingAssignmentService groupingAssignmentService;
    private MemberAttributeService memberAttributeService;

    @Test
    public void construction() {
        //autowired
        assertNotNull(groupingAssignmentService);
    }

    private Grouping grouping() {
        Grouping grouping = new Grouping("test:ing:me:bob");

        Group basisGroup = new Group();
        basisGroup.addMember(new Person("b0-name", "b0-uuid", "b0-username"));
        basisGroup.addMember(new Person("b1-name", "b1-uuid", "b1-username"));
        basisGroup.addMember(new Person("b2-name", "b2-uuid", "b2-username"));
        grouping.setBasis(basisGroup);

        Group exclude = new Group();
        exclude.addMember(new Person("e0-name", "e0-uuid", "e0-username"));
        grouping.setExclude(exclude);

        Group include = new Group();
        include.addMember(new Person("i0-name", "i0-uuid", "i0-username"));
        include.addMember(new Person("i1-name", "i1-uuid", "i1-username"));
        grouping.setInclude(include);

        Group owners = new Group();
        owners.addMember(new Person("o0-name", "o0-uuid", "o0-username"));
        owners.addMember(new Person("o1-name", "o1-uuid", "o1-username"));
        owners.addMember(new Person("o2-name", "o2-uuid", "o2-username"));
        owners.addMember(new Person("o3-name", "o3-uuid", "o3-username"));
        grouping.setOwners(owners);
        
        Set<Person> set = new LinkedHashSet<>(grouping.getBasis().getMembers());
        set.addAll(grouping.getBasis().getMembers());
        Group testGroup = new Group();
        for (Person person : set) {
            testGroup.addMember(person);
        }
        grouping.setComposite(testGroup);

        return grouping;
    }
    
    @Test
    public void assignMemberToGroupTest() {
        GroupingAssignmentServiceImpl gas = new GroupingAssignmentServiceImpl() {
            public MemberAttributeService getMemberAttributeService() {
                return null;
            }
        };
    }
}

package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solutions.basics.immutable.ImmutableUser;

public class PureFunctionsTest {

    @Test
    public void testPureFunction() {
        List<ImmutableUser> allPeople = new ArrayList<>();
        allPeople.addAll(getTheFlintstones());
        allPeople.addAll(getTheRubbles());
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private List<ImmutableUser> getTheFlintstones() {
        List<ImmutableUser> flintstones = new ArrayList<>();
        
        flintstones.add(ImmutableUser.of("Fred", "Flintstone"));
        flintstones.add(ImmutableUser.of("Wilma", "Flintstone"));

        return flintstones;
    }

    private List<ImmutableUser> getTheRubbles() {
        List<ImmutableUser> rubbles = new ArrayList<>();
        
        rubbles.add(ImmutableUser.of("Barney", "Rubble"));
        rubbles.add(ImmutableUser.of("Betty", "Rubble"));

        return rubbles;
    }
}

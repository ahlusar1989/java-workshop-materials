package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import solutions.basics.immutable.ImmutableUser;

public class ImpureFunctionsTest {

    @Test
    public void testImpureFunction() {
        List<ImmutableUser> allPeople = new ArrayList<>();
        addTheFlintstones(allPeople);
        addTheRubbles(allPeople);
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private void addTheFlintstones(List<ImmutableUser> people) {
        people.add(ImmutableUser.of("Fred", "Flintstone"));
        people.add(ImmutableUser.of("Wilma", "Flintstone"));
    }

    private void addTheRubbles(List<ImmutableUser> people) {
        people.add(ImmutableUser.of("Barney", "Rubble"));
        people.add(ImmutableUser.of("Betty", "Rubble"));
    }
}

package examples.basics.pure_functions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import solutions.basics.immutable.ImmutableUser;

public class PurePureFunctionsTest {

    @Test
    public void testPureFunction() {
        List<ImmutableUser> allPeople = Stream.of(getTheFlintstones(), getTheRubbles())
                .flatMap(Function.identity())
                .collect(Collectors.toList());
        
        assertThat(allPeople.size()).isEqualTo(4);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(3).getFirstName()).isEqualTo("Betty");
    }
    
    private Stream<ImmutableUser> getTheFlintstones() {
        return Stream.of(ImmutableUser.of("Fred", "Flintstone"),
                ImmutableUser.of("Wilma", "Flintstone"));
    }

    private Stream<ImmutableUser> getTheRubbles() {
        return Stream.of(ImmutableUser.of("Barney", "Rubble"),
                ImmutableUser.of("Betty", "Rubble"));
    }
}

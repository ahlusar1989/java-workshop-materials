package solutions.basics.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ImmutableUser {
    private String firstName;
    private String middleName;
    private String lastName;
    private List<String> nickNames;
    
    private ImmutableUser(Builder builder) {
        firstName = Objects.requireNonNull(builder.firstName);
        middleName = builder.middleName;
        lastName = Objects.requireNonNull(builder.lastName);
        nickNames = Objects.requireNonNull(builder.nickNames);
    }
    
    // copy constructor - for the with*** methods
    private ImmutableUser(ImmutableUser other) {
        firstName = other.firstName;
        middleName = other.middleName;
        lastName = other.lastName;
        nickNames = new ArrayList<>(other.nickNames);
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Stream<String> nickNames() {
        return nickNames.stream();
    }
    
    public ImmutableUser withMiddleName(String middleName) {
        ImmutableUser copy = new ImmutableUser(this);
        copy.middleName = middleName;
        return copy;
    }

    public ImmutableUser withNickName(String nickName) {
        ImmutableUser copy = new ImmutableUser(this);
        copy.nickNames.add(nickName);
        return copy;
    }
    
    public ImmutableUser withNickNames(String...nickNames) {
        ImmutableUser copy = new ImmutableUser(this);
        copy.nickNames.addAll(Arrays.asList(nickNames));
        return copy;
    }
    
    public static ImmutableUser of(String firstName, String lastName) {
        return new Builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();
    }
    
    public static class Builder {
        private String firstName;
        private String middleName;
        private String lastName;
        private List<String> nickNames = new ArrayList<>();

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder withNickName(String nickName) {
            nickNames.add(nickName);
            return this;
        }
        
        public Builder withNickNames(List<String> nickNames) {
            this.nickNames.addAll(nickNames);
            return this;
        }
        
        public ImmutableUser build() {
            return new ImmutableUser(this);
        }
    }
}

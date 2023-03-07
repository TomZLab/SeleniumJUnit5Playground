package testHelpers.pojos;

import lombok.Getter;

@Getter
public class TestEnvironment {

    private String browser;
    private Boolean headless;
    private String url;
    private String username;
    private String password;
}

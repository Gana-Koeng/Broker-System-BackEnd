package csx.broker.WebController;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class provides a method to authenticate a user.
 */
public class auth {
    private static final Logger LOGGER = Logger.getLogger(auth.class.getName());
    private static final String USERNAME_PROMPT = "Please enter your username: ";
    private static final String PASSWORD_PROMPT = "Please enter your password: ";
    private static final String SUCCESS_MESSAGE = "Authentication successful!";
    private static final String FAILURE_MESSAGE = "Authentication failed!";

    private Map<String, String> userCredentials;

    /**
     * Constructor for Authentication class.
     */
    public auth() {
        userCredentials = new HashMap<>();
    }

    /**
     * Adds a user to the authentication system.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    /**
     * Authenticates a user.
     *
     * @return true if authentication is successful, false otherwise.
     */
    public boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(USERNAME_PROMPT);
        String username = scanner.nextLine();
        System.out.print(PASSWORD_PROMPT);
        String password = scanner.nextLine();

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            LOGGER.info(SUCCESS_MESSAGE);
            return true;
        } else {
            LOGGER.warning(FAILURE_MESSAGE);
            return false;
        }
    }
}
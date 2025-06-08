@api
Feature: Sign In with Email and Password
  As a registered user
  I want to be able to sign in using my email and password
  So that I can access my account securely


  @positive @smoke
  Scenario Outline: Valid user logs in successfully with correct email and password
    Given existing user trying to login
    When I send a POST request to "/auth/sign-in" with username "<email>" and "<password>"
    Then the response status code should be <status_code>
    And the response should contain a valid authentication token
    And the username of user should be "<username>"
    And the role of user should be "<role>"
    Examples:
      | email                | password     | status_code | username          | role     |
      | john.doe@example.com   | NewPass@123    | 200         | John Doe  | CUSTOMER |
      | waiter@green.com     | NewPass@789  | 200         | Waiter Smith      | WAITER   |

  @negative @regression
  Scenario Outline: User login fails with invalid or missing credentials
    When I send a POST request to "/auth/sign-in" with username "<email>" and "<password>"
    Then the response status code should be <status_code>
    And the response should contain message "<message>"
    Examples:
      | email                    | password       | status_code | message                                                              |
      | sachin@example.com       | Wrong10!       | 401         | Authentication failed: User not exist                                                 |
      | sachin@example.com       |                | 400         | Password is required. Please enter your password to continue.       |
      | nonexistent@example.com  | Wrong10!       | 401         | Authentication failed: User not exist                                |
      |                          | PassWrong10!   | 400         | Email address is required. Please enter your email to continue.     |
      | invalidformat.com        | PassWord10!    | 400         | Invalid email format. Please enter a valid email address.           |
      | test@ex@ample.com        | Pass1234!      | 400         | Invalid email format. Please enter a valid email address.           |

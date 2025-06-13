@TalkModule
Feature: Talk Module Functionality

  Agile Story : As a user, I should be able to create a new conversation,
  add participant, start and leave call under the Talk module

  Background: User should have already logged in and clicked on the talk module.
    # Then the user should see the url contains "/index.php/apps"
    Given the user is logged in with "submitButton"
    When User clicks on Talk module from the top menu

  @CreatingGroup
  Scenario: User can create a new conversation
    When user click on create a new group conversation button
    And create a conversation name as "Group QA Testers"
    Then user should add some users as "Employee1", "Employee10", "Employee100" from the pop-up window
    Then user can see created conversation as "Group QA Testers" in the list
    # should be able to add / do
  # only assertion / verification situation, use @Then
  @AddingUser
  Scenario Outline: User can add any participants to an existing conversation
    When user selects any existing conversation in the list
    And user types any user's name into the participants search box "<username>"
    Then the user should be able to select the new participant with its "<username>"
    Then user should see the new participant's "<username>" on the participants list

    Examples:
      | username    |
      | Employee101 |
      | Employee103 |
      #| Employee103 |
      #| Employee107 |

  @CallFeature
  Scenario: user should be able to start a call
    When user selects any existing conversation in the list
    Then user should be able to start a call by clicking on start a call button
    And user should be able to end a call by clicking on leave call button
    Then user should come back to the chat page


  @DeletingChat
  Scenario: user can delete any of the conversations
    When user click on create a new group conversation button
    And create a conversation name as "DevOps Team"
    Then user should add some users as "Employee1", "Employee10", "Employee100" from the pop-up window
    Then user can see created conversation as "DevOps Team" in the list
    When user clicks the three dot icon of the created conversation as "DevOps Team"
    Then user should be able to see and click delete conversation button
    Then user should not see the deleted conversation "DevOps Team" in the conversation list






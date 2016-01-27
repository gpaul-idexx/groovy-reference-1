Feature: show pets

  Scenario: Dave wants to see all his pets
    Given Dave has 3 pets named Rover, Buddy and Jack
    When Dave retrieves his list of pets
    Then It should include Rover, Buddy and Jack
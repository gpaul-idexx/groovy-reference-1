Feature: show pets

  We need to be able to retrieve the pets

  Scenario: Dave wants to see all his pets
    Given Dave has 3 pets named:
      | Rover |
      | Buddy |
      | Jack  |
    When Dave retrieves his list of pets
    Then It should include:
      | Rover |
      | Buddy |
      | Jack  |

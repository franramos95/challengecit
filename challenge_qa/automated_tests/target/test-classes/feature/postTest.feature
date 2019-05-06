Feature: Test POST/posts

  Scenario Outline: Title of your scenario outline
    Given I want to write post using user <userId>
    When I call the Api put the title <title>
    Then I verify the <status> of the post

    Examples: 
      | userId  | title  |status   |
      |    1    | "test" | 201     |
      |    1    |  null  | 400     |

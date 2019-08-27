Feature: Create a project

  Scenario Outline: Create a simple project
    Given the rulling "<type>".
    Given the session is open.
     When user "<user>" vote "<vote_value>".
     When the session is closed.
     Then the total of votes fo this session is "<votes>".

    Examples: 
      | type    						| user        | vote_value      | votes 	|
      | rulling-nao					| 99999999999 | SIM			 			  | 1       |
      | rulling-sim					| 99999999999 | NÃO			 			  | 1       |
      

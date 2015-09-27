Story: The Berlin Clock

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time


Scenario: Berlin Uhr displays midnight time - 00:00:00
Given it's 00:00:00 o'clock now
Then the Berlin Uhr looks like:
 | Berlin Uhr  |
 | Y           |
 | OOOO        |
 | OOOO        |
 | OOOOOOOOOOO |
 | OOOO        |


Scenario: Berlin Uhr displays afternoon time - 13:17:01
Given it's 13:17:01 o'clock now
Then the Berlin Uhr looks like:
 | Berlin Uhr  |
 | O           |
 | RROO        |
 | RRRO        |
 | YYROOOOOOOO |
 | YYOO        |


Scenario: Berlin Uhr displays before midnight time - 23:59:59
Given it's 23:59:59 o'clock now
Then the Berlin Uhr looks like:
 | Berlin Uhr  |
 | O           |
 | RRRR        |
 | RRRO        |
 | YYRYYRYYRYY |
 | YYYY        |

 
Scenario: Berlin Uhr displays midnight time - 24:00:00
Given it's 24:00:00 o'clock now
Then the Berlin Uhr looks like:
 | Berlin Uhr  |
 | Y           |
 | RRRR        |
 | RRRR        |
 | OOOOOOOOOOO |
 | OOOO        |
 
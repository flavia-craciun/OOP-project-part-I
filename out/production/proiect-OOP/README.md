# Proiect - Etapa 1 - Santa Claus is coming to ACS students

After parsing the input and loading it into the classes from the input package, a list of children
is created. For round 0, after deciding each child's (from santa's list) age, if the
child isn't a young adult, they are added to the list. Afterwards, the assigned budget is
calculated and based on the child's preferences and the budget, the gifts are being given out. For
the following years, a new list is made every year and the children who have yet to become
young adults, are added to the new list and their preferences, nice score history and age are being
updated. The new list of children from the annual change is appended to the list. A new budget is
assigned to each child and as per round 0, the gifts are being given out according to the children's
preferences. The output consists of the final "Nice List" that contains all the lists of children
from all years.

## SRC Package

### Input
These classes will not be modified.

AnnualChange
- loads from the input files
- stores:
  - new santa budget
  - list of new gifts
  - list of new children
  - list of updated for the already existing children

ChildInput
- loads from the input files
- stores:
  - id
  - last name
  - first name
  - age
  - city
  - nice score
  - list of gifts preferences

ChildUpdate
- loads from the input files
- stores:
    - id
    - nice score
    - list of gifts preferences

InitialData
- loads from the input files
- stores:
  - list of children
  - list of gifts
  - list of cities

InputData
- loads from the input files
- stores:
  - the number of years the list is taken in account for
  - initial santa budget
  - instace of initialData
  - a list of annual changes

### Gifts
DeliverPresents
- abstract class that implements methods used for giving out gifts
- methods:
  - calculateBudgetUnit 
  - getGifts
  - getGiftsFromCategory
  - sortByPrice

Gifts
- stores:
  - product name
  - price
  - category

### Nice list
Child
- main class to store initial and updated data about a child
- has two constructors: one used in round 0 and another used for the yearly rounds
- implements abstract method calculateAverage used by the sub-classes to calculate the average nice score
- stores:
  - id
  - last name
  - first name
  - age
  - city
  - average nice score
  - nice score history
  - list of gifts preferences
  - assigned budget
  - received gifts

NiceList
- represents the final list with children from every year
- stores:
  - a list of lists of children (list of annual children)
  - 
#### Ages
  
AgeRangeFactory
- uses factory method to sub-class the age categories of the children
- the method is implemented twice to be used in both types of the rounds

Baby
- extends class Child
- has two constructors for the two types of rounds
- overrides method calculateAverageScore to return 10.0

Kid
- extends class Child
- also has two constructors for the two types of rounds
- overrides method calculateAverageScore to calculate the arithmetic mean of all the nice
scores in the child's nice score history

Teen
- extends class Child
- also has two constructors for the two types of rounds
- overrides method calculateAverageScore to calculate the ponderate mean of all the nice
  scores in the child's nice score history as follows:
e.g. list = [7, 8, 9] => averageScore = (7 * 1 + 8 * 2 + 9 * 3) / (1 + 2 + 3)

YoungAdult
- extends class Child
- also has two constructors for the two types of rounds
- overrides method calculateAverageScore, but doesn't return anything as Young Adults will
not be added to the nice list

#### Rounds
AnnualChildren
- abstract class
- stores the list of children from a year
- implements getAgeRange method

Round0
- extends AnnualChildren
- methods:
  - makeNiceList
  - calculateAge
  - checkIfYoungAdult
  - receiveGifts

YearlyRound
- extends AnnualChildren
- methods:
  - makeNiceList
  - calculateAge
  - checkIfYoungAdult
  - receiveGifts
  - childrenUpdate
  - updatePreferences
  - updateSantaGiftList

### Main
Main
- creates the directory for the output files
- parses the input from the json files
- entry-point
- writes the results in the output files
- calculates the score







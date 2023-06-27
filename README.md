# Stream API Practicing
 
## This Java project contains services needed to implement, see `org.mentoring.practice.stream.service.impl` package. <br> The implementations are covered with unit tests to check the correctness.

### Issues
* CollectionMathService:
  - `<T extends Comparable<T>> T max(List<T> list)` - calculating maximum value of the list
  - `<T extends Comparable<T>> T min(List<T> list)` - calculating minimum value of the list
  - `Double sum(List<Double> list)` - calculating sum of all elements in the list
  - `Double avg(List<Double> list)` - calculating average value of the list
  - `Integer countEven(List<Integer> list)` - calculating count of event numbers in the list
  - `Integer countOdd(List<Integer> list)` - calculating count of odd numbers in the list
  - `Long multiply(List<Integer> list)` - calculating multiplying of all elements in the list
* EmployeeService:
  - `List<Contract> raiseSalaryOnPercentFor(double percent, MajorityLevel majority)` - filter employees by majority, extract Contract entity, and update the salary inside
  - `Employee findEmployeeWithHigherSalary(MajorityLevel majority)` - filter employees by majority and return the one with maximum value of the salary
  - `Map<MajorityLevel, Double> findAverageSalaryByMajority()` - group employees by majority and calculate average salary per each group
* ListJoiner:
  - `<T> List<T> join(List<List<T>> subLists)` - extract values of all sublist into the unique one
* ListSplitter:
  - `<T> List<List<T>> split(List<T> list, int subListSize)` - split a given list into sublists of a given size, handle null as an empty list
* RangeGenerator:
  - `List<Integer> createRangeList(int from, int to, int step)` - generate a sequence of numbers within `from` and `to` bounds inclusive considering a given `step`
  - `List<Integer> createRangeList(int from, int to)` - generate a sequence of numbers within `from` and `to` bounds inclusive considering `step` equal to 1
<hr>

### All the task must be done with Stream API.
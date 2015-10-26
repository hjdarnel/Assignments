
#Assignments for Algorithms
![Part 1](http://i.imgur.com/4JLuWnc.png)

![Part 2](http://i.imgur.com/2GNbIk8.png)

This was a two-part assignment. The first part was to parse simple inputs and perform easy calculations on them. Simple enough, I just found the operator, substringed the first half and second half into two different ints, and used a switch to perform the desired operation on the LHS or RHS.

The second half of the assignment was much more complex. It involved implementing Strassman's Algorithm for matrix multiplication, which is much different and more efficient than the way to multiply matrices that everyone is taught. This is achieved by only having to calculate 7 intermediate values, and then using those values to determine the result. The intermediate values only require 7 multiplications, versus the 8 required of the gradeschool algorithm. While this does
add around 15 additions to the calculation, we still are more efficiient by using Strassman's, because multiplication is much more "expensive" than addition. 

This was tested using the given test case, however that test case is size 2^2 x 2^2, which is below the threshold asked for in the assignment. Because of this, the algorithm is only performing simple multiplication on the matrix of this size. To get around this, I made my own matrix of size 2^4 x 2^4, and lowered the threshold from 2^6 to 2^3. I calculated the result using the gradeschool method and the Strassman's algorith, and the result was the same. Therefore my
implemenetation of the algorithm is correct.

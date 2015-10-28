##Assignment 3 - Black/White Painting and Palindromic Arrays
![Part 1](http://i.imgur.com/3v6YPDO.png)
![Part 2](http://i.imgur.com/tj10MSQ.png)
#Part A
For this part, we needed to find the most efficient way to "repaint" several tiles, represented by a string input, such that all Black tiles are to the left of the White tiles, or earlier in the string. In practice, this means we need to find a way to change the tiles the fewest amount of times such that we fit the constraints.

To do this, I go through every possible "pivot point" in the string. This is just a for loop through the string. From a given pivot, we check how many swaps we would need to change all "w"s to "B"s to the left of the pivot point, and all "B"s to "W"s to the right of the pivot point. We add the number of swaps together, and store it in an ArrayList. After looping through every possible pivot point, we find the minimum sum, which is the fewest number of swaps needed to fit our constraints.

#Part B
For the second part, which is unrelated to the first, we needed to find the number of steps needed to make a palindromic sequence from a given sequence of integers. We were able to alter the sequence by adding adjacent elements in the sequence. To do this, we needed to look at the logic one follows when making a palindrome.

To start, the outermost elements must be equal, before we can look at the second-outermost. So we compare the outermost values. We set "pointer" integers to aim at the two values being compared. If one value is smaller than the other, then we add the smaller value to its adjacent element, and compare again. When adding two numbers together, we add the two values together, set that sum to the value of the more central element, and remove the other element. If the two values are the same, then we simply increment the lower pointer and decrement the higher pointer. We do this while the lower pointer is less than the higher pointer. When the pointers are equal, then we have gone through the entire sequence, and the sequence is palindromic.

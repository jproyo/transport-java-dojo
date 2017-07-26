# Trans Problem Comments

My solution basically is based on a Graph design where the Graph contains all the previously loaded routes.

## Wrong answers in Proposed Output Input

There are a couple of things i have found wrongly in the input and output data.

- In point 7 where it says *The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).*, result should be 2 and not 3 as the proposed output, because *A to C (via D,C,D)* repeats last stop and we are entering in a looping mode. In that way we could indefinitely looping and there is no way to be sure when the route terminates.

- In point 9 where it says *The length of the shortest route (in terms of distance to travel) from B to B.* Output should be **9**, it should be 21 according to weight of the nodes proposed.

- In point 10 where it says *The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.* output should be 6 assuming the same no looping mode between stations.

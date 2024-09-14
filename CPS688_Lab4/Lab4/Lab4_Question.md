Lab Instructions:

Problem 1 – Maximum Bipartite Matching-------------------------------------------------------------

It is the hiring season and many companies have already started looking for applicants to fill
positions. There are M job applicants and N jobs. Each applicant has a subset of jobs that he/she
is interested in. Each job opening can only accept one applicant and a job applicant can be
appointed for only one job. Implement and use the Ford-Fulkerson Algorithm for Maximum
Flow Problem to find the assignment of jobs to applicants such that as many applicants as
possible get jobs as shown below.

Steps:

1. Convert the problem into a Flow Network: Add a source and add edges from the source
to all applicants. Similarly, add edges from all jobs to the target. The capacity of every
edge is marked as 1.
2. Find the maximum flow: Use the Ford-Fulkerson algorithm to find the maximum flow in
the flow network built in step 1. The maximum flow is the maximum bipartite matching
we are looking for.

Input
Your program will be tested against multiple test cases. Each test case includes the adjacency
list representation of the problem.

Output
For each test case, determine the maximum number of applicants matching the jobs.

Sample Input
0 1 1 0 0 0
0 0 0 0 0 0
1 0 0 1 0 0
0 0 1 0 0 0
0 0 1 1 0 0
0 0 0 0 0 1

Sample Output
The maximum number of applicants matching for
the jobs is 5
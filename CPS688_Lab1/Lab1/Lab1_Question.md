Lab Instructions:

Use the Java language to implement a Graph using an adjacency list.
Provide implementations of the methods below:

• Add an edge between two vertices a and b. [ addEdge(a,b) ]
• Compute the degree of a vertex a. [ degreeVertex(a) ] //returns the number of
neighbors for a given vertex a.
• Print the adjacent vertices of a vertex a. [ printAdjVertices(a) ]

Given an undirected graph, you are required to create its corresponding adjacency list using the
Graph implementation above and print its vertices using Breadth First Search [ BFS ] and Depth
First Search [ DFS ].

Input
Each test case consists of two integers n and e, representing the number of vertices and edges
respectively. The next e lines represent the vertices that are connected by an edge.

Output
For each test case, print the graph using both BFS and DFS.

Sample Input
6 6
0 1
0 3
1 2
2 4
3 4
3 5
Sample Output (BFS)
0 1 3 2 4 5 ...
Sample Output (DFS)
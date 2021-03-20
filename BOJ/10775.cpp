#include <stdio.h>
#define MAX_SIZE 100005

int G, P, plain, parent[MAX_SIZE];

int findParent(int u)
{
	if (u == parent[u]) return u;
	return parent[u] = findParent(parent[u]);
}

int main()
{
	scanf("%d %d", &G, &P);
	for (register int i = 0; i <= G; i++) parent[i] = i;
	
	int res = 0;
	for (register int i = 0; i < P; i++) {
		scanf("%d", &plain);
		int r = findParent(plain);
		if (r == 0) break;

		res++;
		parent[r] = r - 1;
	}

	printf("%d\n", res);
	return 0;
}
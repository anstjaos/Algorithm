#include <stdio.h>

int parent[202], N, M, input, course[1005];

int findParent(int u)
{
	if (u == parent[u]) return u;
	return parent[u] = findParent(parent[u]);
}

void unionSet(int u, int v)
{
	int uParent = findParent(u);
	int vParent = findParent(v);

	if (uParent == vParent) return;

	if (uParent < vParent) parent[vParent] = uParent;
	else parent[uParent] = vParent;
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 1; i <= N; i++) parent[i] = i;
	for (register int i = 1; i <= N; i++) {
		for (register int j = 1; j <= N; j++) {
			scanf("%d", &input);
			if(input == 1) unionSet(i, j);
		}
	}

	for (register int i = 0; i < M; i++) scanf("%d", course + i);
	int before = course[0], cur;
	for (register int i = 1; i < M; i++) {
		cur = course[i];
		if (parent[before] != parent[cur]) {
			printf("NO\n");
			return 0;
		}
		
		before = cur;
	}

	printf("YES\n");
	return 0;
}
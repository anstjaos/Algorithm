#include <cstdio>

int tc, friends[11][11], res, n, m, a, b;
bool check[11];

int countPair()
{
	int first = -1;
	for (register int i = 0; i < n; i++) {
		if (check[i] == false) {
			first = i;
			break;
		}
	}

	if (first == -1) return 1;
	int ret = 0;
	for (register int j = first + 1; j < n; j++) {
		if (!check[j] && friends[first][j] != 0) {
			check[first] = check[j] = true;
			ret += countPair();
			check[first] = check[j] = false;
		}
	}
	return ret;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		scanf("%d %d", &n, &m);
		for (register int i = 0; i < n; i++)
		{
			check[i] = false;
			for (register int j = 0; j < n; j++) {
				friends[i][j] = friends[j][i] = 0;
			}
		}
		for (register int i = 0; i < m; i++) {
			scanf("%d %d", &a, &b);
			friends[a][b] = 1;
			friends[b][a] = 1;
		}

		printf("%d\n", countPair());
	}
	return 0;
}